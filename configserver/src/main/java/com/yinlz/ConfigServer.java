package com.yinlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
*  参考 https://www.cnblogs.com/xuwujing/p/10602687.html
* @Title: ConfigServerApplication
* @Description:
* 程序入口 
* EnableDiscoveryClient: 启用服务注册与发现,表示该项目就具有了服务注册的功能,高版本已废弃
  EnableConfigServer:    启用config配置中心
* @Version:1.0.0  
* @author pancm
* @date 2018年3月29日
*/
//@EnableDiscoveryClient //EnableDiscoveryClient可以取代旧的EnableEurekaClient，使用注解EnableDiscoveryClient就能启用服务注册发现功能,同理，EnableHystrix也被EnableCircuitBreaker取代了;
//1. EnableDiscoveryClient注解现在是可选项了(你用不用这个注解，是不会影响服务注册发现功能的)；
//2. 只要依赖了以spring-cloud-starter-netflix为前缀的库(例如spring-cloud-starter-netflix-eureka-client)，就启用了服务注册发现功能;
//3. 使用配置项spring.cloud.service-registry.auto-registration.enabled=false即可禁止服务注册发现功能;
//从官方博客上看来EnableDiscoveryClient注解已经不会影响服务注册发现功能了;
@EnableConfigServer
@SpringBootApplication
public class ConfigServer{

    /*
        协议转换，路由转发
        流量聚合，对流量进行监控，日志输出
        作为整个系统的前端工程，对流量进行控制，有限流的作用
        作为系统的前端边界，外部流量只能通过网关才能访问系统
        可以在网关层做权限的判断
        可以在网关层做缓存
    */

	public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
		System.out.println("--配置中心服务端已启动成功--");
	}
}