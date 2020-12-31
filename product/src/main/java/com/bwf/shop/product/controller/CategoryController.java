package com.bwf.shop.product.controller;

import com.bwf.shop.product.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @GetMapping("/category/{cate_id}")
    public Object getCategoryById(@PathVariable Integer cate_id){
        return categoryService.getCategoryById(cate_id);
    }

}
