package com.market.stock.enums;

import lombok.AllArgsConstructor;

/**
 * Created by Administrator on 2018/5/19.
 */
@AllArgsConstructor
public enum StockExcetionEnum {
    SUCCESS("000000","处理成功"),
    TABLE_NOTEXIT("SYS999999", "数据库中不存在此表"),
    REQUES_TYPE_ISNULL("SYS999996", "requestType is not null"),
    REQUES_TYPE_ISEXIT("SYS999995", "requestType is not exit"),
    TABLE_ISNULL("SYS999998", "tablesEnum is not null"),
    MAPPER_NOTEXIT("SYS999997", "mapper is null");

    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
