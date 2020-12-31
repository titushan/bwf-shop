package com.bwf.shop.order.service;

import com.bwf.shop.order.bean.po.OrderAddress;
import org.apache.ibatis.annotations.Param;

/**
 * OrderAddress 订单收货信息资源 业务逻辑层 接口
 * */
public interface IOrderAddressService {

    /**
     * 添加订单收货信息
     * @param orderAddress 要添加的订单收货信息
     * @return 添加订单收货信息是否成功
     * */
    boolean addOrderAddress(  OrderAddress orderAddress);

    /**
     * 修改订单收货信息
     * @param orderAddress 要修改的订单收货信息
     * @return 修改订单收货信息是否成功
     * */
    boolean updateOrderAddress(  OrderAddress orderAddress);

}
