package com.bwf.shop.order.service.impl;

import com.bwf.shop.order.bean.bo.OrderAddBo;
import com.bwf.shop.order.bean.po.Order;
import com.bwf.shop.order.bean.po.OrderDetail;
import com.bwf.shop.order.mapper.CartMapper;
import com.bwf.shop.order.mapper.OrderAddressMapper;
import com.bwf.shop.order.mapper.OrderDetailMapper;
import com.bwf.shop.order.mapper.OrderMapper;
import com.bwf.shop.order.remote.ProductRemote;
import com.bwf.shop.order.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Order 订单资源 业务逻辑层 实现类
 * */
@Service
public class OrderService implements IOrderService {

    // 依赖的数据访问层
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private OrderAddressMapper orderAddressMapper;

    @Resource
    private CartMapper cartMapper;

    // 依赖的远程服务
    @Resource
    private ProductRemote productRemote;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(Order order) {

        // 添加订单到 order 订单表
        int a = orderMapper.addOrder( order );

        // 将订单详情列表 批量添加到 order_details 订单详情表
        int b = orderDetailMapper.addOrderDetailList( order.getId() , order.getOrderDetailList() );

        int c = orderAddressMapper.addOrderAddress( order.getOrderAddress() );
        // 清空用户的购物车
//        int c = cartMapper.emptyCartByUserId( bo.getOrder().getOrder_user_id() );

        return a >0 && b >0 && c > 0 ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateOrder(Order order) {

        // 获取 订单修改之前的原始数据
//        Order old = orderMapper.getOrderById(order.getId());

        // 更新 订单
        int a = orderMapper.updateOrder(order);

//        // 判断 当前订单是否修改了订单状态 并且 订单状态 从 0 -> 2
//        if( old.getOrder_status() == 0 && order.getOrder_status() == 2 ){
//            // 当前订单用户进行了支付 要获取 订单的订单详情列表
//            List<OrderDetail> orderDetailList = orderDetailMapper.getOrderDetailListByOrderId( order.getId() );
//            // 迭代遍历 每一个 订单详情
//            for( OrderDetail detail : orderDetailList ){
//                // 根据 当前迭代遍历到的 订单详情   修改 订购的商品的库存 （调用远程服务）
////                String json = "{\"id\":\""+detail.getOdtails_spu_id()+"\",\"count\":\""+detail.getOdtails_count()+"\"}";
//
//                productRemote.updateSpu( detail.getOdtails_spu_id() , detail.getOdtails_count() );
//            }
//        }

        return a > 0;
    }

    @Override
    public List<Order> getOrderListByUserId(Integer user_id) {
        return orderMapper.getOrderListByUserId(user_id);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }
}
