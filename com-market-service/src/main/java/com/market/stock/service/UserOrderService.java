package com.market.stock.service;

import com.market.stock.model.DTO.Order;

import java.util.List;

/**
 * Created by lijinpeng on 2019/3/12.
 */
public interface UserOrderService {

     Order addUserAndSaveOrder(Order order);
}
