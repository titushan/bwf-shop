package com.bwf.shop.order.controller;

import com.bwf.shop.order.bean.po.OrderAddress;
import com.bwf.shop.order.service.IOrderAddressService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * OrderAddress 订单收货信息资源 Controller
 * */
@RestController
public class OrderAddressController {

    // 依赖的业务逻辑层
    @Resource
    private IOrderAddressService orderAddressService;

    // 添加 收货信息
    @RequestMapping( value = "/orderaddress" , method = RequestMethod.POST)
    public Object addOrderAddress(OrderAddress orderAddress , @RequestHeader Integer user_id){

        boolean bo = orderAddressService.addOrderAddress(orderAddress);

        Map<String,Object> result = new HashMap<>();
        if( bo ){
            result.put("httpstatus","success");
            result.put("data",orderAddress);
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("data",null);
            result.put("httpcode",500);
        }
        return result;
    }

    // 修改 订单收货信息
    @RequestMapping( value = "/orderaddress" , method = RequestMethod.PUT)
    public Object updateOrderAddress(OrderAddress orderAddress){
        // 设置 订单收货信息的更新时间
        orderAddress.setUpdateTime(new Date(System.currentTimeMillis()));
        // 更新 订单收货信息
        boolean bo = orderAddressService.updateOrderAddress(orderAddress);

        Map<String,Object> result = new HashMap<>();
        if( bo ){
            result.put("httpstatus","success");
            result.put("data",orderAddress);
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("data",null);
            result.put("httpcode",500);
        }
        return result;
    }

}
