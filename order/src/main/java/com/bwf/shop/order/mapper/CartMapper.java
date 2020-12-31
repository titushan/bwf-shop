package com.bwf.shop.order.mapper;

import com.bwf.shop.order.bean.bo.CartSearchBo;
import com.bwf.shop.order.bean.po.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cart 购物车资源 数据访问层 接口
 * */
@Repository
public interface CartMapper {

    /**
     * 添加购物车
     * @param cart 要添加的购物车对象
     * @return 数据库受影响的行数
     * */
    int addCart( @Param("cart") Cart cart);

    /**
     * 修改购物车
     * @param cart 要修改的购物车对象
     * @return 数据库受影响的行数
     * */
    int updateCart( @Param("cart") Cart cart );

    /**
     * 删除购物车
     * @param id 要删除的购物车编号
     * @return 数据库受影响的行数
     * */
    int deleteCart( @Param("id") Integer id );

    /**
     * 根据用户编号清空该用户的购物车
     * @param user_id 用户编号
     * @return 数据库受影响的行数
     * */
    int emptyCartByUserId( @Param("user_id") Integer user_id );

    /**
     * 根据购物车搜索业务模型对象查询满足条件的购物车列表
     * @param bo 购物车搜索业务模型对象
     * @return 满足条件的购物车列表
     * */
    List<Cart> getCartList( @Param("bo") CartSearchBo bo);
}
