/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.mapper;


import com.market.stock.model.RunOob;
import org.apache.ibatis.annotations.Param;


/**
 * @author lijinpeng
 * @version Id: RunOobMapper.java, v 0.1 2018/5/16 18:50 lijinpeng Exp $$
 */
public interface RunOobMapper {
     RunOob findRunOobByRunId(@Param("runId") Integer runId);
}
