package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.SpuAttrValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuAttrValueMapper {

    List<SpuAttrValue> getSpuAttrValueListByKeyId( @Param("key_id") Integer key_id );

}
