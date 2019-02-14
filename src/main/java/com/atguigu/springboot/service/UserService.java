package com.atguigu.springboot.service;

import com.atguigu.springboot.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> query();

    void insert(UserEntity entity);

    void update(UserEntity entity);

    void delete(UserEntity entity);

    UserEntity get(Integer id);

    void sendEmail();
}
