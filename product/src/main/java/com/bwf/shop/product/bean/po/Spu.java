package com.bwf.shop.product.bean.po;

import com.alibaba.fastjson.JSON;
import com.bwf.shop.product.bean.vo.AttrKey;
import com.bwf.shop.product.bean.vo.AttrValue;
import com.bwf.shop.product.bean.vo.SpuAttrVo;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Spu 商品
 * */
@Document(indexName = "shop_data" , type = "spu")
public class Spu implements Serializable {
    @Id
    private Long spu_id; // 商品编号
    private String spu_name;    // 商品名称
    private String spu_title;   // 商品标题
    private String spu_introduction;    // 商品介绍
    private String spu_unit;    // 商品单位
    private Byte spu_status;    // 商品状态
    private Date createtime;    // 创建时间
    private Date updatetime;    // 更新时间
    private String spu_brand_id;   // 品牌编号
    private Brand brand;
    private List<Category> categoryList = new ArrayList<>();
    private List<Sku> skuList = new ArrayList<>();
    private List<SpuAttrVo> spuAttrVoList = new ArrayList<>();
    private List<AttrKey> attrKeyList = new ArrayList<>();
    private List<AttrKey> searchList = new ArrayList<>();
    // getters and  setters

    public List<SpuAttrVo> getSpuAttrVoList() {
        return spuAttrVoList;
    }

    public void setSpuAttrVoList(List<SpuAttrVo> spuAttrVoList) {
        boolean flag = true;

        for( SpuAttrVo vo : spuAttrVoList ){
            AttrValue attrValue = new AttrValue();
            attrValue.setValue_id(vo.getValue_id());
            attrValue.setValue_name(vo.getValue_name());
            attrValue.setCreatetime(vo.getValue_createtime());
            attrValue.setUpdatetime(vo.getValue_updatetime());
            attrValue.setValue_images(JSON.parseArray( vo.getSpu_attr_imgs() , String.class ));

            flag = true;
            for( AttrKey ak : getAttrKeyList() ){
                if( ak.getKey_id().equals( vo.getKey_id() ) ){
                    ak.getAttrValueList().add(attrValue);
                    attrValue.setKey_id( ak.getKey_id() );
                    flag = false;
                    break;
                }
            }
            for( AttrKey ak : getSearchList() ){
                if( ak.getKey_id().equals( vo.getKey_id() ) ){
                    ak.getAttrValueList().add(attrValue);
                    attrValue.setKey_id( ak.getKey_id() );
                    flag = false;
                    break;
                }
            }
            if( flag ){
                AttrKey attrKey = new AttrKey();
                attrKey.setKey_id(vo.getKey_id());
                attrKey.setKey_name(vo.getKey_name());
                attrKey.setKey_issku(vo.getKey_issku());
                attrKey.setKey_ishigh(vo.getKey_ishigh());
                attrKey.setCreatetime(vo.getKey_createtime());
                attrKey.setUpdatetime(vo.getKey_updatetime());
                attrKey.getAttrValueList().add(attrValue);
                attrValue.setKey_id( attrKey.getKey_id() );
                if( attrKey.getKey_issku() == 1 ){
                    getAttrKeyList().add(attrKey);
                }else if(attrKey.getKey_issku() == 0){
                    getSearchList().add(attrKey);
                }

            }
        }
    }

    public List<AttrKey> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<AttrKey> searchList) {
        this.searchList = searchList;
    }

    public List<AttrKey> getAttrKeyList() {
        return attrKeyList;
    }

    public void setAttrKeyList(List<AttrKey> attrKeyList) {
        this.attrKeyList = attrKeyList;
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

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Byte getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Byte spu_status) {
        this.spu_status = spu_status;
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

    public String getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(String spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
