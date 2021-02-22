package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.bean.po.SpuAttrKey;
import com.bwf.shop.product.bean.vo.SpuAttrVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuAttrKeyMapper {

    List<SpuAttrKey> getSpuAttrKeyListByCategoryId(
            @Param("cate_id") Integer cate_id,
            @Param("key_issku") Byte key_issku,
            @Param("key_ishigh") Byte key_ishigh);

    List<SpuAttrVo> getSpuAttrVoListBySpuId( @Param("spu_id") Long spu_id );

    List<SpuAttrVo> getSpuAttrKeyListBySpuList( @Param("spuList") List<Spu> spuList);
}
