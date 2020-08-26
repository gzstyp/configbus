package com.yinlz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* @Title: ClientController
* @Description: springboot 接口测试
* 首先启动 Application 程序，然后在浏览器输入 http://127.0.0.1:9006//hello?name=yinlz
* 即可查看信息
* 在类中添加  @RestController, 默认类中的方法都会以json的格式返回
    RefreshScope: 该注解表示在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
不过需要手动刷新，使用POST方式请求该地址就会生效:http://localhost:9006/actuator/refresh
* @Version:1.0.0  
* @author yinlz
* @date 2018年1月3日
 */
@RestController
@RefreshScope
public class Client1Controller{
	
    @Value("${girl.age}")
    private Integer age;

    // http://127.0.0.1:9006/hello?name=fwtai
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return name+","+this.age;
    }

    // http://127.0.1.1:9006/api?name=fwtai
    @RequestMapping("/api")
    public void api(final HttpServletRequest request,final HttpServletResponse response){
        System.out.println("--有收到请求--"+request.getParameter("name"));
    }
}