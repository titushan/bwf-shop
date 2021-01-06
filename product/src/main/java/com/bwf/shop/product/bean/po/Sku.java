package com.bwf.shop.product.bean.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Sku 商品规格
 * */
public class Sku implements Serializable {

    private Integer sku_id;             // 规格编号
    private Long sku_spu_id;     // 所属商品编号
    private Integer sortno;         // 规格排序
    private String sku_name;        // 规格名称
    private String sku_spuattr;     // 规格值json字符串
    private BigDecimal sku_price;
    private BigDecimal sku_originalprice;
    private BigDecimal sku_costprice;
    private Integer sku_quantity;
    private Integer sku_warning_quantity;
    private Integer sku_max_quantity;
    private Date createtime;        // 创建时间
    private Date updatetime;        // 更新时间

    // getters and setters

    public Integer getSku_id() {
        return sku_id;
    }

    public void setSku_id(Integer sku_id) {
        this.sku_id = sku_id;
    }

    public Long getSku_spu_id() {
        return sku_spu_id;
    }

    public void setSku_spu_id(Long sku_spu_id) {
        this.sku_spu_id = sku_spu_id;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public String getSku_spuattr() {
        return sku_spuattr;
    }

    public void setSku_spuattr(String sku_spuattr) {
        this.sku_spuattr = sku_spuattr;
    }

    public BigDecimal getSku_price() {
        return sku_price;
    }

    public void setSku_price(BigDecimal sku_price) {
        this.sku_price = sku_price;
    }

    public BigDecimal getSku_originalprice() {
        return sku_originalprice;
    }

    public void setSku_originalprice(BigDecimal sku_originalprice) {
        this.sku_originalprice = sku_originalprice;
    }

    public BigDecimal getSku_costprice() {
        return sku_costprice;
    }

    public void setSku_costprice(BigDecimal sku_costprice) {
        this.sku_costprice = sku_costprice;
    }

    public Integer getSku_quantity() {
        return sku_quantity;
    }

    public void setSku_quantity(Integer sku_quantity) {
        this.sku_quantity = sku_quantity;
    }

    public Integer getSku_warning_quantity() {
        return sku_warning_quantity;
    }

    public void setSku_warning_quantity(Integer sku_warning_quantity) {
        this.sku_warning_quantity = sku_warning_quantity;
    }

    public Integer getSku_max_quantity() {
        return sku_max_quantity;
    }

    public void setSku_max_quantity(Integer sku_max_quantity) {
        this.sku_max_quantity = sku_max_quantity;
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
}
