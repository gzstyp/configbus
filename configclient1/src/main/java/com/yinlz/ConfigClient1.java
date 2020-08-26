package com.yinlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @Title: Application
 * @Description:
 * 程序入口
 * EnableDiscoveryClient 表示该项目就具有了服务注册的功能,高版本已废弃
 * @Version:1.0.0
 * @author yinlz
 * @date 2018年3月29日
*/
//@EnableDiscoveryClient //EnableDiscoveryClient可以取代旧的EnableEurekaClient，使用注解EnableDiscoveryClient就能启用服务注册发现功能,同理，EnableHystrix也被EnableCircuitBreaker取代了;
//1. EnableDiscoveryClient注解现在是可选项了(你用不用这个注解，是不会影响服务注册发现功能的)；
//2. 只要依赖了以spring-cloud-starter-netflix为前缀的库(例如spring-cloud-starter-netflix-eureka-client)，就启用了服务注册发现功能;
//3. 使用配置项spring.cloud.service-registry.auto-registration.enabled=false即可禁止服务注册发现功能;
//从官方博客上看来EnableDiscoveryClient注解已经不会影响服务注册发现功能了;
@SpringBootApplication
public class ConfigClient1{

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient1.class, args);
		System.out.println("--配置中心客户端1启动成功--");
	}
}
