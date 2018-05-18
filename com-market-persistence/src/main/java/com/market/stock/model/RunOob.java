/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lijinpeng
 * @version Id: RunOob.java, v 0.1 2018/5/16 18:45 lijinpeng Exp $$
 */
@Getter
@Setter
@ToString
public class RunOob implements Serializable {
     private Integer runId;
     private String runTitle;
     private String runAuthor;
     private Date runDate;
}

