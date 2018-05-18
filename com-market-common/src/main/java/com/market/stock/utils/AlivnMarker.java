/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.market.stock.utils;

import org.slf4j.Marker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lijinpeng
 * @version Id: AlivnMarker.java, v 0.1 2018/5/16 20:05 lijinpeng Exp $$
 */
public class AlivnMarker implements Marker {
    private static final long serialVersionUID = -1387951413362902419L;
    public static final String BESTPAY_MARKER_NAME = "bestpay_marker";
    /**
     * 日志跟踪id
     */
    public static String TRACE_LOG_ID = "TRACE_LOG_ID";
    /**
     * 其他信息
     */
    public static String OTHER_MSG = "OTHER_MSG";
    Map<MarkerKey, String> bestpayMarkers;

    AlivnMarker(MarkerKey markerKey, String value) {
        this(new MarkerKey[] { markerKey }, new String[] { value });
    }

    AlivnMarker(MarkerKey[] markerKeys, String[] values) {
        bestpayMarkers = new HashMap<AlivnMarker.MarkerKey, String>(markerKeys.length);
        String[] newValues = values;
        if (values.length < markerKeys.length) {
            newValues = new String[markerKeys.length];
            System.arraycopy(values, 0, newValues, 0, values.length);
            Arrays.fill(newValues, values.length, markerKeys.length, "");
        }
        for (int i = 0; i < markerKeys.length; i++) {
            bestpayMarkers.put(markerKeys[i], newValues[i]);
        }
    }

    public void setMarkerKeys(MarkerKey[] markerKeys, String[] values) {
        String[] newValues = values;
        if (values.length < markerKeys.length) {
            newValues = new String[markerKeys.length];
            System.arraycopy(values, 0, newValues, 0, values.length);
            Arrays.fill(newValues, values.length, markerKeys.length, "");
        }
        for (int i = 0; i < markerKeys.length; i++) {
            bestpayMarkers.put(markerKeys[i], newValues[i]);
        }
    }

    public Map<MarkerKey, String> getBestpayMarkers() {
        return bestpayMarkers;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(80);
        Iterator<MarkerKey> ite = bestpayMarkers.keySet().iterator();
        while (ite.hasNext()) {
            MarkerKey key = ite.next();
            sb.append("\"").append(key).append("\":\"").append(bestpayMarkers.get(key)).append("\"");
            if (ite.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public enum MarkerKey {
        /**
         * 电信产品号
         */
        PRODUCT_NO("PRODUCT_NO"),
        /**
         * 金额
         */
        AMT("AMT"),
        /**
         * 日志标识，比如“查询绑卡信息”等
         */
        MARKER("MARKER"),
        /**
         * 异常名称
         */
        EXNAME("EXNAME"),
        /**
         * 异常信息
         */
        EXMESSAGE("EXMESSAGE"),
        /**
         * 异常堆栈
         */
        EXSTACK("EXSTACK"),
        /**
         * 外部订单号
         */
        OTOD("OTOD"),
        /**
         * 翼支付账号
         */
        BSTACC("BSTACC"),
        /**
         * 手机号
         */
        MOBACC("MOBACC"),
        /**
         * 翼支付卡卡号
         */
        BSTCDACC("BSTCDACC"),
        /**
         * 订单类型
         */
        ODTP("ODTP"),
        /**
         * 交易类型
         */
        TDTP("TDTP"),
        /**
         * 外部合作伙伴
         */
        PARTNERID("PARTNERID"),
        /**
         * 受理机构
         */
        ACCORT("ACCORT");

        String key;

        MarkerKey(String key) {
            this.key = key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public String getName() {
        return BESTPAY_MARKER_NAME;
    }

    @Deprecated
    public void add(Marker reference) {
        // NOP
    }

    @Deprecated
    public boolean remove(Marker reference) {
        // NOP
        return false;
    }

    @Deprecated
    public boolean hasChildren() {
        // NOP
        return false;
    }

    @Deprecated
    public boolean hasReferences() {
        // NOP
        return false;
    }

    @Deprecated
    public Iterator iterator() {
        // NOP
        return null;
    }

    @Deprecated
    public boolean contains(Marker other) {
        // NOP
        return false;
    }

    @Deprecated
    public boolean contains(String name) {
        // NOP
        return false;
    }

}

