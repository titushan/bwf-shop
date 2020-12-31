package com.bwf.shop.product.bean.po;

import java.sql.Date;

/**
 * Spu 商品
 * */
public class Spu {

    private Integer spu_id; // 商品编号
    private String spu_name;    // 商品名称
    private String spu_title;   // 商品标题
    private String spu_introduction;    // 商品介绍
    private String spu_unit;    // 商品单位
    private Byte spu_status;    // 商品状态
    private Date createtime;    // 创建时间
    private Date updatetime;    // 更新时间
    private Integer spu_brand_id;   // 品牌编号

    // getters and  setters

    public Integer getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Byte getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Byte spu_status) {
        this.spu_status = spu_status;
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

    public Integer getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(Integer spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }
}
