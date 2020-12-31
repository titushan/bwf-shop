package com.bwf.shop.order.mapper;

import com.bwf.shop.order.bean.po.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrderDetail 订单详情资源 数据访问层 接口
 * */
@Repository
public interface OrderDetailMapper {

    /**
     * 添加订单的订单详情列表
     * @param order_id 订单id
     * @param orderDetailList 订单详情列表
     * @return 数据库受影响的行数
     * */
    int addOrderDetailList(@Param("order_id") Integer order_id, @Param("orderDetailList") List<OrderDetail> orderDetailList);

    /**
     * 修改订单详情
     * @param orderDetail 要修改的订单详情对象
     * @return 数据库受影响的行数
     * */
    int updateOrderDetail( @Param("orderDetail") OrderDetail orderDetail );

    /**
     * 根据订单id删除订单详情列表
     * @param order_id 订单id
     * @return 数据库受影响的行数
     * */
    int deleteOrderDetailList( @Param("order_id") Integer order_id );

    /**
     * 根据订单详情编号获取订单详情对象
     * @param id 订单详情编号
     * @return  订单详情对象
     * */
    OrderDetail getOrderDetailById( @Param("id") Integer id );

    /**
     * 根据订单id查询订单详情列表
     * @param order_id 订单id
     * @return 该订单的订单详情列表
     * */
    List<OrderDetail> getOrderDetailListByOrderId( @Param("order_id") Integer order_id );

}
