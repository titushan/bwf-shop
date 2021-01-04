package com.bwf.shop.product.bean.vo;

import java.io.Serializable;

public class Channel implements Serializable {

    private String channel_name;
    private Integer channel_parentid;

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public Integer getChannel_parentid() {
        return channel_parentid;
    }

    public void setChannel_parentid(Integer channel_parentid) {
        this.channel_parentid = channel_parentid;
    }
}
