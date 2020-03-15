package com.atguigu.springboot_demo.service.serviceImpl;

import com.atguigu.springboot_demo.dao.entity.AdminDao;
import com.atguigu.springboot_demo.dao.mapper.AdminMapper;
import com.atguigu.springboot_demo.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author liuhaoqi
 * @Date 2020/3/12 10:23
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Object findAll(int page,int size) {
        PageHelper.startPage(page,size);
        List<AdminDao> adminDaoList=adminMapper.findAll();
        PageInfo<AdminDao> pageInfo=new PageInfo<>(adminDaoList);
        return pageInfo;
    }

    @Override
    public boolean registerAccout(AdminDao adminDao) {
        AdminDao ad = adminMapper.findByAccount(adminDao.getAccount());
        if (ad==null || ad.getAccount()==null || ! ad.getAccount().equals(adminDao.getAccount())) {
            System.out.println("数据库该账号没有");
            int i = adminMapper.regiterAccount(adminDao);
            if (i > 0) {
                //插入成功！
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean logIn(AdminDao adminDao) {
        AdminDao ad = adminMapper.logIn(adminDao);
        if (ad != null) {
            return true;
        }
        return false;
    }


}
