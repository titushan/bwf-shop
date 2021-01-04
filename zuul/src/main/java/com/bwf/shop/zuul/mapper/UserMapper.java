package com.bwf.shop.zuul.mapper;

import com.bwf.shop.zuul.bean.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User 客户资源 数据访问层 接口
 * */
@Repository
public interface UserMapper {

    User getUserByToken( @Param("token") String token );


}
