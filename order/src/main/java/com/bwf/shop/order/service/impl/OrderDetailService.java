package com.bwf.shop.order.service.impl;

import com.bwf.shop.order.bean.po.Order;
import com.bwf.shop.order.bean.po.OrderDetail;
import com.bwf.shop.order.mapper.OrderDetailMapper;
import com.bwf.shop.order.mapper.OrderMapper;
import com.bwf.shop.order.service.IOrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * OrderDetail 订单详情资源 业务逻辑层 实现类
 * */
@Service
public class OrderDetailService implements IOrderDetailService {

    // 依赖的数据访问层
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    @Transactional( rollbackFor = Exception.class)
    public boolean updateOrderDetail(OrderDetail orderDetail) {

        // 获取 要修改的订单详情 的 原始数据
        OrderDetail old = orderDetailMapper.getOrderDetailById( orderDetail.getId() );

        // 计算 要修改的订单详情对象  在 修改前后的 小计金额差值
        double diff = orderDetail.getOdtails_amount() - old.getOdtails_amount();

        // 修改 订单详情
        int a = orderDetailMapper.updateOrderDetail(orderDetail);

        // 获取 当前修改的订单详情 所属的 订单对象
        Order order = orderMapper.getOrderById( old.getOdtails_orderno_id() );

        // 修改 订单的 商品总金额
        order.setOrder_spuamount( order.getOrder_spuamount() + diff );
        // 修改 订单的 订单总金额
        order.setOrder_totalamount( order.getOrder_totalamount() + diff );

        // 将 订单的修改 同步 修改到 数据库
        int b = orderMapper.updateOrder(order);

        return a > 0;
    }
}
