package com.market.stock.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.market.stock.ThreadUtils.ThreadPools;
import com.market.stock.model.DTO.Order;
import com.market.stock.threadTasks.SpeedKillTask;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lijinpeng on 2019/3/29.
 */
@Controller
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Autowired
    private Redisson redisson;

    @RequestMapping(method = RequestMethod.GET)
    public String redis() {
        return "redis";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String setRedisValue(@RequestParam String redis_key, @RequestParam String redis_value) {
        System.out.println("key:" + redis_key + " value:" + redis_value);
        try {
            RBucket<Object> bucket = redisson.getBucket(redis_key);
            bucket.set(redis_value);
            log.info("插入成功！");
        } catch (Exception ex) {
            log.error("插入失败！", ex);
        }
        return "helloMenu";
    }

    @RequestMapping(value = "/get")
    public String getRedisValue(@RequestParam String redis_key) {
        try {
            RBucket<Object> bucket = redisson.getBucket(redis_key);
            Object o = bucket.get();
            System.out.println("查询到数据:" + o);
            testRedison();
        } catch (Exception ex) {
            System.out.println("插入失败！" + ex);
        }
        return "helloMenu";
    }

    @RequestMapping("/speedkill")
    @ResponseBody
    public String SpeedKill() throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 1000; i++) {
            SpeedKillTask task = new SpeedKillTask("用户:" + i, redisson);
            Future<String> task_result = ThreadPools.getInstance().submit(task);
            futures.add(task_result);
        }
        //休息5秒确认所有任务执行完成
        StringBuilder sb = new StringBuilder();
        for (Future<String> task : futures) {
            while (true) {
                if (task.isDone()) {
                    String result = task.get();
                    sb.append(result + "\r\n");
                    System.out.println(result);
                    break;
                }
            }
        }
        return sb.toString();
    }

    @RequestMapping("/getKeys")
    @ResponseBody
    public String getRedisValues() throws IOException {
        RKeys rKeys = redisson.getKeys();
        Iterable<String> keys = rKeys.getKeys();
        log.info("redis集群中总共存的key的数量:{}", rKeys.count());
        StringBuilder appender = new StringBuilder();
        for (String key : keys) {
            log.info("key:{}", key);
            appender.append(key).append("/r/n");
        }
        RMap<String, String> person = redisson.getMap("person");
        for (String file : person.keySet()) {
            log.info("person-{}:{}", file, person.get(file));
        }
        Order order = new Order();
        order.setPrice(1000);
        order.setRemark("摘要");
        order.setOrderno("201901028122");
        order.setId(123);
        RBucket<Order> redis_order = redisson.getBucket("order");
        boolean setResut = redis_order.trySet(order);
        Object objec = redis_order.get();
        log.info("设值状态:{}  value：{}", setResut, objec);
        JSONObject jsonObject = JSON.parseObject(objec.toString());
        log.info("jsonObject:{}", jsonObject);
        testStream();
        return appender.toString();
    }

    public void testRedison() {
        RAtomicLong atomicLong = redisson.getAtomicLong("atomicLong");
        boolean result = atomicLong.compareAndSet(3, 100);
        log.info("atomicLong 取值结果:{}", result);
    }

    public void testStream() throws IOException {
        RBinaryStream redisson_stream = redisson.getBinaryStream("redisson_stream");
        redisson_stream.set("test_read".getBytes());
        InputStream inputStream = redisson_stream.getInputStream();
        byte[] buffer = new byte[512];
        inputStream.read(buffer);
        String value = new String(buffer);
        log.info("通过流写入的数据:{}",value);
        OutputStream outputStream = redisson_stream.getOutputStream();
        outputStream.write("test_write".getBytes());
        inputStream.close();
        outputStream.close();
    }

}
