package com.bwf.shop.custom.bean.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 中国地区
 * */
public class China implements Serializable {

    private Integer id;     // 地区编号
    private String name;    // 地区名称
    private Integer pid;    // 父级地区编号
    private List<China> children = new ArrayList<>();

    // getters and setters

    public List<China> getChildren() {
        return children;
    }

    public void setChildren(List<China> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
