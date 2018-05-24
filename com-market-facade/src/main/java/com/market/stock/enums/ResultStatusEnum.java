package com.market.stock.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Created by lijinpeng on 2018/5/24.
 */
@AllArgsConstructor
public enum ResultStatusEnum {
    SUCCESS("000000", "处理成功");
    private String responseCode;
    private String responseDesc;

    public void setResponseCode() {
        this.responseCode = responseDesc;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseDesc() {
        this.responseDesc = responseDesc;
    }

    public String getResponseDesc() {
        return responseCode;
    }

}
