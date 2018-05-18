/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.service;


import com.market.stock.model.RunOob;

/**
 * @author lijinpeng
 * @version Id: SpringRoadService.java, v 0.1 2018/5/16 20:13 lijinpeng Exp $$
 */
public interface SpringRoadService {
    RunOob findRunOobUser(Integer runId);
}
