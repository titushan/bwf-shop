package com.bwf.shop.product.controller;

import com.bwf.shop.product.service.ISpuAttrKeyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SpuAttrKeyController {

    @Resource
    private ISpuAttrKeyService spuAttrKeyService;

    @GetMapping("/attr")
    public Object getSpuAttrKeyListByCategoryId(Integer cate_id, Byte key_issku, Byte key_ishigh){
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",spuAttrKeyService.getSpuAttrKeyListByCategoryId(cate_id, key_issku, key_ishigh));
        return result;
    }

}
