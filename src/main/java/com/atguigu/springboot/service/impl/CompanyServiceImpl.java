package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.entity.CompanyEntity;
import com.atguigu.springboot.entity.UserEntity;
import com.atguigu.springboot.mapper.datasource1.UserMapper;
import com.atguigu.springboot.mapper.datasource2.CompanyMapper;
import com.atguigu.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public List<CompanyEntity> query() {
        return companyMapper.query();
    }

    @Override
    @Transactional
    public void insert(CompanyEntity entity) {
        companyMapper.insert(entity);
//        UserEntity user = new UserEntity();
//        user.setId(10);
//        user.setAge(23);
//        user.setUsername("张国");
//        userMapper.insert(user);
    }

    @Override
    public void delete(CompanyEntity entity) {
        companyMapper.delete(entity);
    }

    @Override
    public void update(CompanyEntity entity) {
        companyMapper.update(entity);
    }

    @Override
    @Cacheable(cacheNames = "company", key = "#id")
    public CompanyEntity get(Integer id) {
        return companyMapper.get(id);
    }

    @Override
    @Async
    public void async() {
        System.out.println("****************3******************");
        try {
            Thread.sleep(5000);
            for (int i = 0; i < 5; i++) {
                System.out.print("=====>" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("****************4******************");
    }
}
