package com.bwf.shop.order.bean.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * 订单详情
 * */
public class OrderDetail implements Serializable {

    private Integer id;                 // 订单详情id
    private String odtails_name;        // 商品名称
    private String odtails_thumburl;    // 商品封面图片
    private Double odtails_price;       // 商品单价
    private Integer odtails_count;      // 订购数量
    private Double odtails_amount;      // 小计金额
    private Byte odtails_scorestatus;   // 评价状态 0.待评价 1.已评价
    private Date createtime;            // 创建时间
    private Date updatetime;            // 更新时间
    private Integer odtails_orderno_id; // 关联的订单id
    private Integer odtails_spu_id;     // 订购的商品编号
    private String odtails_sku;         // 订购的商品规格

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOdtails_name() {
        return odtails_name;
    }

    public void setOdtails_name(String odtails_name) {
        this.odtails_name = odtails_name;
    }

    public String getOdtails_thumburl() {
        return odtails_thumburl;
    }

    public void setOdtails_thumburl(String odtails_thumburl) {
        this.odtails_thumburl = odtails_thumburl;
    }

    public Double getOdtails_price() {
        return odtails_price;
    }

    public void setOdtails_price(Double odtails_price) {
        this.odtails_price = odtails_price;
    }

    public Integer getOdtails_count() {
        return odtails_count;
    }

    public void setOdtails_count(Integer odtails_count) {
        this.odtails_count = odtails_count;
    }

    public Double getOdtails_amount() {
        return odtails_amount;
    }

    public void setOdtails_amount(Double odtails_amount) {
        this.odtails_amount = odtails_amount;
    }

    public Byte getOdtails_scorestatus() {
        return odtails_scorestatus;
    }

    public void setOdtails_scorestatus(Byte odtails_scorestatus) {
        this.odtails_scorestatus = odtails_scorestatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getOdtails_orderno_id() {
        return odtails_orderno_id;
    }

    public void setOdtails_orderno_id(Integer odtails_orderno_id) {
        this.odtails_orderno_id = odtails_orderno_id;
    }

    public Integer getOdtails_spu_id() {
        return odtails_spu_id;
    }

    public void setOdtails_spu_id(Integer odtails_spu_id) {
        this.odtails_spu_id = odtails_spu_id;
    }

    public String getOdtails_sku() {
        return odtails_sku;
    }

    public void setOdtails_sku(String odtails_sku) {
        this.odtails_sku = odtails_sku;
    }
}
