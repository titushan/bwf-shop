package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Category 商品分类资源 数据访问层 接口
 * */
@Repository
public interface CategoryMapper {

    /**
     * 根据父级分类编号查询下属分类集合
     * @param parent_id 父级分类编号
     * @return 下属分类集合
     * */
    List<Category> getCategoryListByParentId( @Param("parent_id") Integer parent_id );
}
