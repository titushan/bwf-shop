package com.bwf.shop.product.controller;

import com.bwf.shop.product.service.IBrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BrandController {

    @Resource
    private IBrandService brandService;

    @GetMapping("/brand")
    public Object getBrandListByCategoryId( Integer cate_id ){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",brandService.getBrandListByCategoryId(cate_id));
        return result;
    }

}
