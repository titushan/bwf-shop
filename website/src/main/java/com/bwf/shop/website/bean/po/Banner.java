package com.bwf.shop.website.bean.po;

import java.util.Date;

/**
 * Banner 录播
 * */
public class Banner {

    private Integer id;             // 轮播编号
    private String banner_type;     // 轮播类型
    private String banner_pictureurl;   // 轮播图片路径
    private Byte banner_linkmode;   // 轮播链接类型 1：指定url 2：商品详情 3:分类封面页面
    private String banner_linkurl;  // 轮播链接指定跳转的url
    private Integer banner_goodsid; // 轮播关联的商品编号
    private String banner_goodsname;    // 轮播关联的商品名称
    private Integer banner_categoryid;  // 轮播关联的分类编号
    private String banner_categoryname; // 轮播关联的分类名称
    private Byte banner_status; // 轮播状态 状态 0：启用 1：禁用
    private Date createtime;    // 轮播的创建时间
    private Date updatetime;    // 轮播的最后更新时间

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBanner_type() {
        return banner_type;
    }

    public void setBanner_type(String banner_type) {
        this.banner_type = banner_type;
    }

    public String getBanner_pictureurl() {
        return banner_pictureurl;
    }

    public void setBanner_pictureurl(String banner_pictureurl) {
        this.banner_pictureurl = banner_pictureurl;
    }

    public Byte getBanner_linkmode() {
        return banner_linkmode;
    }

    public void setBanner_linkmode(Byte banner_linkmode) {
        this.banner_linkmode = banner_linkmode;
    }

    public String getBanner_linkurl() {
        return banner_linkurl;
    }

    public void setBanner_linkurl(String banner_linkurl) {
        this.banner_linkurl = banner_linkurl;
    }

    public Integer getBanner_goodsid() {
        return banner_goodsid;
    }

    public void setBanner_goodsid(Integer banner_goodsid) {
        this.banner_goodsid = banner_goodsid;
    }

    public String getBanner_goodsname() {
        return banner_goodsname;
    }

    public void setBanner_goodsname(String banner_goodsname) {
        this.banner_goodsname = banner_goodsname;
    }

    public Integer getBanner_categoryid() {
        return banner_categoryid;
    }

    public void setBanner_categoryid(Integer banner_categoryid) {
        this.banner_categoryid = banner_categoryid;
    }

    public String getBanner_categoryname() {
        return banner_categoryname;
    }

    public void setBanner_categoryname(String banner_categoryname) {
        this.banner_categoryname = banner_categoryname;
    }

    public Byte getBanner_status() {
        return banner_status;
    }

    public void setBanner_status(Byte banner_status) {
        this.banner_status = banner_status;
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
