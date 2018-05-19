package com.market.stock.service;

import com.market.stock.mapper.RunOobMapper;
import com.market.stock.model.RunOob;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.utils.AlivnMarker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Administrator on 2018/5/20.
 */
@Slf4j
@Service
public class StockManagerServiceImp implements StockManagerService {
    @Autowired
    private RunOobMapper runOobMapper;

    public StockManagerResponse StockDataBaseService(StockManagerRequest requestModel, String traceLogId) {
        MDC.put(AlivnMarker.TRACE_LOG_ID,traceLogId);
        log.info("请求参数:{}", requestModel);
        log.info("数据源:{}", requestModel.getDataModel());
        RunOob runOob = runOobMapper.findRunOobByRunId(1);
        StockManagerResponse<RunOob> response = new StockManagerResponse<RunOob>();
        response.setResponseDesc("处理成功");
        response.setResponseCode("000000");
        response.setResponseModel(runOob);
        response.setResult(true);
        log.info("响应结果:{}", response);
        return response;
    }
}
