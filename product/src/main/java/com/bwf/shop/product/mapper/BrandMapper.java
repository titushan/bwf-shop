package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandMapper {

    Brand getBrandById( @Param("brand_id") Integer brand_id );

}
