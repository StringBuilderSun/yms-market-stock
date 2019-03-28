package com.market.stock.serviceImpl;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.yms.utils.dubbo.DubboResult;

/**
 * 产品服务 提供产品管理接口
 * Created by Administrator on 2018/5/19.
 */
public interface StockManagerService {

   DubboResult<StockManagerResponse> StockDataBaseService(StockManagerRequest requestModel, String traceLogId);
}
