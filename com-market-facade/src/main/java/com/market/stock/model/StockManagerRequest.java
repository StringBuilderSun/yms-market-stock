package com.market.stock.model;


import lombok.Getter;
import lombok.Setter;



/**
 * 库管理请求model
 * Created by Administrator on 2018/5/19.
 */
@Setter
@Getter
public class StockManagerRequest extends StockBaseRequest {
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作时间
     */
    private String operatorTime;

    public String ToString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("operator:").append(this.operator).append("operatorTime:").append(this.operatorTime);
        return sb.toString();
    }
}
