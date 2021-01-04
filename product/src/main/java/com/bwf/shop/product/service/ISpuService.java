package com.bwf.shop.product.service;

import com.bwf.shop.product.bean.bo.SpuSearchBo;
import com.bwf.shop.product.bean.po.Spu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISpuService {

    List<Spu> getSpuListBySearchBo(SpuSearchBo bo);
    Long getSpuListSizeBySearchBo(SpuSearchBo bo);
    Spu getSpuById(Long spu_id );
}
