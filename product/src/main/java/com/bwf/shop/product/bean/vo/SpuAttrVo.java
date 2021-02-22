package com.bwf.shop.product.bean.vo;

import java.io.Serializable;
import java.sql.Date;

public class SpuAttrVo implements Serializable {
    private Integer id;
    private Long spu_id;
    private String key_id;
    private String key_name;
    private Byte key_issku;
    private Byte key_ishigh;
    private Date key_createtime;
    private Date key_updatetime;
    private Long value_id;
    private String value_name;
    private Date value_createtime;
    private Date value_updatetime;
    private String spu_attr_imgs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
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

    public Date getKey_createtime() {
        return key_createtime;
    }

    public void setKey_createtime(Date key_createtime) {
        this.key_createtime = key_createtime;
    }

    public Date getKey_updatetime() {
        return key_updatetime;
    }

    public void setKey_updatetime(Date key_updatetime) {
        this.key_updatetime = key_updatetime;
    }

    public Long getValue_id() {
        return value_id;
    }

    public void setValue_id(Long value_id) {
        this.value_id = value_id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public Date getValue_createtime() {
        return value_createtime;
    }

    public void setValue_createtime(Date value_createtime) {
        this.value_createtime = value_createtime;
    }

    public Date getValue_updatetime() {
        return value_updatetime;
    }

    public void setValue_updatetime(Date value_updatetime) {
        this.value_updatetime = value_updatetime;
    }

    public String getSpu_attr_imgs() {
        return spu_attr_imgs;
    }

    public void setSpu_attr_imgs(String spu_attr_imgs) {
        this.spu_attr_imgs = spu_attr_imgs;
    }
}
