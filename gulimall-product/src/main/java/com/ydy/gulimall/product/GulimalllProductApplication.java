package com.ydy.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ydy.gulimall.product.dao")
public class GulimalllProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimalllProductApplication.class, args);
    }

}
