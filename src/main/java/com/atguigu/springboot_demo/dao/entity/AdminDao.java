package com.atguigu.springboot_demo.dao.entity;

import lombok.Data;

/**
 * @Author liuhaoqi
 * @Date 2020/3/12 10:44
 * @Version 1.0
 */
@Data
public class AdminDao {
    private Integer admin_id;
    private String account;
    private String password;
}
