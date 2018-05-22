package com.market.stock.mapper;

import java.util.List;

/**
 * mapper服务基类
 * Created by Administrator on 2018/5/20.
 */
public interface BaseMapper<D> {
    /**
     * 新增操作
     *
     * @param data
     * @param
     * @return
     */
    int addService(D data);

    /**
     * 单个查询操作
     *
     * @param data
     * @param <T>
     * @return
     */
    <T> T singleQueryByPrimaryKeyService(D data);

    /**
     * 查询集合
     * @param data
     * @param <T>
     * @return
     */
    <T> List<T> queryListService(D data);

    /**
     * 删除服务
     * @param data
     * @return
     */
    int deleteService(D data);

    /**
     * 更新服务
     * @param data
     * @return
     */
    int updateService(D data);
}
