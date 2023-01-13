package com.newlec.rlandapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menus")
public class MenuController {

    @GetMapping // 더 추가적인 url없음
    public String getMenu(){
        return "get Menu";
    }

    @PostMapping
    public String addMenu(){
        return "add Menu";
    }

    @PutMapping
    public String updateMenu(){
        return "update Menu";
    }

    @DeleteMapping
    public String deleteMenu(){
        return "delete Menu";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    
}
