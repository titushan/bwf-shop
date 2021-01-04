package com.bwf.shop.zuul;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@MapperScan("com.bwf.shop.zuul.mapper")
public class ZuulApplication {
    public static void main( String[] args ){
        SpringApplication.run( ZuulApplication.class,args );
    }
}
