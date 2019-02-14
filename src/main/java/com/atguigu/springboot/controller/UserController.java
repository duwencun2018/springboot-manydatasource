package com.atguigu.springboot.controller;

import com.atguigu.springboot.entity.UserEntity;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public List<UserEntity> query() {
        return userService.query();
    }

    @GetMapping("/get/{id}")
    public UserEntity get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("/insert")
    public String insert(UserEntity entity) {
        userService.insert(entity);
        return "success";
    }

    @PutMapping("/update")
    public String update(UserEntity entity) {
        userService.update(entity);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(UserEntity entity) {
        userService.delete(entity);
        return "success";
    }

    @GetMapping("/sendEmail")
    public String sendMail() {
        userService.sendEmail();
        return "success";
    }
}
