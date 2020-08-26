package com.yinlz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户中心
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-06 23:21
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RequestMapping("/user")
@RestController
public class UserController{

    // http://127.0.0.1:9005/user/hello?name=typ
    @RequestMapping("/hello")
    public String hello(final HttpServletRequest request){
        return request.getParameter("name")+",你好";
    }

}