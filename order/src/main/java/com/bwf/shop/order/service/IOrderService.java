package com.bwf.shop.order.service;

import com.bwf.shop.order.bean.bo.OrderAddBo;
import com.bwf.shop.order.bean.po.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Order 订单资源 业务逻辑层 接口
 * */
public interface IOrderService {

    /**
     * 添加订单
     * @param bo 添加订单业务模型对象
     * @return 添加订单是否成功
     * */
    boolean addOrder(OrderAddBo bo);

    /**
     * 修改订单
     * @param order 要修改的订单对象
     * @return 修改订单是否成功
     * */
    boolean updateOrder(Order order);

    /**
     * 根据用户编号查询该用户的所有订单列表
     * @param user_id 用户编号
     * @return 该用户的订单列表
     * */
    List<Order> getOrderListByUserId(Integer user_id );
}
