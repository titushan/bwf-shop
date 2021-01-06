package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {

    Brand getBrandById( @Param("brand_id") Integer brand_id );

    List<Brand> getBrandListByCategoryId( @Param("cate_id") Integer cate_id );

}
