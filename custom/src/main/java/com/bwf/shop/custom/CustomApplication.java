package com.bwf.shop.custom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.bwf.shop.custom.mapper")
public class CustomApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomApplication.class,args);
    }
}
