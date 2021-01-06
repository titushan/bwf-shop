package com.bwf.shop.order.service;

import com.bwf.shop.order.bean.bo.CartSearchBo;
import com.bwf.shop.order.bean.po.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Cart 购物车资源 业务逻辑层 接口
 * */
public interface ICartService {


    /**
     * 添加购物车
     * @param cart 要添加的购物车对象
     * @return 数据库受影响的行数
     * */
    boolean addCart(  Cart cart);

    /**
     * 修改购物车
     * @param cart 要修改的购物车对象
     * @return 数据库受影响的行数
     * */
    boolean updateCart(  Cart cart );

    /**
     * 删除购物车
     * @param id 要删除的购物车编号
     * @return 数据库受影响的行数
     * */
    boolean deleteCart(  Integer id );

    /**
     * 根据购物车搜索业务模型对象查询满足条件的购物车列表
     * @param bo 购物车搜索业务模型对象
     * @return 满足条件的购物车列表
     * */
    List<Cart> getCartList(CartSearchBo bo);

    boolean emptyCartByUserId( Integer user_id );
}
