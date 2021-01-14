package com.bwf.shop.order.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bwf.shop.order.bean.bo.OrderAddBo;
import com.bwf.shop.order.bean.po.Order;
import com.bwf.shop.order.bean.po.OrderDetail;
import com.bwf.shop.order.service.IOrderService;
import org.springframework.web.bind.annotation.*;

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
    public Object addOrder( Order order , @RequestHeader Integer user_id ){

        // 设置订单的默认状态
        order.setOrder_status(0);   // 用户已下单，等待用户支付 状态
        // 设置订单的创建时间
        order.setCreatetime(new java.sql.Date(System.currentTimeMillis()));
        // 根据 token 设置 订单的 购买用户编号
        order.setOrder_user_id(user_id);
        // 生成订单编号
        order.setOrder_no(
                new Date(System.currentTimeMillis()).toString() +
                        "u" + order.getOrder_user_id() +
                        "t" + order.getOrder_spuamount() +
                        "r"+(int)( Math.random()*100000 ) );
        order.getOrderAddress().setOrderNo( order.getOrder_no() );
        // 迭代遍历 订单详情列表
        for(OrderDetail detail : order.getOrderDetailList()){
            // 设置 订单详情 的 评价状态
            detail.setOdtails_scorestatus((byte)0);
            // 设置 订单详情 的 创建时间
            detail.setCreatetime(new java.sql.Date(System.currentTimeMillis()));
        }

        // 调用 业务逻辑层 开始 添加 订单
        boolean bo = orderService.addOrder(order);
        Map<String,Object> result = new HashMap<>();
        if( bo ){
            result.put("httpstatus","success");
            result.put("data",order);
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("data",null);
            result.put("httpcode",500);
        }
        return result;
    }

    @RequestMapping( value = "/order" , method = RequestMethod.PATCH)
    public Object updateOrder( Order order ){
        // 设置 订单的更新时间
        order.setUpdatetime(new java.sql.Date(System.currentTimeMillis()));
        // 修改订单
        boolean bo = orderService.updateOrder(order);
        Map<String,Object> result = new HashMap<>();
        if( bo ){
            result.put("httpstatus","success");
            result.put("data",order);
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("data",null);
            result.put("httpcode",500);
        }
        return result;
    }

    @RequestMapping( value = "/order" , method = RequestMethod.GET)
    public Object getOrderList( @RequestHeader Integer user_id ){

        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("data",orderService.getOrderListByUserId(user_id));
        result.put("httpcode",200);
        return result;
    }
    @RequestMapping( value = "/order/{order_id}" , method = RequestMethod.GET)
    public Object getOrderById(@PathVariable Integer order_id , @RequestHeader Integer user_id ){

        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("data",orderService.getOrderById(order_id));
        result.put("httpcode",200);
        return result;
    }
}
