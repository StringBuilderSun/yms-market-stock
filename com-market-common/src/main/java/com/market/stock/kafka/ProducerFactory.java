package com.market.stock.kafka;

import com.bestpay.kafka.model.*;
import com.bestpay.kafka.tools.IntegerCycle;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lijinpeng on 2018/6/1.
 */
public class ProducerFactory {
    private static final Logger log = LoggerFactory.getLogger(com.bestpay.kafka.service.Factory.ProducerFactory.class);
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final int producerNum = 1;
    public static final ConcurrentMap<String, List<Producer>> topicMap = Maps.newConcurrentMap();

    public ProducerFactory() {
    }

    public static synchronized void initProducer(com.bestpay.kafka.model.TopicInfo topicInfo) {
        if(topicMap.get(topicInfo.getTopicName()) == null || ((List)topicMap.get(topicInfo.getTopicName())).size() == 0) {
            ArrayList producerList = Lists.newArrayList();

            for(int i = 0; i < 1; ++i) {
                producerList.add(new Producer(new ProducerConfig(getProperty(topicInfo))));
                log.debug("initProducer :{},{}", topicInfo.getTopicName(), Integer.valueOf(i));
            }

            topicMap.put(topicInfo.getTopicName(), producerList);
        }

    }

    private static Properties getProperty(com.bestpay.kafka.model.TopicInfo topicInfo) {
        Properties properties = new Properties();
        properties.put("metadata.broker.list", topicInfo.getBrokerList());
        properties.put("request.required.acks", topicInfo.getAck().getAck());
        properties.put("producer.type", topicInfo.getSyncFlag().getSyncFlag());
        properties.put("serializer.class", "com.bestpay.kafka.serialize.MessageSerializer");
        properties.put("message.send.max.retries", topicInfo.isRetries()?"1":"0");
        properties.put("request.timeout.ms", "3000");
        properties.put("topic.metadata.refresh.interval.ms", "30000");
        return properties;
    }

    public static Producer getProducer(com.bestpay.kafka.model.TopicInfo topicInfo) {
        if(topicMap.get(topicInfo.getTopicName()) == null || ((List)topicMap.get(topicInfo.getTopicName())).size() == 0) {
            initProducer(topicInfo);
        }

        int n = IntegerCycle.getIndex(atomicInteger, 1);
        log.debug("index of connector ：{}", Integer.valueOf(n));
        return (Producer)((List)topicMap.get(topicInfo.getTopicName())).get(n);
    }
}
