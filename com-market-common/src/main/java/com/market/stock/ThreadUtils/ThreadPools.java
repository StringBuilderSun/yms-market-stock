package com.market.stock.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lijinpeng on 2019/3/29.
 */
public class ThreadPools {
    private static volatile ExecutorService threadPool;

    private ThreadPools() {
    }

    ;

    /**
     * 获取线程池对象
     */
    public static ExecutorService getInstance() {
        if (threadPool == null) {
            synchronized (ThreadPools.class) {
                if (threadPool == null) {
                    threadPool = Executors.newFixedThreadPool(200);
                }
            }
        }
        return threadPool;
    }

}
