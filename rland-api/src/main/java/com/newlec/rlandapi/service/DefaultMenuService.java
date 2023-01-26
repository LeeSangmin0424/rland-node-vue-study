package com.newlec.rlandapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.newlec.rlandapi.entity.Comment;
import com.newlec.rlandapi.entity.Menu;
import com.newlec.rlandapi.entity.MenuView;
import com.newlec.rlandapi.repository.CommentRepository;
import com.newlec.rlandapi.repository.MenuRepository;
import com.newlec.rlandapi.repository.MenuViewRepository;

@Service
public class DefaultMenuService implements MenuService {
    
    @Autowired
    private MenuRepository repository;

    @Autowired
    private MenuViewRepository viewRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Menu get(int id) {
        Menu menu = null;
        
        Optional<Menu> opt = repository.findById(id);
        if(opt.isPresent())
            menu = opt.get();

        return menu;
    }

    // 목록가져오기
    @Override
    public List<Menu> getList(int page, int size) {
        List<Menu> list = repository.findAll();
        return list;
    }

    @Override
    public Menu create(Menu menu) {
        
       Menu newOne = repository.save(menu);
        System.out.println(newOne);
       // 추가된 메뉴 1개 반환
        return newOne;
    }


    // @Override
    // public Menu update(Menu menu) {

    //     menu.getName();
    //     menu.getPrice();

    //     Menu oldOne = get(menu.getId());
        
    //     if(menu.getName() != null)
    //         oldOne.setName(menu.getName());

    //     if(menu.getPrice() != 0)
    //         oldOne.setPrice(menu.getPrice());

    //     Menu newOne = repository.save(oldOne);


    //     return newOne;
    // }

    @Override
    public Menu update(Menu menu) {
         
        menu.getName();
        menu.getPrice();

        Menu oldOne = get(menu.getId());
        if(menu.getName()!=null)
            oldOne.setName(menu.getName());

        if(menu.getPrice()!=0)
        oldOne.setPrice(menu.getPrice());

        Menu newOne = repository.save(oldOne);
       return newOne;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    // 검색하는 기능 추가
    @Override
    public List<MenuView> getViewList(String query,int page, int size) {
        
        // List<MenuView> list = viewRepository.findAll()
        //                                     .stream()
        //                                     .filter(mv -> mv.getName().contains(query))
        //                                     .toList();
        List<MenuView> list = viewRepository.getViewList("%"+query+"%", PageRequest.of(page-1,6));
        for(MenuView mv : list){
            // 특정컬럼을 가지고 데이터를 가져오고 싶다
            // stream API : 컬렉션한 데이터를 View로 보여준다. // 
            List<Comment> c = commentRepository.findAll()
                                .stream()
                                .filter(cmt->cmt.getMenuId() == mv.getId())
                                .toList();
                
            mv.setComments(c);

        }

        return list;
    }
    
    
}
