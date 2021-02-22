package com.bwf.shop.product.service.impl;

import com.bwf.shop.product.bean.po.Category;
import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.mapper.CategoryMapper;
import com.bwf.shop.product.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Category getCategoryById(Integer cate_id) {
        return categoryMapper.getCategoryById(cate_id);
    }

    @Override
    public List<Category> getCategoryListByPid(Integer pid) {
        return categoryMapper.getCategoryListByPid(pid);
    }

    @Override
    public List<Category> getCategoryListBySpuList(List<Spu> spuList) {
        return categoryMapper.getCategoryListBySpuList(spuList);
    }
}
