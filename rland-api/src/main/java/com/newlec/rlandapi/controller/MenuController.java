package com.newlec.rlandapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.newlec.rlandapi.service.MenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("menus")
public class MenuController {

    // @ExceptionHandler(value = {Exception.class})// 특정 원하는 것만
    // // @ExceptionHandler(value = {MyException.class, BBExcetopn.class})
    // public ResponseEntity<Object> handlerAnyExcetion(Exception ex, WebRequest request){
        
    //     return new ResponseEntity<>(ex, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); // ex를 데이터로 보낸다. 

    // }
    @Autowired
    private MenuService service;

    // page풀네임이 필요. p와 page / url은 p, 
    // /menus?p=1&s=15
    // /menus만 쓰면 null이 나온다. -> default값을 줘야 한다. 
    // @GetMapping("") // 더 추가적인 url없음
    @GetMapping
    public List<Menu> getList(
        @RequestParam(name ="p", defaultValue = "1") int page, 
        @RequestParam(name ="s", defaultValue = "15") int size){

        List<Menu> list = service.getList(page,size);

        // return String.format("getMenu List:page=%d, size%d",page,size);
        return list;
    }

    // menus/2
    // @GetMapping(path = "{id}", produces = {

    //      MediaType.APPLICATION_JSON_VALUE,
    //      MediaType.APPLICATION_XML_VALUE

    //     }) // 문자열을 배열로 받는다. 
    // // public Menu get(@PathVariable int id){
    //     public ResponseEntity<Menu> get(@PathVariable int id){ // 내가 조작한 오류



    //     Menu menu = Menu 
    //                     .builder()
    //                     .name( "아이스 카페라떼")
    //                     .price( 3000)
    //                     .build();

    //     // System.out.println(menu);

    //     // return String.format("get Menu: id= %d",id);
    //     // return menu;
    //     return new ResponseEntity<Menu>(HttpStatus.BAD_REQUEST);
    // }

    public Menu get(@PathVariable int id){ // 내가 조작한 오류


        Menu menu = service.get(id);
    
            return menu;
        }

    @PostMapping(produces = {},consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    }) // 돌려주는 것이기 때문에 produces설정 가능 // consumes : 어떤 포맷으로 받을 까?
    public Menu create( @RequestBody Menu menu){ // 데이터를 받아야 한다. // 현재 만든 menu를 반환 //@RequestBody=> xml로 받음.
        
        // System.out.println(menu);

        // name, price만 전달, id 제외
        Menu newOne = service.create(menu); 

        // db에 저장
        // 방금 저장한 데이터를 다시 가져와서

        // id를 포함한 새로운 Menu 객체를 반환.
        return newOne; 
    }


    @PutMapping // json이 기본이라 consume을 설정하지 않음.
    public Menu update(@RequestBody Menu menu){ // menu를 통으로 받는다.
        // Menu a = null;
        // a.getId();

        Menu newOne = service.update(menu);
        
        return newOne;

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@RequestBody int id){

        // 삭제
        return ResponseEntity.noContent().build();
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    
}
