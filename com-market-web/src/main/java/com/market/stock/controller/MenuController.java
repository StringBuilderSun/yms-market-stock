/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.controller;

import com.market.stock.annotation.SayHiAnnotation;
import com.market.stock.model.DTO.Order;
import com.market.stock.service.UserOrderService;
import com.market.stock.serviceImpl.StockManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author lijinpeng
 * @version Id: MenuController.java, v 0.1 2018/5/15 20:52 lijinpeng Exp $$
 */
@Slf4j
@Controller
public class MenuController {
    @Autowired
    private StockManagerService stockManagerService;
    @Autowired
    private UserOrderService orderService;

    @RequestMapping(value = "/add")
    @SayHiAnnotation(word = "我是自定义注解", tag = "注解啦")
    public String addService() {
        Order newOrder = new Order();
        newOrder.setRemark("测试订单");
        newOrder.setAmount(20000);
        newOrder.setCreatedate(new Date());
        newOrder.setMchntid("10001");
        newOrder.setOrderno("2018091212312");
        newOrder.setProductid("100002");
        newOrder.setUserid(20);
        newOrder.setPrice(100.0);
        orderService.addUserAndSaveOrder(newOrder);
        return "helloMenu";
    }
}

