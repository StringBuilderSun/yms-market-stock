package com.market.stock.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lijinpeng on 2019/4/18.
 */
@Service
@Slf4j
public class RedissionManagerServiceImpl implements RedissionManagerService {
    @Autowired
    private Redisson redisson;

    public List<String> getAllKeys(String pattern) {
        //所有的key对象都封装在Rkey里面
        RKeys rKey = redisson.getKeys();
        List<String> keys = new ArrayList<String>();
        Iterator<String> iterator = rKey.getKeysByPattern(pattern).iterator();
        while (iterator.hasNext()) {
            keys.add(iterator.next());
        }
        return keys;
    }

    public <V> List<V> getOneTypeValues(List<String> keys) {
        List<V> list = new ArrayList<V>();
        if (keys.size() > 0) {
            for (String key : keys) {
                list.add((V) getValue(key));
            }
        }
        return list;
    }

    public <V> V getValue(String key) {
        RBucket<V> bucket = redisson.getBucket(key);
        return bucket.get();
    }

    public boolean deleteKey(String key) {
        redisson.getKeys();
        return false;
    }

    public boolean deleteKeys(String pattern) {
        RKeys rKeys = redisson.getKeys();
        int keyCounts = getAllKeys(pattern).size();
        long deleteKeys = rKeys.deleteByPattern(pattern);
        log.info("本次删除key数量:{} 个", deleteKeys);
        return (keyCounts == (int) deleteKeys);
    }
}
