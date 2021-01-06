package com.bwf.shop.product.bean.vo;

import com.bwf.shop.product.bean.po.SpuAttrValue;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AttrKey implements Serializable {

    private Integer key_id;     // 属性键编号

    private String key_name;    // 属性键名称

    private Byte key_issku;

    private Byte key_ishigh;

    private Date createtime;    // 创建时间

    private Date updatetime;    // 更新时间

    private List<AttrValue> attrValueList = new ArrayList<>();

    public Integer getKey_id() {
        return key_id;
    }

    public void setKey_id(Integer key_id) {
        this.key_id = key_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
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

    public List<AttrValue> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<AttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }
}
