package com.newlec.rlandapi.service;

import java.util.List;

import com.newlec.rlandapi.entity.Member;
import com.newlec.rlandapi.entity.Menu;
import com.newlec.rlandapi.entity.MenuView;

public interface MemberService {
    // List<MenuView> getViewList(String query,int page, int size);
    
    Member get(String username);
    // List<Menu> getList(int page, int size);

}
