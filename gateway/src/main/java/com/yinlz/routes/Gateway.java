package com.yinlz.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
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
 * @创建时间 2019-06-10 9:57
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Configuration
public class Gateway{

    /*@Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes().route(p -> p.path("/get").filters(f -> f.addRequestHeader("Hello","World")).uri("http://httpbin.org:80")).build();
    }*/

    // 使用方法: http://127.0.0.1:8066/get?name=typ
    /**
     * 在spring cloud gateway中可以使用Hystrix。Hystrix是 spring cloud中一个服务熔断降级的组件，在微服务系统有着十分重要的作用。
     * Hystrix是 spring cloud gateway中是以filter的形式使用的
     * 该router使用host去断言请求是否进入该路由，当请求的host有“*.hystrix.com”，都会进入该router，
     * 该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，比如本案例中重定向到了“/fallback”
     * @param
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2019/6/10 11:21
    */
    @Bean
    public RouteLocator myRoutes(final RouteLocatorBuilder builder){
        final String httpUri = "http://httpbin.org:80";
        return builder.routes().route(url -> url.path("/get").filters(filter -> filter.addRequestHeader("Hello","World")).uri(httpUri)).route(p -> p.host("*.hystrix.com").filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback"))).uri(httpUri)).build();
    }

    @Bean
    public RouteLocator routeLocator(final RouteLocatorBuilder builder){
        final String httpUri = "http://httpbin.org:80";
        System.out.println(httpUri);
        //return builder.routes().route(r -> r.path("/order/**").filters(f -> f.stripPrefix(1)).uri(httpUri)).build();
        return builder.routes().route(url -> url.path("/order/**").filters(filter -> filter.addRequestHeader("Hello","World")).uri(httpUri)).route(p -> p.host("*.hystrix.com").filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback"))).uri(httpUri)).build();
    }

}