package com.market.stock.mapper;

import com.market.stock.model.User;

/**
 * Created by lijinpeng on 2018/5/21.
 */
public interface UserMapper extends BaseMapper<User> {
    Integer addService(User data);
}
