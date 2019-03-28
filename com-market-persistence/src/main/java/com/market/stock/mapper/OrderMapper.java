package com.market.stock.mapper;

import com.market.stock.model.DTO.Order;

import java.util.List;

/**
 * Created by lijinpeng on 2019/3/12.
 */
public interface OrderMapper extends BaseMapper<Order> {

    int addService(Order data);

    Order singleQueryByPrimaryKeyService(Order data);

    List<Order> queryListService(Order data);

    int deleteService(Order data);

    int updateService(Order data);
}
