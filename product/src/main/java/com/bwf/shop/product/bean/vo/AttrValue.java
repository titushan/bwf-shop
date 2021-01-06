package com.bwf.shop.product.bean.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class AttrValue implements Serializable {

    private Integer value_id; // 属性值编号

    private String value_name;  // 属性值名

    private Date createtime;   // 创建时间

    private Date updatetime;    // 更新时间

    private List<String> value_images;


    public Integer getValue_id() {
        return value_id;
    }

    public void setValue_id(Integer value_id) {
        this.value_id = value_id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
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

    public List<String> getValue_images() {
        return value_images;
    }

    public void setValue_images(List<String> value_images) {
        this.value_images = value_images;
    }
}
