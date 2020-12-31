package com.bwf.shop.order.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bwf.shop.order.bean.bo.OrderAddBo;
import com.bwf.shop.order.bean.po.Order;
import com.bwf.shop.order.bean.po.OrderDetail;
import com.bwf.shop.order.service.IOrderService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Order 订单资源 Controller
 * */
@RestController
public class OrderController {

    // 依赖的业务逻辑层
    @Resource
    private IOrderService orderService;

    @RequestMapping( value = "/order" , method = RequestMethod.POST )
    public Object addOrder( OrderAddBo bo , @RequestHeader String token ){

        // 设置订单的默认状态
        bo.getOrder().setOrder_status(0);   // 用户已下单，等待用户支付 状态
        // 设置订单的创建时间
        bo.getOrder().setCreatetime(new java.sql.Date(System.currentTimeMillis()));
        // 根据 token 设置 订单的 购买用户编号
        DecodedJWT jwt = JWT.decode(token);
        Integer user_id = Integer.parseInt( jwt.getAudience().get(0) );
        bo.getOrder().setOrder_user_id(user_id);
        // 生成订单编号
        bo.getOrder().setOrder_no(
                new Date(System.currentTimeMillis()).toString() +
                        "u" + bo.getOrder().getOrder_user_id() +
                        "t" + bo.getOrder().getOrder_spuamount() +
                        "r"+(int)( Math.random()*100000 ) );

        // 迭代遍历 订单详情列表
        for(OrderDetail detail : bo.getOrderDetailList()){
            // 设置 订单详情 的 评价状态
            detail.setOdtails_scorestatus((byte)0);
            // 设置 订单详情 的 创建时间
            detail.setCreatetime(new java.sql.Date(System.currentTimeMillis()));
        }

        // 调用 业务逻辑层 开始 添加 订单
        boolean result = orderService.addOrder(bo);

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        map.put("order",bo.getOrder());
        map.put("orderDetailList",bo.getOrderDetailList());
        return map;
    }

    @RequestMapping( value = "/order" , method = RequestMethod.PATCH)
    public Object updateOrder( Order order ){
        // 设置 订单的更新时间
        order.setUpdatetime(new java.sql.Date(System.currentTimeMillis()));
        // 修改订单
        boolean result = orderService.updateOrder(order);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    @RequestMapping( value = "/order" , method = RequestMethod.GET)
    public Object getOrderList( @RequestHeader String token ){
        // 从 token 获取 当前登录的用户编号
        DecodedJWT jwt = JWT.decode(token);
        Integer user_id = Integer.parseInt( jwt.getAudience().get(0) );
        return orderService.getOrderListByUserId(user_id);
    }

}
