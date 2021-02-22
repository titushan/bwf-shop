package com.bwf.shop.product.bean.po;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.sql.Date;

@Document( indexName = "atstudy" , type = "course" )
public class Course implements Serializable {

    private Integer id; // 课程编号
    private String course_name; // 课程名称
    private String course_img;  // 课程图片
    private Integer sort_id;    // 分类编号
    private Integer type_id;    // 课程难度  1：入门  2：进阶  3：高级
    private String course_duration; // 课程课时
    private Date course_time;   // 创建时间
    private Integer student_count;  // 在读人数
    private Integer msg_count;  // 评论数量
    private Integer course_order;   // 课程排序
    private Integer course_free;    // 是否支持免费试学 1:支持免费试学 0：不支持免费试学
    private Double course_price;    // 课程价格
    private Integer course_live;    // 授课方式 1：直播 0：录播
    private Integer high_quality;   // 是否是精品课程  1：精品课程 0：普通课程
    private Integer sell_well;  // 是否是热销课程 1：热销课程 0：普通课程
    private String course_introduce;    // 课程介绍
    private Integer course_mission; // 课程任务数
    private Double course_rate; // 课程评分

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_img() {
        return course_img;
    }

    public void setCourse_img(String course_img) {
        this.course_img = course_img;
    }

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }

    public Date getCourse_time() {
        return course_time;
    }

    public void setCourse_time(Date course_time) {
        this.course_time = course_time;
    }

    public Integer getStudent_count() {
        return student_count;
    }

    public void setStudent_count(Integer student_count) {
        this.student_count = student_count;
    }

    public Integer getMsg_count() {
        return msg_count;
    }

    public void setMsg_count(Integer msg_count) {
        this.msg_count = msg_count;
    }

    public Integer getCourse_order() {
        return course_order;
    }

    public void setCourse_order(Integer course_order) {
        this.course_order = course_order;
    }

    public Integer getCourse_free() {
        return course_free;
    }

    public void setCourse_free(Integer course_free) {
        this.course_free = course_free;
    }

    public Double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(Double course_price) {
        this.course_price = course_price;
    }

    public Integer getCourse_live() {
        return course_live;
    }

    public void setCourse_live(Integer course_live) {
        this.course_live = course_live;
    }

    public Integer getHigh_quality() {
        return high_quality;
    }

    public void setHigh_quality(Integer high_quality) {
        this.high_quality = high_quality;
    }

    public Integer getSell_well() {
        return sell_well;
    }

    public void setSell_well(Integer sell_well) {
        this.sell_well = sell_well;
    }

    public String getCourse_introduce() {
        return course_introduce;
    }

    public void setCourse_introduce(String course_introduce) {
        this.course_introduce = course_introduce;
    }

    public Integer getCourse_mission() {
        return course_mission;
    }

    public void setCourse_mission(Integer course_mission) {
        this.course_mission = course_mission;
    }

    public Double getCourse_rate() {
        return course_rate;
    }

    public void setCourse_rate(Double course_rate) {
        this.course_rate = course_rate;
    }
}
