package com.bwf.shop.product.bean.bo;

import com.bwf.shop.product.bean.po.Brand;
import com.bwf.shop.product.bean.po.Category;
import com.bwf.shop.product.bean.po.Sku;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SpuSearchBo {

    private Long spu_id; // 商品编号
    private String spu_name;    // 商品名称
    private String spu_title;   // 商品标题
    private Byte spu_status;    // 商品状态
    private String spu_brand_id;   // 品牌编号
    private Integer cate_id;    // 分类编号
    private List<Integer> spuAttrValueList = new ArrayList<>(); // 属性值列表
    private String valueList;   // 属性值列表 17471,17472
    private Integer start = 0;      // 起始记录索引
    private Integer length = 10;     // 查询记录数

    // getters and setters

    public String getValueList() {
        return valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
        if( this.valueList != null && !( this.valueList.isEmpty() ) ) {
            String[] arr = valueList.split(",");
            for (String v : arr) {
                spuAttrValueList.add(Integer.parseInt(v));
            }
        }
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }

    public Byte getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Byte spu_status) {
        this.spu_status = spu_status;
    }

    public String getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(String spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public List<Integer> getSpuAttrValueList() {
        return spuAttrValueList;
    }

    public void setSpuAttrValueList(List<Integer> spuAttrValueList) {
        this.spuAttrValueList = spuAttrValueList;
    }
}
