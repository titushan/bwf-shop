package com.bwf.shop.product.service.impl;

import com.bwf.shop.product.bean.po.Category;
import com.bwf.shop.product.mapper.CategoryMapper;
import com.bwf.shop.product.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Category 分类资源 业务逻辑层 实现类
 * */
@Service
public class CategoryService implements ICategoryService {

    // 依赖的数据访问层
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryListByParentId(Integer parent_id) {
        return categoryMapper.getCategoryListByParentId(parent_id);
    }
}
