package com.newlec.rlandapi.service;

import java.util.List;

import com.newlec.rlandapi.entity.Menu;

public interface MenuService {
    
    Menu get(int id);
    List<Menu> getList(int page, int size);

    Menu create(Menu menu);
    Menu update(Menu menu);
    void delete(int id);

}
