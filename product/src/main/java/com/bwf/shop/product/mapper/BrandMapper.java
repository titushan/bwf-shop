package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Brand;
import com.bwf.shop.product.bean.po.Spu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {

    Brand getBrandById( @Param("brand_id") String brand_id );

    List<Brand> getBrandListByCategoryId( @Param("cate_id") Integer cate_id );
    
    List<Brand> getBrandListBySpuList( @Param("spuList") List<Spu> spuList);

}
