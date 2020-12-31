package com.bwf.shop.custom.controller;

import com.bwf.shop.custom.service.IChinaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * China 中国地区 资源 controller
 * */
@RestController
public class ChinaController {

    // 依赖的业务逻辑层
    @Resource
    private IChinaService chinaService;

    @RequestMapping( value = "/china" , method = RequestMethod.GET)
    public Object getChinaList( Integer pid ){
        return chinaService.getChinaListByPid(pid);
    }

}
