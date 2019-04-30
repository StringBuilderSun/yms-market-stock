package com.market.stock.threadTasks;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by lijinpeng on 2019/3/29.
 */
public class GetSpeekGood {

    public String getGoods(String key, Redisson redisson, String name) {
        RLock lock = redisson.getLock("test_key");
        try {
            lock.lock(2, TimeUnit.SECONDS);
            RBucket<Object> bucket = redisson.getBucket(key);
            Object o = bucket.get();
            Integer value = Integer.valueOf(String.valueOf(o));
            if (value >= 1) {
                bucket.set(value - 1);
                return "恭喜你抢到了序号为:" + value + "的商品！";
            }
        } catch (Throwable ex) {
            System.out.println("抛异常了...." + ex);

        } finally {
            lock.unlock();
        }

        return "不好意思，您手速慢了！";
    }
}
