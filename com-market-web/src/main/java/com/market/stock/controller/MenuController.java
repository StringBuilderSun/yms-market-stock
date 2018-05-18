/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.controller;

import com.market.stock.model.RunOob;
import com.market.stock.service.SpringRoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijinpeng
 * @version Id: MenuController.java, v 0.1 2018/5/15 20:52 lijinpeng Exp $$
 */
@Slf4j
@Controller
public class MenuController {

    @Autowired
    private SpringRoadService springRoadService;

    @RequestMapping(value = "/start")
    public String showMenu() {
        log.info("service start .......");
        RunOob runOob = springRoadService.findRunOobUser(1);
        log.info("result:{}", runOob);
        return "howMenu";
    }
}

