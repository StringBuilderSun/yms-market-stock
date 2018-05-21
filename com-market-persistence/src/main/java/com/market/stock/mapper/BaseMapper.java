package com.market.stock.mapper;

/**
 * mapper服务基类
 * Created by Administrator on 2018/5/20.
 */
public interface BaseMapper<D>{
    /**
     * 新增操作
     * @param data
     * @param
     * @return
     */
    <T> T addService(D data);

    /**
     * 单个查询操作
     * @param data
     * @param <T>
     * @return
     */
    <T> T querySingleService(D data);

}
