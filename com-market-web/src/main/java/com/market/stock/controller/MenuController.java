/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.controller;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.TablesEnum;
import com.market.stock.model.RunOob;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.service.StockManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/start")
    public String showMenu() {
        StockManagerRequest request = new StockManagerRequest();
        RunOob runOob=new RunOob();
        runOob.setRunId(1);
        request.setDataModel(runOob);
        request.setRequestType(RequestType.SingleQuery);
        request.setTablesEnum(TablesEnum.USER_TABLE);
       StockManagerResponse response= stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        return "helloMenu";
    }
}

