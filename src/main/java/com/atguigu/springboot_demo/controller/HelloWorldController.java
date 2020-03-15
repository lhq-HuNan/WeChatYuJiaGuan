package com.atguigu.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author liuhaoqi
 * @Date 2020/3/10 15:30
 * @Version 1.0
 */

//这个类的所有方法返回的数据直接写给浏览器，（如果是对象 还能转为json数据）
//@ResponseBody
//@Controller
@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","你好!!");
        return "success";
    }

}
