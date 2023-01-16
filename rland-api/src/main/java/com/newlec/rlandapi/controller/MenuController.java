package com.newlec.rlandapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlec.rlandapi.entity.Menu;

import jakarta.validation.Valid;

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

    @PostMapping(produces = {},consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    }) // 돌려주는 것이기 때문에 produces설정 가능 // consumes : 어떤 포맷으로 받을 까?
    public Menu create( @RequestBody Menu menu){ // 데이터를 받아야 한다. // 현재 만든 menu를 반환 //@RequestBody=> xml로 받음.
        
        System.out.println(menu);

        // db에 저장
        // 방금 저장한 데이터를 다시 가져와서
        return menu; 
    }


    @PutMapping // json이 기본이라 consume을 설정하지 않음.
    public Menu update(@RequestBody Menu menu){ // menu를 통으로 받는다.
        Menu a = null;
        a.getId();

        return menu;

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
