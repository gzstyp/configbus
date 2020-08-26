package com.yinlz.controller;

import com.alibaba.fastjson.JSONObject;
import com.yinlz.tool.ToolClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 测试json
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-06 16:16
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping("/api")
public class ApiController{

    final static HashMap<String,String> map = new HashMap<>();

    static {
        map.put("age","34");
        map.put("name","田应平");
    }

    static class User{

        private Integer id;
        private String name;

        public Integer getId(){
            return id;
        }

        public void setId(Integer id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }

    public static final String json(final Object obj){
        final JSONObject json = new JSONObject();
        json.put("obj",obj);
        User user = new User();
        user.id = 2048;
        user.setName("田卓智");
        json.put("user",user);
        return json.toJSONString();
    }

    // http://127.0.0.1:9005/api/print
    @RequestMapping("/print")
    @ResponseBody
    public final void print(final HttpServletRequest request,final HttpServletResponse response){
        final String json = json(map);
        ToolClient.responseJson(json,response);
    }
}