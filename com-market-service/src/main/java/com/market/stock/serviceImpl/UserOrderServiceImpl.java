package com.market.stock.serviceImpl;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.TablesEnum;
import com.market.stock.model.DTO.Order;
import com.market.stock.model.DTO.User;
import com.market.stock.model.StockManagerRequest;
import com.market.stock.model.StockManagerResponse;
import com.market.stock.service.UserOrderService;
import com.yms.utils.dubbo.DubboResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lijinpeng on 2019/3/12.
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private StockManagerService stockManagerService;

    @Transactional
    public Order addUserAndSaveOrder(Order order) {
        StockManagerRequest request = new StockManagerRequest();
        User user = new User();
        user.setPhone("18939573846");
        user.setCity("许昌");
        user.setEmail("957143335@qq.com");
        user.setRemark("测试数据");
        user.setSex(false);
        user.setCreatedAt(new Date());
        user.setCreatedBy("2018-09-12");
        user.setUname("李金朋");
        user.setCreatedAt(new Date());
        user.setUserLevel("0");
        request.setDataModel(user);
        request.setRequestType(RequestType.INSERT);
        request.setTablesEnum(TablesEnum.USER_TABLE);
        DubboResult<StockManagerResponse> userResult = stockManagerService.StockDataBaseService(request, UUID.randomUUID().toString());
        System.out.println("用户开通结果：" + userResult);
        StockManagerRequest request1 = new StockManagerRequest();
        request1.setDataModel(order);
        request1.setRequestType(RequestType.INSERT);
        request1.setTablesEnum(TablesEnum.ORDER_TABLE);
        DubboResult<StockManagerResponse> orderResult = stockManagerService.StockDataBaseService(request1, UUID.randomUUID().toString());
        System.out.println("订单创建结果:" + orderResult);
        return null;
    }
}
