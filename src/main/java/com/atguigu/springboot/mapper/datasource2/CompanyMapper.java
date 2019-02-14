package com.atguigu.springboot.mapper.datasource2;

import com.atguigu.springboot.entity.CompanyEntity;

import java.util.List;

public interface CompanyMapper {
    List<CompanyEntity> query();

    void insert(CompanyEntity entity);

    void update(CompanyEntity entity);

    CompanyEntity get(Integer id);

    void delete(CompanyEntity entity);
}
