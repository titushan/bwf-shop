package com.bwf.shop.order.service.impl;

import com.bwf.shop.order.bean.po.Order;
import com.bwf.shop.order.bean.po.OrderAddress;
import com.bwf.shop.order.mapper.OrderAddressMapper;
import com.bwf.shop.order.mapper.OrderMapper;
import com.bwf.shop.order.service.IOrderAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * OrderAddress 订单收货信息资源 业务逻辑层 实现类
 * */
@Service
public class OrderAddressService implements IOrderAddressService {

    // 依赖的数据访问层
    @Resource
    private OrderAddressMapper orderAddressMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    @Transactional( rollbackFor = Exception.class )
    public boolean addOrderAddress(OrderAddress orderAddress) {
        // 添加订单的收货信息
        int a = orderAddressMapper.addOrderAddress(orderAddress);
        // 根据 订单的收货信息  调用 配送费用的计算规格 或  调用第三方 物流接口中的 配送费用计算方法
        // 获取 当前订单收货信息 所属 的 订单对象
        Order order = orderMapper.getOrderByNo( orderAddress.getOrderNo() );
        // 设置 订单的 配送费用 和 总计金额
        order.setOrder_expressfee( (int)(Math.random() * 1000) * 1.0 );
        order.setOrder_totalamount( order.getOrder_spuamount() + order.getOrder_expressfee() );
        // 将 订单对象的修改 同步更新到数据库
        int b = orderMapper.updateOrder( order );
        return a > 0;
    }

    @Override
    @Transactional( rollbackFor = Exception.class )
    public boolean updateOrderAddress(OrderAddress orderAddress) {

        // 修改 订单收货信息 对象
        int a = orderAddressMapper.updateOrderAddress(orderAddress);
        // 根据 订单的收货信息  调用 配送费用的计算规格 或  调用第三方 物流接口中的 配送费用计算方法
        // 获取 当前订单收货信息 所属 的 订单对象
        Order order = orderMapper.getOrderByNo( orderAddress.getOrderNo() );
        // 设置 订单的 配送费用 和 总计金额
        order.setOrder_expressfee( (int)(Math.random() * 1000) * 1.0 );
        order.setOrder_totalamount( order.getOrder_spuamount() + order.getOrder_expressfee() );
        // 将 订单对象的修改 同步更新到数据库
        int b = orderMapper.updateOrder( order );


        return  a > 0 ;
    }
}
