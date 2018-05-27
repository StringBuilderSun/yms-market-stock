package com.market.stock.service;

import com.market.stock.adapter.MapperAdapter;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.ResultStatusEnum;
import com.market.stock.enums.StockExcetionEnum;
import com.market.stock.exception.StockException;
import com.market.stock.model.StockBaseResponse;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.yms.utils.dubbo.DubboResult;
import com.yms.utils.log.AlivnMarker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2018/5/20.
 */
@Slf4j
@Service
public class StockManagerServiceImpl implements StockManagerService {
    @Autowired
    private MapperAdapter mapperAdapter;

    public DubboResult<StockManagerResponse> StockDataBaseService(StockManagerRequest requestModel, String traceLogId) {
        MDC.put(AlivnMarker.TRACE_LOG_ID, traceLogId);
        log.info("服务调用请求:{}", requestModel);
        StockManagerResponse response = new StockManagerResponse();
        log.info("省略一堆业务处理啦...........");
        try {
            response.setResponseModel(mapperAdapter.getResult(requestModel));
            switch (requestModel.getRequestType()) {
                case ListQuery:
                case SingleQuery:
                    response = queryResponseHandle(response);
                    break;
                case INSERT:
                case UPDATE:
                case DELETE:
                    response = updateResponseHandle(response);
                    break;
                default:
                    break;
            }
            log.info("业务处理完毕啦.............");
        } catch (StockException e) {
            log.error("StockExceptation：", e);
            response.setResponseCode(e.getErrorCode());
            response.setResponseDesc(e.getErrorMessage());
            response.setResult(false);
        }
        log.info("服务响应结果:{}", response);
        return new DubboResult<StockManagerResponse>(response);
    }

    public StockManagerResponse queryResponseHandle(StockManagerResponse response) {
        if (response.getResponseModel() == null) {
            response.setResponseCode(ResultStatusEnum.NORECORDS.getResponseCode());
            response.setResponseDesc(ResultStatusEnum.NORECORDS.getResponseDesc());
        } else {
            response.setResponseCode(ResultStatusEnum.SUCCESS.getResponseCode());
            response.setResponseDesc(ResultStatusEnum.SUCCESS.getResponseDesc());
        }
        return response;
    }

    public StockManagerResponse updateResponseHandle(StockManagerResponse response) {
        Integer result = response.getResponseModel();
        if (result == null || result == 0) {
            response.setResponseCode(ResultStatusEnum.UPDATEFAIL.getResponseCode());
            response.setResponseDesc(ResultStatusEnum.UPDATEFAIL.getResponseDesc());
        } else {
            response.setResponseCode(ResultStatusEnum.SUCCESS.getResponseCode());
            response.setResponseDesc(ResultStatusEnum.SUCCESS.getResponseDesc());
        }
        return response;
    }
}
