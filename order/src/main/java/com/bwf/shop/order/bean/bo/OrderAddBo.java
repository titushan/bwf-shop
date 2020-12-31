package com.bwf.shop.order.bean.bo;

import com.bwf.shop.order.bean.po.Order;
import com.bwf.shop.order.bean.po.OrderDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加订单业务模型对象
 * */
public class OrderAddBo {

    private Order order;        // 订单对象
    private List<OrderDetail> orderDetailList = new ArrayList<>(); // 订单详情列表

    // getters and setters
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
