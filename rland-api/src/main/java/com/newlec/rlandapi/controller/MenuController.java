package com.newlec.rlandapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.newlec.rlandapi.entity.Menu;
import com.newlec.rlandapi.entity.MenuView;
import com.newlec.rlandapi.repository.MenuViewRepository;
import com.newlec.rlandapi.service.MenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("menus")
public class MenuController {

    @Autowired
    private MenuService service;

    @Autowired
    private MenuViewRepository repository;

    @CrossOrigin(origins = "http://localhost:5173") // CORS 오류 해결하기 위함
    @GetMapping
    public List<MenuView> getList(
        @RequestParam(defaultValue="",name="q") String query , 
        @RequestParam(defaultValue="1",name="p") int page , 
        @RequestParam(defaultValue="3", name="s")int size){

        // List<Menu> list = service.getList(page,size);
        // List<MenuView> list = repository.findAll();

        List<MenuView> list = service.getViewList(query,page,size);
        

        return list;
    }

    //메뉴
    // /menus/2
    @GetMapping(value="{id}",produces = { 
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    }) 
    public Menu get(@PathVariable int id){
        System.out.println("Menu controller#############################");
        Menu menu = service.get(id);

        return menu;
    }

    
    // @PostMapping(consumes={
        //     MediaType.APPLICATION_JSON_VALUE,
        //     MediaType.APPLICATION_XML_VALUE
        // })
        @CrossOrigin(origins = "http://localhost:5173")     
        @PostMapping
    public Menu create(@Valid @RequestBody Menu menu){
        //name, price 만 전달 , id제외
        Menu newOne = service.create(menu); 

        //id를 포함한새로운 Menu 객체를 반환

        //db에 저장
        //방금저장한 데이터 다시 가져와서
        return newOne;
    }
    
    @PutMapping //json 이 기본이라 consume 을설정하지않음
    public Menu update(@RequestBody Menu menu){
        
        Menu newOne = service.update(menu);
        return newOne;
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){

        //삭제
        return ResponseEntity.noContent().build();
    }


}

