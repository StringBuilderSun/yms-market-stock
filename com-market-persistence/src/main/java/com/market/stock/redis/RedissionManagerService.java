package com.market.stock.redis;

import java.util.Iterator;
import java.util.List;

/**
 * redission 管理器
 * Created by lijinpeng on 2019/4/18
 */
public interface RedissionManagerService {
    /**
     * 获取redis中所有的key
     *
     * @param pattern 匹配规则
     * @return
     */
    List<String> getAllKeys(String pattern);

    /**
     * 获取某一类型所有的值
     *
     * @param keys
     * @param <V>
     * @return
     */
    <V> List<V> getOneTypeValues(List<String> keys);

    <V> V getValue(String key);

    /**
     * @param key
     * @return
     */
    boolean deleteKey(String key);

    boolean deleteKeys(String pattern);

}
