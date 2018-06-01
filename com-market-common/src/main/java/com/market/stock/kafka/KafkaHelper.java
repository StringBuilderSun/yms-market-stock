package com.market.stock.kafka;

import com.bestpay.kafka.model.TopicInfo;
import com.bestpay.kafka.service.producer.ProducerServiceImpl;
import com.market.stock.kafka.model.AsyncResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.slf4j.helpers.BestpayMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Kafka 配置
 * Author: cx
 * Date: 2017/11/14
 */
@Component
@Slf4j
public class KafkaHelper {

    @Autowired
    private ProducerServiceImpl producerService;
    /**
     * 系统对应的Kafka配置
     */
     @Autowired
     private TopicInfo topicInfoBankCallback;
    /**
     * 通知系统对应的Kafka配置
     */
    @Autowired
    private TopicInfo topicInfoBankUnbindNotify;

    /**
     * 通知3.0系统
     */
    @Autowired
    private TopicInfo topicInfoEpccEntrustNotify;

    /**
     *  发送Kafka消息
     * @return
     */
    public void loadKafkaConfig(AsyncResponse asyncResponse) {

        log.info("Kafka发送聚合支付回调消息开始，通知参数:{}",asyncResponse);

        producerService.sendMessage(topicInfoBankCallback,asyncResponse,
                MDC.get(BestpayMarker.TRACE_LOG_ID));

        log.info("Kafka发送聚合支付回调消息结束");
    }

//    /**
//     *  解约通知发送Kafka消息
//     * @return
//     */
//    public void loadConfigKafKa(QueueUnbindCardDTO queueUnbindCardDTO){
//        log.info("Kafka发送解绑通知回调开始，通知参数:{}",queueUnbindCardDTO);
//        try {
//            producerService.sendMessage(topicInfoBankUnbindNotify, queueUnbindCardDTO, MDC.get(BestpayMarker.TRACE_LOG_ID));
//            log.info("Kafka发送解绑通知回调消息结束");
//        }catch (Exception e){
//            log.error("Kafka发送解绑通知回调消息异常",e);
//        }
//
//    }

//    public void loadConfigKafkaforSettleCore(EpccEntrustKafkaResponse epccEntrustKafkaResponse){
//        log.info("Kafka发送网联委托支付异步签约结果开始，通知参数：{}",epccEntrustKafkaResponse);
//        try {
//            producerService.sendMessage(topicInfoEpccEntrustNotify, epccEntrustKafkaResponse, MDC.get(BestpayMarker.TRACE_LOG_ID));
//            log.info("Kafka发送解绑通知回调消息结束");
//        }catch (Exception e){
//            log.error("Kafka发送解绑通知回调消息异常",e);
//        }
//    }
}
