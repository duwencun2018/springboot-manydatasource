package com.atguigu.springboot.controller;

import com.atguigu.springboot.entity.CompanyEntity;
import com.atguigu.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/query")
    public List<CompanyEntity> query() {
        return companyService.query();
    }

    @GetMapping("/get/{id}")
    public CompanyEntity get(@PathVariable("id") Integer id) {
        return companyService.get(id);
    }

    @PostMapping("/insert")
    public String insert(CompanyEntity entity) {
        companyService.insert(entity);
        return "success";
    }

    @PutMapping("/update")
    public String update(CompanyEntity entity) {
        companyService.update(entity);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(CompanyEntity entity) {
        companyService.delete(entity);
        return "success";
    }

    @GetMapping("/async")
    public String async() {
        System.out.println("****************1******************");
        companyService.async();
        System.out.println("****************2******************");
        return "success";
    }

}
