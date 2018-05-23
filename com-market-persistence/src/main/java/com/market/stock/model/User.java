package com.market.stock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by lijinpeng on 2018/5/21.
 */
@Setter
@Getter
@ToString
public class User {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String uname;
    /**
     * 性别
     */
    private boolean sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 城市
     */
    private String city;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户级别
     */
    private String userLevel;
    /**
     * 备注
     */
    private String remark;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 修改时间
     */
    private Date updatedAt;
    /**
     * 创建人
     */
    private Date createdAt;
    /**
     * 创建时间
     */
    private String createdBy;

}
