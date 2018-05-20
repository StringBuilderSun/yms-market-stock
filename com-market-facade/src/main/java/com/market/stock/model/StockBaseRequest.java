package com.market.stock.model;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.TablesEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/19.
 */
@Getter
@Setter
@ToString
public class StockBaseRequest<T> implements Serializable {
    private static final long serialVersionUID = 7467597467519190913L;
    /**
     * 操作的数据源
     */
    private T dataModel;
    /**
     * 要操作的表类型
     */
    private TablesEnum tablesEnum;
    /**
     * 对表要操作的请求类型
     */
    private RequestType requestType;


}
