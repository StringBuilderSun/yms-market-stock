package com.market.stock.exception;

import com.market.stock.enums.StockExcetionEnum;


/**
 * Created by Administrator on 2018/5/19.
 */
public class StockException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public StockException(StockExcetionEnum stockExcetionEnum) {
        super();
        this.errorCode = stockExcetionEnum.getErrorCode();
        this.errorMessage = stockExcetionEnum.getErrorMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
