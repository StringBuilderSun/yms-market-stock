/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.controller;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.TablesEnum;
import com.market.stock.mapper.UserMapper;
import com.market.stock.model.RunOob;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.model.User;
import com.market.stock.service.StockManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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
    @Autowired
    private UserMapper userMapper;

    //    @RequestMapping(value = "/start")
//    public String showMenu() {
//        StockManagerRequest request = new StockManagerRequest();
//        RunOob runOob=new RunOob();
//        runOob.setRunId(1);
//        request.setDataModel(runOob);
//        request.setRequestType(RequestType.SingleQuery);
//        request.setTablesEnum(TablesEnum.USER_TABLE);
//       StockManagerResponse response= stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
//        return "helloMenu";
//    }
    @RequestMapping(value = "/start")
    public String showMenu() {
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
}

