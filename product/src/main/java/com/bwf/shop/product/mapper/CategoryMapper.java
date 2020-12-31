package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    Category getCategoryById( @Param("cate_id") Integer cate_id );

    List<Category> getCategoryListByPid( @Param("pid") Integer pid );

}
