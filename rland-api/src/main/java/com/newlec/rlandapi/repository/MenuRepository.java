package com.newlec.rlandapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlec.rlandapi.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{ // Menu : Entity, Integer : ID
    
}
