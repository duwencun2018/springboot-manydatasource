package com.atguigu.springboot.service;

import com.atguigu.springboot.entity.CompanyEntity;
import com.atguigu.springboot.entity.UserEntity;

import java.util.List;

public interface CompanyService {
    List<CompanyEntity> query();

    void insert(CompanyEntity entity);


    void delete(CompanyEntity entity);

    void update(CompanyEntity entity);

    CompanyEntity get(Integer id);

    void async();
}
