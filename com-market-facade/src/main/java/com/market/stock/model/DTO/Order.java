package com.market.stock.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by lijinpeng on 2019/3/12.
 */
@Setter
@Getter
@ToString
public class Order {
    /**
     * 订单id
     */
    private int id;
    /**
     * 订单流水
     */
    private String orderno;
    /**
     * 用户id
     */
    private int userid;
    /**
     * 产品id
     */
    private String productid;
    /**
     * 订单数量
     */
    private int amount;
    /**
     * 价格
     */
    private double price;
    /**
     * 创建日期
     */
    private Date createdate;
    /**
     * 订单摘要
     */
    private String remark;
    /**
     * 商户id
     */
    private String mchntid;

}
