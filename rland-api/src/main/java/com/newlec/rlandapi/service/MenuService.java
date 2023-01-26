package com.newlec.rlandapi.service;

import java.util.List;

import com.newlec.rlandapi.entity.Menu;
import com.newlec.rlandapi.entity.MenuView;

public interface MenuService {
    List<MenuView> getViewList(String query,int page, int size);
    
    Menu get(int id);
    List<Menu> getList(int page, int size);

    Menu create(Menu menu);
    Menu update(Menu menu);
    void delete(int id);

}
