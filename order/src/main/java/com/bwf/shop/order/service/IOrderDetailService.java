package com.bwf.shop.order.service;

import com.bwf.shop.order.bean.po.OrderDetail;
import org.apache.ibatis.annotations.Param;

/**
 * OrderDetail 订单详情资源 业务逻辑层 接口
 * */
public interface IOrderDetailService {

    /**
     * 修改订单详情
     * @param orderDetail 要修改的订单详情对象
     * @return 修改订单详情是否成功
     * */
    boolean updateOrderDetail( OrderDetail orderDetail );

}
