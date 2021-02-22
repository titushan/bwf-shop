package com.bwf.shop.product.service;

import com.bwf.shop.product.bean.po.Category;
import com.bwf.shop.product.bean.po.Spu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(Integer cate_id );

    List<Category> getCategoryListByPid(Integer pid );

    List<Category> getCategoryListBySpuList( List<Spu> spuList);
}
