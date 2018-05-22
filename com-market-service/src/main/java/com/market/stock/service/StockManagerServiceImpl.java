package com.market.stock.service;

import com.market.stock.adapter.MapperAdapter;

import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.utils.AlivnMarker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/20.
 */
@Slf4j
@Service
public class StockManagerServiceImpl implements StockManagerService {

    @Autowired
    private MapperAdapter mapperAdapter;
    public StockManagerResponse StockDataBaseService(StockManagerRequest requestModel, String traceLogId) {
        MDC.put(AlivnMarker.TRACE_LOG_ID, traceLogId);
        log.info("服务调用请求:{}", requestModel);
        StockManagerResponse response = new StockManagerResponse();
        response.setResponseModel(mapperAdapter.getResult(requestModel));
        response.setResponseDesc("处理成功");
        response.setResponseCode("000000");
        response.setResult(true);
        log.info("服务调用响应:{}", response);
        return response;
    }
}
