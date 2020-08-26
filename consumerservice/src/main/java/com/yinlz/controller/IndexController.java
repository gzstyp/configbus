package com.yinlz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-11 14:42
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
public class IndexController{

    @RequestMapping("/hello")
    public String hello(final String name){
        return "hi," + name;
    }
}