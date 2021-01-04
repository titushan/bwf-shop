package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.bo.SpuSearchBo;
import com.bwf.shop.product.bean.po.Spu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuMapper {

    List<Spu> getSpuListBySearchBo( @Param("bo") SpuSearchBo bo);

    Long getSpuListSizeBySearchBo( @Param("bo") SpuSearchBo bo);

    Spu getSpuById( @Param("spu_id") Long spu_id );

}
