package com.bwf.shop.product.service.impl;

import com.bwf.shop.product.bean.po.SpuAttrKey;
import com.bwf.shop.product.mapper.SpuAttrKeyMapper;
import com.bwf.shop.product.service.ISpuAttrKeyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuAttrKeyService implements ISpuAttrKeyService {

    @Resource
    private SpuAttrKeyMapper spuAttrKeyMapper;

    @Override
    public List<SpuAttrKey> getSpuAttrKeyListByCategoryId(Integer cate_id, Byte key_issku, Byte key_ishigh) {
        return spuAttrKeyMapper.getSpuAttrKeyListByCategoryId(cate_id,key_issku,key_ishigh);
    }

    public SpuAttrKeyMapper getSpuAttrKeyMapper() {
        return spuAttrKeyMapper;
    }

    public void setSpuAttrKeyMapper(SpuAttrKeyMapper spuAttrKeyMapper) {
        this.spuAttrKeyMapper = spuAttrKeyMapper;
    }


}
