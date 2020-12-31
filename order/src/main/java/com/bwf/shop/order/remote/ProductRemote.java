package com.bwf.shop.order.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bwf-shop-product")
public interface ProductRemote {

    @RequestMapping( value = "/spu" , method = RequestMethod.POST )
    public Object updateSpu(@RequestParam("id")  Integer id , @RequestParam("count") Integer count  );

}
