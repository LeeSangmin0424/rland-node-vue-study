package com.newlec.rlandapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlec.rlandapi.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{ // Menu : Entity, Integer : ID
    
}

// public interface MenuRepository {
//     List<Menu> getList(int offset,int size);
//     Menu get(int id);
//     Menu create(Menu menu);
// }