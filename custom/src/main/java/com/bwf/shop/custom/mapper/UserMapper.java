package com.bwf.shop.custom.mapper;

import com.bwf.shop.custom.bean.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User 客户资源 数据访问层 接口
 * */
@Repository
public interface UserMapper {

    /**
     * 根据账户名称获取用户对象
     * @param username 账户名称
     * @return 该账户名称对应的用户对象
     * */
    User getUserByUsername( @Param("username") String username );

    /**
     * 添加用户
     * @param user 要添加的用户对象
     * @return 数据库受影响的行数
     * */
    int addUser( @Param("user") User user );

    /**
     * 修改用户
     * @param user 要修改的用户对象
     * @return 数据库受影响的行数
     * */
    int updateUser( @Param("user") User user );

    User getUserById( @Param("user_id") Integer user_id );

}
