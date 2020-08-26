package com.yinlz.config;

import org.springframework.stereotype.Component;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-05 13:48
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Component
public class RequestWrapper extends HttpServletRequestWrapper{

    public RequestWrapper(final HttpServletRequest request){
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException{
        byte[] bytes = new byte[0];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new ServletInputStream(){

            @Override
            public boolean isFinished(){
                return byteArrayInputStream.read() == -1 ? true : false;
            }

            @Override
            public boolean isReady(){
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener){
            }

            @Override
            public int read() throws IOException{
                return byteArrayInputStream.read();
            }
        };
    }
}