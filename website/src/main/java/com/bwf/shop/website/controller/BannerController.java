package com.bwf.shop.website.controller;

import com.bwf.shop.website.service.IBannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Banner 轮播资源 controller
 * */
@RestController
public class BannerController {

    // 依赖的业务逻辑层
    @Resource
    private IBannerService bannerService;

    @RequestMapping( value = "/banner", method = RequestMethod.GET)
    public Object getBannerList( Byte status ){
        return bannerService.getBannerListByStatus(status);
    }


}
