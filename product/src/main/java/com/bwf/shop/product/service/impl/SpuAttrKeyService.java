package com.bwf.shop.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.bean.po.SpuAttrKey;
import com.bwf.shop.product.bean.vo.AttrKey;
import com.bwf.shop.product.bean.vo.AttrValue;
import com.bwf.shop.product.bean.vo.SpuAttrVo;
import com.bwf.shop.product.mapper.SpuAttrKeyMapper;
import com.bwf.shop.product.service.ISpuAttrKeyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpuAttrKeyService implements ISpuAttrKeyService {

    @Resource
    private SpuAttrKeyMapper spuAttrKeyMapper;

    @Override
    public List<SpuAttrKey> getSpuAttrKeyListByCategoryId(Integer cate_id, Byte key_issku, Byte key_ishigh) {
        return spuAttrKeyMapper.getSpuAttrKeyListByCategoryId(cate_id,key_issku,key_ishigh);
    }

    @Override
    public List<AttrKey> getSpuAttrKeyListBySpuList(List<Spu> spuList) {
        List<SpuAttrVo> voList = spuAttrKeyMapper.getSpuAttrKeyListBySpuList(spuList);
        List<AttrKey> attrKeyList = new ArrayList<>();
        boolean flag = true;

        for( SpuAttrVo vo : voList ){
            AttrValue attrValue = new AttrValue();
            attrValue.setValue_id(vo.getValue_id());
            attrValue.setValue_name(vo.getValue_name());
            attrValue.setCreatetime(vo.getValue_createtime());
            attrValue.setUpdatetime(vo.getValue_updatetime());
            attrValue.setValue_images(JSON.parseArray( vo.getSpu_attr_imgs() , String.class ));

            flag = true;
            for( AttrKey ak : attrKeyList ){
                if( ak.getKey_id().equals( vo.getKey_id() ) ){
                    ak.getAttrValueList().add(attrValue);
                    attrValue.setKey_id( ak.getKey_id() );
                    flag = false;
                    break;
                }
            }
            if( flag ){
                AttrKey attrKey = new AttrKey();
                attrKey.setKey_id(vo.getKey_id());
                attrKey.setKey_name(vo.getKey_name());
                attrKey.setKey_issku(vo.getKey_issku());
                attrKey.setKey_ishigh(vo.getKey_ishigh());
                attrKey.setCreatetime(vo.getKey_createtime());
                attrKey.setUpdatetime(vo.getKey_updatetime());
                attrKey.getAttrValueList().add(attrValue);
                attrValue.setKey_id( attrKey.getKey_id() );
                attrKeyList.add(attrKey);
            }
        }
        return attrKeyList;
    }

    public SpuAttrKeyMapper getSpuAttrKeyMapper() {
        return spuAttrKeyMapper;
    }

    public void setSpuAttrKeyMapper(SpuAttrKeyMapper spuAttrKeyMapper) {
        this.spuAttrKeyMapper = spuAttrKeyMapper;
    }


}
