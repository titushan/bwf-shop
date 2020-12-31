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
    public Object getUserAddressList( @RequestHeader String token ){
        // 解码 当前请求报文头 中的 token
        DecodedJWT jwt = JWT.decode( token );
        // 获取 token 中的 当前登录的用户的用户编号
        Integer user_id = Integer.parseInt( jwt.getAudience().get(0) );
        // 获取 当前登录的用户的 收货信息列表
        return userAddressService.getUserAddressByUserId( user_id );
    }

    // 添加 收货信息
    @RequestMapping( value = "/useraddress" , method = RequestMethod.POST )
    public Object addUserAddress( UserAddress userAddress , @RequestHeader String token ){

        // 设置 收货信息的 创建时间
        userAddress.setCreatetime( new Date(System.currentTimeMillis()));

        // 解码 当前请求报文头 中的 token
        DecodedJWT jwt = JWT.decode( token );
        // 获取 token 中的 当前登录的用户的用户编号
        Integer user_id = Integer.parseInt( jwt.getAudience().get(0) );
        // 设置 收货信息的 所属 用户编号
        userAddress.setUaddr_user_id( user_id );

        // 将 收货信息 添加到数据库
        boolean result = userAddressService.addUserAddress(userAddress);

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    // 修改收货信息
    @RequestMapping( value = "/useraddress" , method = RequestMethod.PUT )
    public Object updateUserAddres( UserAddress userAddress ){
        // 设置 收货信息的 最后修改时间
        userAddress.setUpdatetime( new Date(System.currentTimeMillis()) );
        // 修改 收货信息
        boolean result = userAddressService.updateUserAddress(userAddress);

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    // 删除收货信息
    @RequestMapping( value = "/useraddress/{id}" , method = RequestMethod.DELETE )
    public Object deleteUserAddress( @PathVariable Integer id ){
        // 删除 收货信息
        boolean result = userAddressService.deleteUserAddress( id );

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

}
