package com.market.stock.kafka.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cx 商户进件异步结果通知
 * @version Id: AsyncResponse.java, v 0.1 2017/11/20 9:44 cx Exp $$
 */
@Getter
@Setter
@ToString(callSuper = true)
public class AsyncResponse implements Serializable{


    private static final long serialVersionUID = -9311679354786183L;

    /**
     * 回调类型
     */
    private String tradeType;

    /** 商户号*/
    private String mctNo;

    /**
     * 门店号
     */
    private String shopNo;

    /**
     * 合同号
     */
    private String cttNo;

    /**
     * 交易状态
     */
    private String  payStatus;

    /**
     * 提审状态
     */
    private String  checkStatus;

    /**
     * 审核备注
     */
    private String  remark;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 交易金额
     */
    private String amount;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 日志跟踪号
     */
    private String traceLogId;
}
