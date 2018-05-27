package com.market.stock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/19.
 */
@Setter
@Getter
@ToString
public class StockBaseResponse implements Serializable {
    private static final long serialVersionUID = -7302365661744269058L;
    /**
     * 本次表操作是否成功 查无此结果也返回false
     */
    private boolean result;
    /**
     * 操作响应码
     */
    private String responseCode;
    /**
     * 操作响应描述
     */
    private String responseDesc;

}
