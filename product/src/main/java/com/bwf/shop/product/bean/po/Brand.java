package com.bwf.shop.product.bean.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * Brand 品牌
 * */
public class Brand implements Serializable {

    private String brand_id;         // 品牌编号
    private String brand_name;  // 品牌名称
    private String brand_introduction;  // 品牌简介
    private String brand_logourl;   // 品牌Logo图片
    private Integer sortno;     // 品牌排序
    private Date createtime;    // 创建时间
    private Date updatetime;    // 更新时间

    // getters and setters
    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }

    public String getBrand_logourl() {
        return brand_logourl;
    }

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
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
