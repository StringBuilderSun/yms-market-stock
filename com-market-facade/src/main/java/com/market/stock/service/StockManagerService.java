package com.market.stock.service;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;

/**
 * 产品服务 提供产品管理接口
 * Created by Administrator on 2018/5/19.
 */
public interface StockManagerService {

    StockManagerResponse StockDataBaseService(StockManagerRequest requestModel, String traceLogId);
}
