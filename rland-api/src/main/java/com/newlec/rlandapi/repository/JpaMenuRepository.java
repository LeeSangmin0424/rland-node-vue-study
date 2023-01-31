// package com.newlec.rlandapi.repository;

// import java.util.List;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;

// import com.newlec.rlandapi.entity.Menu;

// import jakarta.persistence.EntityManager;

// // @Repository // 구현체가 담긴다.
// public class JpaMenuRepository implements MenuRepository{

//     @Autowired 
//     // private SessionFactory sessionFactory; // 객체를 만들어주는 역할 : Factory 명명 // session을 만들어서 준다. // boot를 사용하지 않을 경우 사용.// 
//        private EntityManager entityManager;   // boot를 사용하는 경우 // ico에 담아준다.

//     @Override
//     public List<Menu> getList(int offset, int size) {
       
//         Session session = entityManager.unwrap(Session.class);

//         List<Menu> list = session.createQuery("from menu", Menu.class) // 반환 타입의 db table이름, 반환타입
//                                  .list();
//         session.close();

//         return list;
     
//     }

//     @Override
//     public Menu get(int id) {
//         Session session = entityManager.unwrap(Session.class);

//         Menu menu = session.get(Menu.class,id) // 반환 타입의 db table이름, 반환타입
//                                  .list();
//         session.close();

//         return menu;
       
//     }


//     @Override
//     public Menu create(Menu menu) {
        
//         return null;
//     }
    
// }
