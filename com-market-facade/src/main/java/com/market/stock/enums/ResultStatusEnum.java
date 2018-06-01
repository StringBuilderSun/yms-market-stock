package com.market.stock.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Created by lijinpeng on 2018/5/24.
 */
@AllArgsConstructor
public enum ResultStatusEnum {
    SUCCESS("000000", "处理成功"),
    NORECORDS("100000", "查无此记录"),
    UPDATEFAIL("200000", "更新数据");
    private String responseCode;
    private String responseDesc;


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }
}
