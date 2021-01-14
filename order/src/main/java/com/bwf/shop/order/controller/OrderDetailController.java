package com.bwf.shop.order.controller;

import com.bwf.shop.order.bean.po.OrderDetail;
import com.bwf.shop.order.service.IOrderDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * OrderDetail 订单详情资源 controller
 * */
@RestController
public class OrderDetailController {

    // 依赖的业务逻辑层
    @Resource
    private IOrderDetailService orderDetailService;

    // 修改订单详情
    @RequestMapping( value = "/orderdetail" , method = RequestMethod.PATCH )
    public Object updateOrderDetail( OrderDetail orderDetail ){
        // 设置 订单详情的更新时间
        orderDetail.setUpdatetime(new Date(System.currentTimeMillis()));
        // 更新 订单详情
        boolean bo = orderDetailService.updateOrderDetail(orderDetail);

        Map<String,Object> result = new HashMap<>();
        if( bo ){
            result.put("httpstatus","success");
            result.put("data",orderDetail);
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("data",null);
            result.put("httpcode",500);
        }
        return result;
    }

}
