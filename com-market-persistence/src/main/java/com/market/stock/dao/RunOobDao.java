/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.dao;

import com.market.stock.mapper.RunOobMapper;
import com.market.stock.model.RunOob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lijinpeng
 * @version Id: RunOobDao.java, v 0.1 2018/5/16 19:40 lijinpeng Exp $$
 */
@Repository
public class RunOobDao {
    @Autowired
    private RunOobMapper runOobMapper;
    public RunOob findRunOobByRunId(Integer runId) {
        return runOobMapper.findRunOobByRunId(runId);
    }
}

