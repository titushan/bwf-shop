package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Sku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuMapper {

    List<Sku> getSkuListBySpuId( @Param("spu_id") Long spu_id );

}
