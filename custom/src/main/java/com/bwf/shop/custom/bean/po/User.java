package com.bwf.shop.custom.bean.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * 客户
 * */
public class User implements Serializable {

    private Integer user_id;     // 客户编号
    private String user_phone;  // 客户手机号 可  用于登录
    private String user_email;  // 客户邮箱   可  用于登录
    private String user_password;   // 客户密码   用于登录
    private String user_salt;       // 客户密码盐值
    private String user_token;      // 客户登录后的令牌

    private String user_name;   // 客户昵称
    private String user_avatarurl;  // 客户头像

    private Integer user_securitylevel; // 安全等级
    private Integer user_gender;    // 客户性别  0.未知 1.男 2.女
    private Date user_birthday;     // 客户生日
    private String user_region;     // 客户地区
    private String user_motto;      // 客户个性签名
    private Byte user_status;       // 客户状态 0.正常 1.冻结
    private Date user_loggedtime;   // 最后登录时间
    private Date user_expiretime;   // 客户令牌到期时间
    private String user_loggedip;   // 最后登录设备的ip
    private Integer user_createfrom;    // 注册来源 0.pc平台 1.app平台 2.小程序平台 3.手机H5平台 4.管理平台
    private Date createtime;        // 客户创建时间
    private Date updatetime;        // 更新时间

    // getters and setters


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_salt() {
        return user_salt;
    }

    public void setUser_salt(String user_salt) {
        this.user_salt = user_salt;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avatarurl() {
        return user_avatarurl;
    }

    public void setUser_avatarurl(String user_avatarurl) {
        this.user_avatarurl = user_avatarurl;
    }

    public Integer getUser_securitylevel() {
        return user_securitylevel;
    }

    public void setUser_securitylevel(Integer user_securitylevel) {
        this.user_securitylevel = user_securitylevel;
    }

    public Integer getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Integer user_gender) {
        this.user_gender = user_gender;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_region() {
        return user_region;
    }

    public void setUser_region(String user_region) {
        this.user_region = user_region;
    }

    public String getUser_motto() {
        return user_motto;
    }

    public void setUser_motto(String user_motto) {
        this.user_motto = user_motto;
    }

    public Byte getUser_status() {
        return user_status;
    }

    public void setUser_status(Byte user_status) {
        this.user_status = user_status;
    }

    public Date getUser_loggedtime() {
        return user_loggedtime;
    }

    public void setUser_loggedtime(Date user_loggedtime) {
        this.user_loggedtime = user_loggedtime;
    }

    public Date getUser_expiretime() {
        return user_expiretime;
    }

    public void setUser_expiretime(Date user_expiretime) {
        this.user_expiretime = user_expiretime;
    }

    public String getUser_loggedip() {
        return user_loggedip;
    }

    public void setUser_loggedip(String user_loggedip) {
        this.user_loggedip = user_loggedip;
    }

    public Integer getUser_createfrom() {
        return user_createfrom;
    }

    public void setUser_createfrom(Integer user_createfrom) {
        this.user_createfrom = user_createfrom;
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
