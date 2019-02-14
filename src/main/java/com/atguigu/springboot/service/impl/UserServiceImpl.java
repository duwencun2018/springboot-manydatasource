package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.entity.UserEntity;
import com.atguigu.springboot.mapper.datasource1.UserMapper;
import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailUtil mailUtil;
//    // 注入模板引擎
//    @Autowired
//    private TemplateEngine templateEngine;

    @Override
    public List<UserEntity> query() {
        return userMapper.query();
    }

    @Override
    public void insert(UserEntity entity) {
        userMapper.insert(entity);
    }

    @Override
    public void update(UserEntity entity) {
        userMapper.update(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        userMapper.delete(entity);
    }

    @Override
//    @Cacheable(cacheNames = "User", key = "#id")
    public UserEntity get(Integer id) {
        return userMapper.get(id);
    }

    /**
     * 发送邮件
     */
    @Override
    public void sendEmail() {
        logger.info("开始发送邮件");
        mailUtil.sendMail();
        logger.info("发送邮件结束");
    }
}
