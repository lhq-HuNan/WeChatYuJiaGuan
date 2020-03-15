package com.atguigu.springboot_demo.dao.mapper;


import com.atguigu.springboot_demo.dao.entity.AdminDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liuhaoqi
 * @Date 2020/3/12 10:25
 * @Version 1.0
 */
@Component
@Mapper
public interface AdminMapper {
    List<AdminDao> findAll();

    AdminDao findByAccount(String account);
    int regiterAccount(AdminDao adminDao);
    AdminDao logIn(AdminDao adminDao);
}
