package com.newlec.rlandapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.newlec.rlandapi.entity.Menu;
import com.newlec.rlandapi.entity.MenuView;

public interface MenuViewRepository extends JpaRepository<MenuView, Integer>{

     // 원하는 interface 목록 추가 가능 // 구현에 대해서 따로 구현하지 않고 @Query사용
     // 방법 1 @Query(value = "from MenuView mv where mv.name like '%아%'") // where절을 구현하기 위한 //,nativeQuery = false : 기본값 // true면 jpa를 사용하지 말아야 한다. mybitis로 가든가.
     // entity를 가지고 query를 만든거. 따라서 db가 바뀌어도 무리 없음.
     // db를 바꾸는 이유 때문에 entity query사용. jpql // dbms에 종속되지 않는다.
     // 특정 os에 종속되지 않게 java 플랫폼을 사용했는데,, 

     // 방법 2 // @Param("query") String query값을 사용하겠다. Default서비스에 있는 query값을 받아서 검색 //
     @Query(value = "from MenuView mv where mv.name like :query order by id desc") 
    //  @Query(value = "from MenuView mv where mv.name like :query limit 0,1",nativeQuery = true) 
     
     List<MenuView> getViewList(@Param("query") String query, Pageable pageable); // Pageable pageable : import domain

    // List<MenuView> getViewList(String query, int page, int size); // Menu : Entity, Integer : ID
    
}
