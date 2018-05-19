package com.market.stock.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * 库管理请求model
 * Created by Administrator on 2018/5/19.
 */
@Setter
@Getter
@ToString
public class StockManagerRequest<T> extends StockBaseRequest {
    /**
     * 操作的数据源
     */
    private T dataModel;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作时间
     */
    private Date operatorTime;
}
