package com.market.stock.enums;

import lombok.AllArgsConstructor;

/**
 * Created by Administrator on 2018/5/19.
 */
@AllArgsConstructor
public enum StockExcetionEnum {
    TABLE_NOTEXIT("SYS999999", "数据库中不存在此表");
    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
