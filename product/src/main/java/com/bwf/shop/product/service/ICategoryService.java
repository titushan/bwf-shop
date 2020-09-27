package com.bwf.shop.product.service;

import com.bwf.shop.product.bean.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Category 商品分类 业务逻辑层 接口
 * */
public interface ICategoryService {

    /**
     * 根据父级分类编号查询下属分类集合
     * @param parent_id 父级分类编号
     * @return 下属分类集合
     * */
    List<Category> getCategoryListByParentId( Integer parent_id );

}
