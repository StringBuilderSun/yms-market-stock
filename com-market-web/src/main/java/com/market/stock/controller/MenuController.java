/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.controller;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.TablesEnum;
import com.market.stock.model.RunOob;
import com.market.stock.model.StockManagerRequest;
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
0
    @Autowired
    private StockManagerService stockManagerService;

    @RequestMapping(value = "/start")
    public String showMenu() {
        log.info("service start .......");
        StockManagerRequest<RunOob> request = new StockManagerRequest<RunOob>();
        RunOob runOob = new RunOob();
        runOob.setRunAuthor("李金鹏");
        runOob.setRunId(22);
        runOob.setRunTitle("测试来了");
        request.setDataModel(runOob);
        request.setRequestType(RequestType.SingleQuery);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        log.info("result:{}", runOob);
        return "helloMenu";
    }
}

