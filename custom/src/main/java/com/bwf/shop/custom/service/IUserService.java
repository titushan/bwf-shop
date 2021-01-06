package com.bwf.shop.custom.service;

import com.bwf.shop.custom.bean.po.User;

/**
 * User 客户资源 业务逻辑层 接口
 * */
public interface IUserService {

    /**
     * 用户注册
     * @param user 要注册的用户对象
     * @return 注册是否成功
     * */
    boolean regist( User user );

    /**
     * 用户登录
     * @param username 登录的账户名称
     * @param password 登录的账户密码
     * @return 用户对象
     * */
    User login( String username , String password );

    User getUserById( Integer user_id );
}
