package com.bwf.shop.order.bean.bo;

import java.sql.Date;

/**
 * 购物车搜索业务模型对象
 * */
public class CartSearchBo {

    private Integer cart_userid;    // 所属用户编号
    private Integer cart_spuid;     // 商品编号
    private String cart_name;       // 商品名称
    private String cart_sku;        // 商品规格

    // getters and setters
    public Integer getCart_userid() {
        return cart_userid;
    }

    public void setCart_userid(Integer cart_userid) {
        this.cart_userid = cart_userid;
    }

    public Integer getCart_spuid() {
        return cart_spuid;
    }

    public void setCart_spuid(Integer cart_spuid) {
        this.cart_spuid = cart_spuid;
    }

    public String getCart_name() {
        return cart_name;
    }

    public void setCart_name(String cart_name) {
        this.cart_name = cart_name;
    }

    public String getCart_sku() {
        return cart_sku;
    }

    public void setCart_sku(String cart_sku) {
        this.cart_sku = cart_sku;
    }
}
