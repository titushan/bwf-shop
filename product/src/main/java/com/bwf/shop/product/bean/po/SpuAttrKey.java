package com.bwf.shop.product.bean.po;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性键模型对象
 * */
public class SpuAttrKey implements Serializable {

    private String key_id;     // 属性键编号

    private String key_name;    // 属性键名称

    private Byte key_issku;

    private Byte key_ishigh;

    private Date createtime;    // 创建时间

    private Date updatetime;    // 更新时间

    private List<SpuAttrValue> spuAttrValueList = new ArrayList<>();

    // getters and setters


    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public void setSpuAttrValueList(List<SpuAttrValue> spuAttrValueList) {
        this.spuAttrValueList = spuAttrValueList;
    }

    public List<SpuAttrValue> getSpuAttrValueList() {
        return spuAttrValueList;
    }

    public Byte getKey_issku() {
        return key_issku;
    }

    public void setKey_issku(Byte key_issku) {
        this.key_issku = key_issku;
    }

    public Byte getKey_ishigh() {
        return key_ishigh;
    }

    public void setKey_ishigh(Byte key_ishigh) {
        this.key_ishigh = key_ishigh;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
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
