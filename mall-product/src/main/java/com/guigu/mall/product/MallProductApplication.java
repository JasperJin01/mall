package com.guigu.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  整合mybatis-plus：导入依赖，配置，
 */
@SpringBootApplication
@MapperScan("com.guigu.mall.product.dao")
public class MallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }
}

