package com.bwf.shop.custom.controller;

import com.bwf.shop.custom.bean.po.User;
import com.bwf.shop.custom.redis.RedisCache;
import com.bwf.shop.custom.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * User 客户资源 Controller
 * */
@RestController
public class UserController {

    // 依赖的业务逻辑层
    @Resource
    private IUserService userService;

    @Resource
    private RedisCache redisCache;

    @RequestMapping( value = "/regist" , method = RequestMethod.POST )
    public Object regist( User user , String valid ){

        Map<String,Object> result = new HashMap<>();
        if( valid != null
                && redisCache.getObject(user.getUser_phone()) != null
                && valid.equals( redisCache.getObject(user.getUser_phone()).toString() ) ){
            if( userService.regist(user) ){
                result.put("httpstatus","success");
                result.put("httpcode",200);
            }else{
                result.put("httpstatus","error");
                result.put("message","请账户已经存在！");
                result.put("httpcode",401);
            }
        }else{
            result.put("httpstatus","error");
            result.put("message","短信验证错误！");
            result.put("httpcode",402);
        }



        return result;
    }

    @RequestMapping( value = "/login" , method = RequestMethod.POST )
    public Object login( String username , String password ){

        User user = userService.login(username,password);

        Map<String,Object> result = new HashMap<>();
        if( user == null ){
            result.put("httpstatus","error");
            result.put("httpcode",401);
        }else{
            result.put("httpstatus","success");
            result.put("httpcode",200);
            result.put("data",user.getUser_token());
//            result.put("data",null);
        }

        return result;
    }

    @GetMapping("/user")
    public Object getUserByToken(
            @RequestHeader("Authorization") String authorization ,
            @RequestHeader("user_id") Integer user_id){

        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        result.put("data",userService.getUserById(user_id));
        return result;
    }

}
