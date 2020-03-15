package com.atguigu.springboot_demo.controller;

import com.atguigu.springboot_demo.dao.entity.AdminDao;
import com.atguigu.springboot_demo.service.serviceImpl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javafx.beans.binding.ObjectExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author liuhaoqi
 * @Date 2020/3/11 17:46
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
@Api(value = "/test",description = "Operation about test" , tags = "测试管理")
public class TestController  {

    @Autowired
    private AdminServiceImpl adminService;

    private Logger logger= LoggerFactory.getLogger(TestController.class);
    @ApiOperation(value = "测试方法一",httpMethod = "GET",notes = "每过几秒就纪录一次")
    @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object")
    @GetMapping("/test01")
    @ResponseBody
    public String test() {
        return "test success!";
    }


    @ApiOperation( httpMethod = "GET", notes = "每过几秒就纪录一次", value = "/findAll")
    @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object")
    @GetMapping("/findAll")
    @ResponseBody
    public Object findAll(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "100") int size) {
        return adminService.findAll(page,size);
    }

    @ApiOperation( httpMethod = "POST", notes = "每过几秒就纪录一次", value = "/registerAccout")
    @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "")
    @PostMapping("/registerAccout")
    @ResponseBody
    public boolean registerAccout(@RequestBody AdminDao adminDao) {
        return adminService.registerAccout(adminDao);
    }

    @ApiOperation( httpMethod = "POST", notes = "每过几秒就纪录一次", value = "/logIn")
    @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "")
    @PostMapping("/logIn")
    @ResponseBody
    public boolean logIn(@RequestBody AdminDao adminDao) {
        return adminService.logIn(adminDao);
    }




}
