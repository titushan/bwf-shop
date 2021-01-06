package com.bwf.shop.product.service.impl;

import com.bwf.shop.product.bean.po.Brand;
import com.bwf.shop.product.mapper.BrandMapper;
import com.bwf.shop.product.service.IBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandService implements IBrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getBrandListByCategoryId(Integer cate_id) {
        return brandMapper.getBrandListByCategoryId(cate_id);
    }
}
