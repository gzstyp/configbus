package com.yinlz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 网关的@Controller的方法里不能含有参数HttpServletRequest或HttpServletResponse???
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-10 10:01
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping("/router")
public class ApiController{

    // http://127.0.1.1:8066/router/login?name=www.fwtai.com
    @RequestMapping("/login")
    public void login(final String name){
        System.out.println("--有收到请求--"+name);
    }

    // Mono是一个Reactive stream,访问 http://127.0.1.1:8066/router/fallback?name=www.fwtai.com
    @RequestMapping("/fallback")
    public Mono<String> fallback(final String name){
        System.out.println("--从Gateway网关过滤的请求--"+name);
        return Mono.just("fallback,"+name);
    }
}