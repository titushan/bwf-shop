package com.bwf.shop.custom.controller;

import com.bwf.shop.custom.bean.po.User;
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

    @RequestMapping( value = "/regist" , method = RequestMethod.POST )
    public Object regist( User user ){
        Map<String,Object> result = new HashMap<>();
        if( userService.regist(user) ){
            result.put("httpstatus","success");
            result.put("httpcode",200);
        }else{

            result.put("httpstatus","error");
            result.put("httpcode",401);
        }

        return result;
    }

    @RequestMapping( value = "/login" , method = RequestMethod.POST )
    public Object login( String username , String password ){
        System.out.println("  =====> username = " + username);
        System.out.println("  =====> password = " + password);
        User user = userService.login(username,password);
        System.out.println("  =====> user = " + user.getUser_name());
        Map<String,Object> result = new HashMap<>();
        if( user == null ){
            result.put("httpstatus","error");
            result.put("httpcode",401);
        }else{
            result.put("httpstatus","success");
            result.put("httpcode",200);
//            result.put("data",user.getUser_token());
            result.put("data",null);
        }

        return result;
    }
    @PostMapping("/user")
    public Object getUserByToken(
            @RequestHeader("Authorization") String authorization ,
            @RequestHeader("user_id") Integer user_id){

        System.out.println("====> token = " + authorization);
        System.out.println("====> user_id = " + user_id);
        Map<String,Object> result = new HashMap<>();
        result.put("httpstatus","success");
        result.put("httpcode",200);
        return result;
    }

}
