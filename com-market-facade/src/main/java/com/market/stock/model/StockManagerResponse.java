package com.market.stock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 库管理系统响应
 * Created by Administrator on 2018/5/20.
 */
@Setter
@Getter
@ToString
public class StockManagerResponse<T> extends StockBaseResponse {
    /**
     * 响应model
     */
    private T responseModel;

}
