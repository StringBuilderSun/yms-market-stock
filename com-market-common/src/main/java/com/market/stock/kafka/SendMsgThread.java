package com.market.stock.kafka;

import com.bestpay.kafka.model.*;
import com.bestpay.kafka.service.nospring.ProducerNoSpringService;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lijinpeng on 2018/6/1.
 */
public class SendMsgThread implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(com.bestpay.kafka.thread.SendMsgThread.class);
    private com.bestpay.kafka.model.TopicInfo topicInfo;
    private Object message;
    private String traceLogId;

    public SendMsgThread(com.bestpay.kafka.model.TopicInfo topicInfo, Object message, String traceLogId) {
        this.topicInfo = topicInfo;
        this.message = message;
        this.traceLogId = traceLogId;
    }

    public void run() {
        try {
            ProducerNoSpringService.sendMessage(this.topicInfo, this.message, this.traceLogId);
        } catch (Exception var2) {
            log.error("failed to kafka build message, parameter:{} {}, cause：{}", this.message, Throwables.getStackTraceAsString(var2));
        }

    }
}
