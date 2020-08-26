package com.yinlz.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 解决git的webhook报错方法1:Resolved exception caused by handler execution: org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot deserialize instance of `java.lang.String` out
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-05 13:51
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
//@Component // 是否开启
public class ServerFilter implements Filter{

    final String[] includeUrls = new String[]{"/login","/register","/login.html"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain) throws IOException, ServletException{
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //使用HttpServletRequest包装原始请求达到修改post请求中body内容的目的
        final RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper,response);
    }

    @Override
    public void destroy(){
    }

    /**
     * @Description: 是否需要过滤
    */
    public boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls){
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }
}