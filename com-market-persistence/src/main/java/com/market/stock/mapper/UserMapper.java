package com.market.stock.mapper;

import com.market.stock.model.User;

import java.util.List;

/**
 * Created by lijinpeng on 2018/5/21.
 */
public interface UserMapper extends BaseMapper<User> {
    int addService(User data);

    User singleQueryByPrimaryKeyService(User user);

    List<User> queryListService(User data);

    int deleteService(User data);

    int updateService(User data);

}
