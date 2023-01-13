package com.newlec.rlandapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menus")
public class MenuController {
    // page풀네임이 필요. p와 page / url은 p, 
    // /menus?p=1&s=15
    // /menus만 쓰면 null이 나온다. -> default값을 줘야 한다. 
    @GetMapping("") // 더 추가적인 url없음
    public String getList(
        @RequestParam(name ="p", defaultValue = "1") int page, 
        @RequestParam(name ="s", defaultValue = "15") int size){

        return String.format("getMenu List:page=%d, size%d",page,size);
    }

    // menus/2
    @GetMapping("{id}")
    public String get(int id){
        return String.format("get Menu: id=%id,id");
    }

    @PostMapping
    public String add(){
        return "add Menu";
    }

    @PutMapping
    public String update(){
        return "update Menu";
    }

    @DeleteMapping
    public String delete(){
        return "delete Menu";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    
}
