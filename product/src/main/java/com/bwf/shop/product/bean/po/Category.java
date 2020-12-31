package com.bwf.shop.product.bean.po;

import java.sql.Date;

/**
 * Category 商品分类
 * */
public class Category {

    private Integer cate_id; // 分类编号
    private String cate_name;   // 分类名称
    private Integer cate_sort;  // 分类排序
    private Date createtime;    // 创建时间
    private Date updatetime;    // 更新时间
    private Integer cate_parentid;  // 父级分类编号

    // getters and setters

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Integer getCate_sort() {
        return cate_sort;
    }

    public void setCate_sort(Integer cate_sort) {
        this.cate_sort = cate_sort;
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

    public Integer getCate_parentid() {
        return cate_parentid;
    }

    public void setCate_parentid(Integer cate_parentid) {
        this.cate_parentid = cate_parentid;
    }
}
