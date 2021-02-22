package com.bwf.shop.product.bean.po;

import java.sql.Date;

/**
 * SpuComment 商品评论
 * */
public class SpuComment {

    private Integer id;             // 评论编号
    private Double scomm_score;     // 评论评分
    private String scomm_content;   // 评论内容
    private String scomm_photourls; // 评论上传的图片或视频url路径 json [{"type":"video","url":"xxxx.mp4"},{"type":"image","url":"xxx.jpg"}]
    private Integer scomm_likes;    // 评论点赞数量
    private Byte scomm_status;      // 评论状态  0：启用  1：禁用
    private Date createtime;        // 评论创建时间
    private Date updatetime;        // 最后更新时间
    private Integer scomm_orderno_id;   // 所属订单编号
    private Integer scomm_spu_id;       // 评论的商品编号
    private String scomm_spu_sku;       // 评论的商品规格
    private Integer scomm_user_id;      // 评论用户编号
    private String scomm_user_name;     // 评论用户名称
    private String scomm_user_avatarurl;    // 评论用户头像

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScomm_score() {
        return scomm_score;
    }

    public void setScomm_score(Double scomm_score) {
        this.scomm_score = scomm_score;
    }

    public String getScomm_content() {
        return scomm_content;
    }

    public void setScomm_content(String scomm_content) {
        this.scomm_content = scomm_content;
    }

    public String getScomm_photourls() {
        return scomm_photourls;
    }

    public void setScomm_photourls(String scomm_photourls) {
        this.scomm_photourls = scomm_photourls;
    }

    public Integer getScomm_likes() {
        return scomm_likes;
    }

    public void setScomm_likes(Integer scomm_likes) {
        this.scomm_likes = scomm_likes;
    }

    public Byte getScomm_status() {
        return scomm_status;
    }

    public void setScomm_status(Byte scomm_status) {
        this.scomm_status = scomm_status;
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

    public Integer getScomm_orderno_id() {
        return scomm_orderno_id;
    }

    public void setScomm_orderno_id(Integer scomm_orderno_id) {
        this.scomm_orderno_id = scomm_orderno_id;
    }

    public Integer getScomm_spu_id() {
        return scomm_spu_id;
    }

    public void setScomm_spu_id(Integer scomm_spu_id) {
        this.scomm_spu_id = scomm_spu_id;
    }

    public String getScomm_spu_sku() {
        return scomm_spu_sku;
    }

    public void setScomm_spu_sku(String scomm_spu_sku) {
        this.scomm_spu_sku = scomm_spu_sku;
    }

    public Integer getScomm_user_id() {
        return scomm_user_id;
    }

    public void setScomm_user_id(Integer scomm_user_id) {
        this.scomm_user_id = scomm_user_id;
    }

    public String getScomm_user_name() {
        return scomm_user_name;
    }

    public void setScomm_user_name(String scomm_user_name) {
        this.scomm_user_name = scomm_user_name;
    }

    public String getScomm_user_avatarurl() {
        return scomm_user_avatarurl;
    }

    public void setScomm_user_avatarurl(String scomm_user_avatarurl) {
        this.scomm_user_avatarurl = scomm_user_avatarurl;
    }
}
