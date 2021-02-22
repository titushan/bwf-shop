package com.bwf.shop.product.service;

import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.bean.po.SpuAttrKey;
import com.bwf.shop.product.bean.vo.AttrKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISpuAttrKeyService {

    List<SpuAttrKey> getSpuAttrKeyListByCategoryId(
            Integer cate_id,Byte key_issku,Byte key_ishigh);

    List<AttrKey> getSpuAttrKeyListBySpuList(List<Spu> spuList);
}
