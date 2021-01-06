package com.bwf.shop.custom.bean.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * 客户收货信息
 * */
public class UserAddress implements Serializable {

    private Integer uaddr_id;     // 收货信息编号
    private String uaddr_name;  // 收货人姓名
    private String uaddr_phone; // 收货人联系电话
    private String uaddr_province;  // 收货 省份/自治区/直辖市
    private String uaddr_city;      // 收货 城市
    private String uaddr_district;  // 收货 区/县
    private String uaddr_address;   // 收货 详细地址
    private String uaddr_label;     // 收货 地标
    private Date createtime;        // 创建时间
    private Date updatetime;        // 修改时间
    private Integer uaddr_user_id;  // 所属客户编号

    // getters and setters

    public Integer getUaddr_id() {
        return uaddr_id;
    }

    public void setUaddr_id(Integer uaddr_id) {
        this.uaddr_id = uaddr_id;
    }

    public String getUaddr_name() {
        return uaddr_name;
    }

    public void setUaddr_name(String uaddr_name) {
        this.uaddr_name = uaddr_name;
    }

    public String getUaddr_phone() {
        return uaddr_phone;
    }

    public void setUaddr_phone(String uaddr_phone) {
        this.uaddr_phone = uaddr_phone;
    }

    public String getUaddr_province() {
        return uaddr_province;
    }

    public void setUaddr_province(String uaddr_province) {
        this.uaddr_province = uaddr_province;
    }

    public String getUaddr_city() {
        return uaddr_city;
    }

    public void setUaddr_city(String uaddr_city) {
        this.uaddr_city = uaddr_city;
    }

    public String getUaddr_district() {
        return uaddr_district;
    }

    public void setUaddr_district(String uaddr_district) {
        this.uaddr_district = uaddr_district;
    }

    public String getUaddr_address() {
        return uaddr_address;
    }

    public void setUaddr_address(String uaddr_address) {
        this.uaddr_address = uaddr_address;
    }

    public String getUaddr_label() {
        return uaddr_label;
    }

    public void setUaddr_label(String uaddr_label) {
        this.uaddr_label = uaddr_label;
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

    public Integer getUaddr_user_id() {
        return uaddr_user_id;
    }

    public void setUaddr_user_id(Integer uaddr_user_id) {
        this.uaddr_user_id = uaddr_user_id;
    }
}
