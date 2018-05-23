/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.controller;

import com.market.stock.annotation.AnnotationUtil;
import com.market.stock.annotation.SayHiAnnotation;
import com.market.stock.enums.RequestType;
import com.market.stock.enums.TablesEnum;
import com.market.stock.model.DTO.User;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.service.StockManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lijinpeng
 * @version Id: MenuController.java, v 0.1 2018/5/15 20:52 lijinpeng Exp $$
 */
@Slf4j
@Controller
public class MenuController {
    @Autowired
    private StockManagerService stockManagerService;

    @RequestMapping(value = "/add")
    @SayHiAnnotation(word = "我是自定义注解", tag = "注解啦")
    public String addService() {
        AnnotationUtil.getAnnotationService(MenuController.class);
        StockManagerRequest request = new StockManagerRequest();
        User user = new User();
        user.setCity("上海");
        user.setCreatedAt(new Date());
        user.setCreatedBy("李金鹏");
        user.setUpdatedAt(new Date());
        user.setUpdatedBy("李金鹏");
        user.setEmail("957143335@qq.com");
        user.setRemark("备注啦");
        user.setUname("王小飞");
        user.setUserLevel("00");
        user.setPhone("18939573486");
        request.setDataModel(user);
        request.setRequestType(RequestType.INSERT);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        StockManagerResponse response = stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        return "helloMenu";
    }

    @RequestMapping(value = "/singleQuerg")
    public String selectSingleService() {
        StockManagerRequest request = new StockManagerRequest();
        User user = new User();
        user.setUid(13);
        request.setDataModel(user);
        request.setRequestType(RequestType.SingleQuery);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        StockManagerResponse response = stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        User result = response.getResponseModel();
        log.info("result:{}", result.toString());
        return "helloMenu";
    }

    @RequestMapping(value = "/queryList")
    public String showMenu() {
        StockManagerRequest request = new StockManagerRequest();
        User user = new User();
        request.setDataModel(user);
        request.setRequestType(RequestType.ListQuery);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        StockManagerResponse response = stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        List<User> list = response.getResponseModel();
        log.info("查询到的结果数量:{}", list.size());
        log.info("result:{}", list.size());
        return "helloMenu";
    }

    @RequestMapping(value = "/update")
    public String updateService() {
        StockManagerRequest request = new StockManagerRequest();
        User user = new User();
        user.setUid(9);
        user.setCity("上海");
        user.setCreatedAt(new Date());
        user.setCreatedBy("萧何2222");
        user.setUpdatedAt(new Date());
        user.setUpdatedBy("李金鹏");
        user.setEmail("957143334@qq.com");
        user.setRemark("备注啦");
        user.setUname("王小飞11");
        user.setUserLevel("00");
        user.setPhone("18636853487");
        user.setSex(false);
        request.setDataModel(user);
        request.setRequestType(RequestType.UPDATE);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        StockManagerResponse response = stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        Integer result = response.getResponseModel();
        log.info("result:{}", result);
        return "helloMenu";
    }

    @RequestMapping(value = "/del")
    public String deleteService() {
        StockManagerRequest request = new StockManagerRequest();
        User user = new User();
        user.setUid(11);
        request.setDataModel(user);
        request.setRequestType(RequestType.DELETE);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        StockManagerResponse response = stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        Integer result = response.getResponseModel();
        log.info("result:{}", result);
        return "helloMenu";
    }
}

