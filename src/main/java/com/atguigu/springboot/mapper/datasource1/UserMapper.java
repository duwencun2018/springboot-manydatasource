package com.atguigu.springboot.mapper.datasource1;

import com.atguigu.springboot.entity.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> query();

    void insert(UserEntity entity);

    void update(UserEntity entity);

    void delete(UserEntity entity);

    UserEntity get(Integer id);
}
