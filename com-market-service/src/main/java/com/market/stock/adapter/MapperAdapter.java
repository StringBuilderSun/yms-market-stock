package com.market.stock.adapter;

import com.market.stock.enums.RequestType;
import com.market.stock.enums.StockExcetionEnum;
import com.market.stock.enums.TablesEnum;
import com.market.stock.exception.StockException;
import com.market.stock.mapper.BaseMapper;
import com.market.stock.mapper.RunOobMapper;
import com.market.stock.mapper.UserMapper;
import com.market.stock.model.StockBaseRequest;
import com.market.stock.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2018/5/20.
 */
@Slf4j
@Service
public class MapperAdapter {
    @Autowired
    private RunOobMapper runOobMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取mapper 接口
     *
     * @param request 请求model
     * @return
     */
    public BaseMapper getMapper(StockBaseRequest request) {
        log.info("开始匹配操作接口,操作tablesEnum:{}", request.getTablesEnum());
        BaseMapper mapper;
        TablesEnum tablesEnum = request.getTablesEnum();
        if (StringUtils.isEmpty(tablesEnum)) {
            log.error("table is null");
            throw new StockException(StockExcetionEnum.TABLE_ISNULL);
        }
        switch (tablesEnum) {
            case USER_TABLE:
                mapper = userMapper;
                break;
            default:
                mapper = null;
        }
        log.info("匹配到得操作接口:{}", mapper);
        return mapper;
    }

    /**
     * 获取操作结果
     * 使用注解式事务  默认使用 数据库默认的
     *
     * @param request 请求model
     * @param <T>     操作结果
     * @return
     */
    @Transactional
    public <T> T getResult(StockBaseRequest request) {
        log.info("操作表:{} 请求类型:{}", request.getTablesEnum(), request.getRequestType());
        BaseMapper mapper = getMapper(request);
        if (mapper == null) {
            log.error("mapper 接口不存在");
            throw new StockException(StockExcetionEnum.MAPPER_NOTEXIT);
        }
        RequestType requestType = request.getRequestType();
        if (StringUtils.isEmpty(request)) {
            log.error("requestType 不能为null! 输入值:{}", requestType);
            throw new StockException(StockExcetionEnum.REQUESTtYPE_ISNULL);
        }
        switch (requestType) {
            case SingleQuery:
                return (T) mapper.querySingleService(request.getDataModel());
            case INSERT:
                //由于mysql默认返回的int，int又不是引用类型 无法用泛型，所以需要转换一下
                Integer result = Integer.valueOf(mapper.addService(request.getDataModel()));
                return (T) result;
        }
        return null;
    }
}
