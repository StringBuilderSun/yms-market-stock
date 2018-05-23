package com.market.stock.model;


import lombok.ToString;

/**
 * 库管理系统响应
 * Created by Administrator on 2018/5/20.
 */
@ToString(callSuper = true)
public class StockManagerResponse extends StockBaseResponse {
    /**
     * 响应model
     */
    private Object responseModel;

    public <T> T getResponseModel() {
        return (T)responseModel;
    }
    public  void setResponseModel(Object responseModel)
    {
        this.responseModel=responseModel;
    }

}
