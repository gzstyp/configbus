package com.yinlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务发现注册，供gateway转发请求时获取服务实例 ip+port
 * @Title: ConfigEurekaApplication
 * @Description:
 * springcloud服务入口
 * EnableEurekaServer 注解启动一个服务注册中心
 * @Version:1.0.0
 * @author yinlz
 * @date 2018年3月29日
*/
@SpringBootApplication
@EnableEurekaServer
public class ConfigBusEureka{

	public static void main(String[] args) {
		SpringApplication.run(ConfigBusEureka.class, args);
		 System.out.println("config bus 注册中心服务启动...");
	}
}