package com.atguigu.springboot_demo.service;

import com.atguigu.springboot_demo.dao.entity.AdminDao;

import java.util.List;

/**
 * @Author liuhaoqi
 * @Date 2020/3/12 10:22
 * @Version 1.0
 */
public interface AdminService {
    public Object findAll(int page,int size);
    public boolean registerAccout(AdminDao adminDao);
    public boolean logIn(AdminDao adminDao);
}
