package com.market.stock.kafka;

import com.bestpay.kafka.model.*;
import com.bestpay.kafka.service.nospring.ProducerNoSpringService;
import com.bestpay.kafka.thread.SendMsgThread;
import com.bestpay.kafka.thread.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by lijinpeng on 2018/6/1.
 */
public class ProducerServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(com.bestpay.kafka.service.producer.ProducerServiceImpl.class);

    public ProducerServiceImpl() {
    }

    public <T> void sendMessages(com.bestpay.kafka.model.TopicInfo topicInfo, List<T> messages, String traceLogId) {
        log.debug("traceLogId:{},topicInfo:{} messages to send :{}", new Object[]{traceLogId, topicInfo, messages});
        ProducerNoSpringService.sendMessages(topicInfo, messages, traceLogId);
    }

    public <T> void sendMessage(com.bestpay.kafka.model.TopicInfo topicInfo, T message, String traceLogId) {
        log.debug("traceLogId:{} topic：{} message to send :{}", new Object[]{traceLogId, topicInfo, message});
        ProducerNoSpringService.sendMessage(topicInfo, message, traceLogId);
    }

    public <T> void sendAsyMessage(com.bestpay.kafka.model.TopicInfo topicInfo, T message, String traceLogId) {
        log.debug("traceLogId:{} topic：{} message to send :{}", new Object[]{traceLogId, topicInfo, message});
        SendMsgThread sendMsgThread = new SendMsgThread(topicInfo, message, traceLogId);
        ThreadPool.getInstance().getPool().execute(sendMsgThread);
    }
}
