package com.bwf.shop.custom.mapper;

import com.bwf.shop.custom.bean.po.UserAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserAddress 客户收货信息资源 数据访问层 接口
 * */
@Repository
public interface UserAddressMapper {

    /**
     * 添加收货信息
     * @param userAddress 要添加的收货信息
     * @return 数据库受影响的行数
     * */
    int addUserAddress( @Param("userAddress") UserAddress userAddress);

    /**
     * 修改收货信息
     * @param userAddress 要修改的收货信息
     * @return 数据库受影响的行数
     * */
    int updateUserAddress( @Param("userAddress") UserAddress userAddress );

    /**
     * 删除指定编号的收货信息
     * @param id 要删除的收货信息的编号
     * @return 数据库受影响的行数
     * */
    int deleteUserAddress( @Param("id") Integer id );

    /**
     * 根据用户编号查询该用户的收货信息列表
     * @param user_id 用户编号
     * @return 该用户的收货信息列表
     * */
    List<UserAddress> getUserAddressByUserId( @Param("user_id") Integer user_id );
}
