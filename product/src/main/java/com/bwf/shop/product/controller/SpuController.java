package com.bwf.shop.product.controller;

import com.bwf.shop.product.bean.bo.SpuSearchBo;
import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.service.IBrandService;
import com.bwf.shop.product.service.ICategoryService;
import com.bwf.shop.product.service.ISpuAttrKeyService;
import com.bwf.shop.product.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SpuController {

    @Autowired
    @Qualifier("spuESService")
    private ISpuService spuService;

    @Resource
    private IBrandService brandService;
    @Resource
    private ICategoryService categoryService;
    @Resource
    private ISpuAttrKeyService spuAttrKeyService;

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

        List<Spu> spuList = spuService.getSpuListBySearchBo(bo);

        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",spuService.getPageableSpuListBySearchBo(bo));
        if( spuList.size() > 0 ) {
            result.put("brandList", brandService.getBrandListBySpuList(spuList));
            result.put("categoryList", categoryService.getCategoryListBySpuList(spuList));
            result.put("spuAttrList", spuAttrKeyService.getSpuAttrKeyListBySpuList(spuList));
        }
        result.put("datasize",spuService.getSpuListSizeBySearchBo(bo));
        return result;
    }

}
