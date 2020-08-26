package com.yinlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 路由网关
 * 单体应用拆分成多个服务后，对外需要一个统一入口，解耦客户端与内部服务<br/>
 * 网关核心功能是路由转发，因此不要有耗时操作在网关上处理，让请求快速转发到后端服务上<br/>
 * 网关还能做统一的熔断、限流、认证、日志监控等<br/>
 * ---------------------------------------------------------------------------------------------
 * gateway使用的netty+webflux实现,不要加入web依赖(不要引用webmvc),否则初始化会报错,需要加入webflux依赖<br/>
 * ---------------------------------------------------------------------------------------------
 * Spring Cloud Gateway有三个核心概念：路由、断言、过滤器<br/>
 * 过滤器：gateway有两种filter：GlobalFilter、GatewayFilter，全局过滤器默认对所有路由有效。<br/>
 * 网关作为所有请求流量的入口，在实际生产环境中为了保证高可靠和高可用，尽量避免重启，需要用到动态路由配置，在网关运行过程中更改路由配置<br/>
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-07 20:32
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@SpringBootApplication
public class GateWayRoute{

    /*

    客户端会多次请求不同的微服务，增加了客户端的复杂性。
    存在跨域请求，在一定场景下处理相对复杂。
    认证复杂，每个服务都需要独立认证。
    难以重构，随着项目的迭代，可能需要重新划分微服务。例如，可能将多个服务合并成一个或者将一个服务拆分成多个。如果客户端直接与微服务通信，那么重构将会很难实施。
    某些微服务可能使用了防火墙 / 浏览器不友好的协议，直接访问会有一定的困难。

    */

    public static void main(String[] args){
        SpringApplication.run(GateWayRoute.class, args);
        System.out.println("--gateway服务端已启动成功--");
    }
}