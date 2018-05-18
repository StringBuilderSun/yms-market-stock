/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.serviceImpl;

import com.market.stock.dao.RunOobDao;
import com.market.stock.model.RunOob;
import com.market.stock.service.SpringRoadService;
import com.market.stock.utils.AlivnMarker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijinpeng
 * @version Id: SpringRoadService.java, v 0.1 2018/5/16 19:51 lijinpeng Exp $$
 */
@Service
@Slf4j
public class SpringRoadServiceImpl implements SpringRoadService {
    @Autowired
    private RunOobDao runOobDao;
    public RunOob findRunOobUser(Integer runId) {
        MDC.put(AlivnMarker.TRACE_LOG_ID, "1111111111111");
        log.info("start to find RunOob,runId:{}", runId);
        return runOobDao.findRunOobByRunId(runId);
    }
}

