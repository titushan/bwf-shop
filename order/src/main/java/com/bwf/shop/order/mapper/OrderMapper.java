package com.bwf.shop.order.mapper;

import com.bwf.shop.order.bean.po.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Order 订单资源  数据访问层 接口
 * */
@Repository
public interface OrderMapper {

    /**
     * 添加订单
     * @param order 要添加的订单对象
     * @return 数据库受影响的行数
     * */
    int addOrder( @Param("order") Order order );

    /**
     * 修改订单
     * @param order 要修改的订单对象
     * @return 数据库受影响的行数
     * */
    int updateOrder( @Param("order") Order order );

    /**
     * 删除订单
     * @param id 要删除的订单的订单编号
     * @return 数据库受影响的行数
     * */
    int deleteOrder( @Param("id") Integer id );

    /**
     * 根据订单id查询一个订单
     * @param id 要查询的订单的订单id
     * @return 订单对象
     * */
    Order getOrderById( @Param("id") Integer id  );

    /**
     * 根据订单编号查询一个订单
     * @param order_no 要查询的订单的订单编号
     * @return 订单对象
     * */
    Order getOrderByNo( @Param("order_no") String order_no  );

    /**
     * 根据用户编号查询该用户的所有订单列表
     * @param user_id 用户编号
     * @return 该用户的订单列表
     * */
    List<Order> getOrderListByUserId( @Param("user_id") Integer user_id );

}
