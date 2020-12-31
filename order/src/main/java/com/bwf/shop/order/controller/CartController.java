package com.bwf.shop.order.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bwf.shop.order.bean.bo.CartSearchBo;
import com.bwf.shop.order.bean.po.Cart;
import com.bwf.shop.order.service.ICartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Cart 购物车资源 Controller
 * */
@RestController
public class CartController {

    // 依赖的业务逻辑层
    @Resource
    private ICartService cartService;

    // 添加购物车
    @RequestMapping( value = "/cart" ,method = RequestMethod.POST)
    public Object addCart(@RequestHeader String token , Cart cart ){

        // 从 token 获取 当前登录的用户编号 设置给 cart 对象
        DecodedJWT jwt = JWT.decode(token);
        Integer user_id = Integer.parseInt( jwt.getAudience().get(0) );
        cart.setCart_userid(user_id);

        // 设置 购物车  默认选中
        cart.setCart_checked( (byte)0 );
        // 设置 购物车  创建时间
        cart.setCreatetime( new Date(System.currentTimeMillis()));

        // 添加购物车
        boolean result = cartService.addCart( cart );

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    // 修改购物车
    @RequestMapping( value = "/cart" ,method = RequestMethod.PUT)
    public Object updateCart( Cart cart ){
        // 设置 购物车 最后更新时间
        cart.setUpdatetime(new Date(System.currentTimeMillis()));
        // 修改购物车
        boolean result = cartService.updateCart(cart);

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    // 删除购物车
    @RequestMapping( value = "/cart/{id}" ,method = RequestMethod.DELETE)
    public Object deleteCart( @PathVariable Integer id){
        boolean result = cartService.deleteCart(id);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    // 查询购物车
    @RequestMapping( value = "/cart" ,method = RequestMethod.GET)
    public Object getCartList( CartSearchBo bo , @RequestHeader String token ){
        // 从token获取当前登录的用户编号 设置给 当前的查询条件bo
        DecodedJWT jwt = JWT.decode(token);
        Integer user_id = Integer.parseInt( jwt.getAudience().get(0) );
        bo.setCart_userid(user_id);
        // 查询 满足条件的 购物车列表
        return cartService.getCartList(bo);
    }

}
