package com.bwf.shop.product.service.impl;

import com.bwf.shop.product.bean.bo.SpuSearchBo;
import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.mapper.SpuMapper;
import com.bwf.shop.product.service.ISpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuService implements ISpuService {

    @Resource
    private SpuMapper spuMapper;


    @Override
    public List<Spu> getSpuListBySearchBo(SpuSearchBo bo) {
        return spuMapper.getSpuListBySearchBo(bo);
    }

    @Override
    public List<Spu> getPageableSpuListBySearchBo(SpuSearchBo bo) {
        return spuMapper.getSpuListBySearchBo(bo);
    }

    @Override
    public Long getSpuListSizeBySearchBo(SpuSearchBo bo) {
        return spuMapper.getSpuListSizeBySearchBo(bo);
    }

    @Override
    public Spu getSpuById(Long spu_id) {
        return spuMapper.getSpuById(spu_id);
    }
}
