package com.bwf.shop.website.controller;

import com.bwf.shop.website.common.Random;
import com.bwf.shop.website.messages.Https;
import com.bwf.shop.website.redis.RedisCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private RedisCache redisCache;

    @GetMapping("/send_valid")
    public Object send_valid( String user_phone ){

        String valid = Random.nextInt(100000,999999).toString();
        Map<String,Object> result = new HashMap<>();
        try {
            Https.send( user_phone , "验证码："+valid+"。" );
            redisCache.putObject( user_phone , valid );
            result.put("httpstatus","success");
            result.put("httpcode",200);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            result.put("httpstatus","error");
            result.put("httpcode",500);
        }

        return result;
    }

}
