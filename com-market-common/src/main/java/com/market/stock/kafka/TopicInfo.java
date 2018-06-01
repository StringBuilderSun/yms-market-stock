package com.market.stock.kafka;

import com.bestpay.kafka.model.ProducerType;
import com.bestpay.kafka.model.RequiredAck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lijinpeng on 2018/6/1.
 */
public class TopicInfo {
    private static final Logger log = LoggerFactory.getLogger(TopicInfo.class);
    private ProducerType syncFlag;
    private String topicName;
    private RequiredAck ack;
    private boolean retries;
    private String groupName;
    private String zkAddress;
    private String brokerList;

    public ProducerType getSyncFlag() {
        return this.syncFlag;
    }

    public void setSyncFlag(ProducerType syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public RequiredAck getAck() {
        return this.ack;
    }

    public void setAck(RequiredAck ack) {
        this.ack = ack;
    }

    public boolean isRetries() {
        return this.retries;
    }

    public void setRetries(boolean retries) {
        this.retries = retries;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getZkAddress() {
        return this.zkAddress;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public String getBrokerList() {
        return this.brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public TopicInfo(ProducerType syncFlag, String topicName, RequiredAck ack, boolean retries, String groupName, String zkAddress, String brokerList) {
        if(groupName == null || groupName.equals("")) {
            groupName = "default_group";
        }

        this.syncFlag = syncFlag;
        this.topicName = topicName;
        this.ack = ack;
        this.retries = retries;
        this.groupName = groupName;
        this.zkAddress = zkAddress;
        this.brokerList = brokerList;
    }

    public TopicInfo() {
    }

    public String toString() {
        return "TopicInfo(syncFlag=" + this.getSyncFlag() + ", topicName=" + this.getTopicName() + ", ack=" + this.getAck() + ", retries=" + this.isRetries() + ", groupName=" + this.getGroupName() + ", zkAddress=" + this.getZkAddress() + ", brokerList=" + this.getBrokerList() + ")";
    }
}
