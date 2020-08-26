package com.yinlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者服务 ，通过网关路由转发到消费者服务，并返回信息回去，因此是个mvc的项目
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-11 14:40
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@SpringBootApplication
public class ClientConsumerService{

    public static void main(String[] args){
        SpringApplication.run(ClientConsumerService.class, args);
        System.out.println("--消费者服务已启动成功--");
    }
}