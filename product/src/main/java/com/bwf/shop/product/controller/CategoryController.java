package com.bwf.shop.product.controller;

import com.bwf.shop.product.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @GetMapping("/category/{cate_id}")
    public Object getCategoryById(@PathVariable Integer cate_id){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",categoryService.getCategoryById(cate_id));
        return result;
    }

    @GetMapping("/category")
    public Object getCategoryListByPid( Integer pid){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",categoryService.getCategoryListByPid(pid));
        return result;
    }

}
