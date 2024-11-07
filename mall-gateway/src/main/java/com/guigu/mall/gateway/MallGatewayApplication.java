package com.guigu.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// exclude = {DataSourceAutoConfiguration.class}: mall-common中导入了mybatis数据库相关的包
// 如果不排除掉，会在启动的时候报数据库相关的错误

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MallGatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(MallGatewayApplication.class, args);
	}

}
