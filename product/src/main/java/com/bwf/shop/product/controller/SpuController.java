package com.bwf.shop.product.controller;

import com.bwf.shop.product.bean.bo.SpuSearchBo;
import com.bwf.shop.product.service.ICategoryService;
import com.bwf.shop.product.service.ISpuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SpuController {

    @Resource
    private ISpuService spuService;

    @GetMapping("/spu/{spu_id}")
    public Object getSpuById(@PathVariable Long spu_id){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",spuService.getSpuById(spu_id));
        return result;
    }

    @GetMapping("/spu")
    public Object getSpuListBySearchBo( SpuSearchBo bo ){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",spuService.getSpuListBySearchBo(bo));
        result.put("datasize",spuService.getSpuListSizeBySearchBo(bo));
        return result;
    }

}
