package com.bwf.shop.order.service.impl;

import com.bwf.shop.order.bean.bo.CartSearchBo;
import com.bwf.shop.order.bean.po.Cart;
import com.bwf.shop.order.mapper.CartMapper;
import com.bwf.shop.order.service.ICartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *  Cart 购物车资源 业务逻辑层 实现类
 * */
@Service
public class CartService implements ICartService {

    // 依赖的数据访问层
    @Resource
    private CartMapper cartMapper;

    @Override
    @Transactional( rollbackFor = Exception.class )
    public boolean addCart(Cart cart) {

        // 判断 当前登录的用户 对 当前商品 当前规格选项 是否已经有购物车记录
        CartSearchBo bo = new CartSearchBo();
        bo.setCart_userid( cart.getCart_userid() );
        bo.setCart_spuid( cart.getCart_spuid() );
        bo.setCart_name( cart.getCart_name() );
        int a = 0;
        // 去数据库查询 该用户编号、商品编号、商品规格的 购物车记录 是否存在
        List<Cart> cartList = cartMapper.getCartList(bo);
        if( cartList.size() > 0 ){
            // 该用户已经购买过了该商品编号、商品规格的产品  修改订购数量
            // 获取 原始订购数据
            Cart old = cartList.get(0);
            // 在 原始订购数据 的 购买数量上 添加 新购买的数量
            old.setCart_count( old.getCart_count() + cart.getCart_count() );
            // 将 原始订购数据 同步更新到数据库
            a = cartMapper.updateCart( old );
            cart.setCar_id( old.getCar_id() );
        }else{
            // 该用户还没有购买过该商品编号、商品规格的产品  添加一条cart购物车记录
            a = cartMapper.addCart( cart );
        }

        return a > 0;
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartMapper.updateCart(cart) > 0;
    }

    @Override
    public boolean deleteCart(Integer id) {
        return cartMapper.deleteCart(id) > 0;
    }

    @Override
    public List<Cart> getCartList(CartSearchBo bo) {
        return cartMapper.getCartList(bo);
    }

    @Override
    public boolean emptyCartByUserId(Integer user_id) {
        return cartMapper.emptyCartByUserId(user_id) > 0;
    }
}
