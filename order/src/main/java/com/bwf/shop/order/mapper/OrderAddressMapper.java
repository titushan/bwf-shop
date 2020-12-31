package com.bwf.shop.order.mapper;

import com.bwf.shop.order.bean.po.OrderAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * OrderAddress 订单收货信息资源 数据访问层 接口
 * */
@Repository
public interface OrderAddressMapper {

    /**
     * 添加订单收货信息
     * @param orderAddress 要添加的订单收货信息
     * @return 数据库受影响的行数
     * */
    int addOrderAddress( @Param("orderAddress") OrderAddress orderAddress);

    /**
     * 修改订单收货信息
     * @param orderAddress 要修改的订单收货信息
     * @return 数据库受影响的行数
     * */
    int updateOrderAddress( @Param("orderAddress") OrderAddress orderAddress);

    /**
     * 根据订单编号删除订单收货信息
     * @param order_no 要删除的订单收货信息的订单编号
     * @return 数据库受影响的行数
     * */
    int deleteOrderAddress( @Param("order_no") String order_no);

    /**
     * 根据订单编号查询该订单的收货信息
     * @param order_no 订单编号
     * @return 该订单的订单收货信息对象
     */
    OrderAddress getOrderAddressByOrderNo( @Param("order_no") String order_no );
}
