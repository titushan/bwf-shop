package com.bwf.shop.custom.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bwf.shop.custom.bean.po.UserAddress;
import com.bwf.shop.custom.service.IUserAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * UserAddress 客户收货信息资源 controller
 * */
@RestController
public class UserAddressController {

    // 依赖的业务逻辑层
    @Resource
    private IUserAddressService userAddressService;

    // 根据 当前登录的用户  获取 该 用户的收货信息列表
    @RequestMapping( value="/useraddress" , method = RequestMethod.GET )
    public Object getUserAddressList( @RequestHeader Integer user_id ){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",userAddressService.getUserAddressByUserId(user_id));
        return result;
    }

    // 添加 收货信息
    @RequestMapping( value = "/useraddress" , method = RequestMethod.POST )
    public Object addUserAddress( UserAddress userAddress , @RequestHeader Integer user_id ){

        // 设置 收货信息的 所属 用户编号
        userAddress.setUaddr_user_id( user_id );

        // 将 收货信息 添加到数据库
        boolean bo = userAddressService.addUserAddress(userAddress);
        Map<String,Object> result = new HashMap<>();
        if(bo){
            result.put("httpstatus","success");
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("httpcode",500);
        }
        return result;
    }

    // 修改收货信息
    @RequestMapping( value = "/useraddress" , method = RequestMethod.PUT )
    public Object updateUserAddres( UserAddress userAddress ,@RequestHeader Integer user_id ){
        // 设置 收货信息的 最后修改时间
        userAddress.setUpdatetime( new Date(System.currentTimeMillis()) );
        // 修改 收货信息
        boolean bo = userAddressService.updateUserAddress(userAddress);

        Map<String,Object> result = new HashMap<>();
        if(bo){
            result.put("httpstatus","success");
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("httpcode",500);
        }
        return result;
    }

    // 删除收货信息
    @RequestMapping( value = "/useraddress/{id}" , method = RequestMethod.DELETE )
    public Object deleteUserAddress( @PathVariable Integer id ){
        // 删除 收货信息
        boolean bo = userAddressService.deleteUserAddress( id );

        Map<String,Object> result = new HashMap<>();
        if(bo){
            result.put("httpstatus","success");
            result.put("httpcode",200);
        }else{
            result.put("httpstatus","error");
            result.put("httpcode",500);
        }
        return result;
    }

}
