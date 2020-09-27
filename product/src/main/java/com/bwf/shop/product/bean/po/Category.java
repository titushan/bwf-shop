package com.bwf.shop.product.bean.po;

import java.sql.Date;

/**
 * Category 商品分类
 * */
public class Category {

    private Integer id;         // 商品分类编号
    private String cate_name;   // 商品分类名称
    private Integer cate_sort;  // 商品分类排序
    private Date createtime;    // 商品分类创建时间
    private Date updatetime;    // 商品分类最后更新时间
    private Integer parent_id;  // 父级分类的分类编号

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}
