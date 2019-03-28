package com.market.stock.utils;

import com.market.stock.model.DTO.User;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.serviceImpl.StockManagerService;
import com.yms.utils.dubbo.DubboResult;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Created by lijinpeng on 2019/3/12.
 */
@Slf4j
public class AddUserTask implements Callable<User> {
    private StockManagerService stockManagerService;

    public AddUserTask(StockManagerService stockManagerService)
    {
        this.stockManagerService=stockManagerService;
    }
    public User call() throws Exception {
        DubboResult<StockManagerResponse> response = stockManagerService.StockDataBaseService(UserUtils.getRequest(), UUID.randomUUID().toString());
        log.info("本次请求完毕啦.....{}", response.getResult().getResponseModel());
        return null;
    }


}
