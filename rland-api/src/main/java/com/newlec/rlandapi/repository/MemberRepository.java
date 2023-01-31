package com.newlec.rlandapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.newlec.rlandapi.entity.Member;
import com.newlec.rlandapi.entity.Menu;
import com.newlec.rlandapi.entity.MenuView;

public interface MemberRepository extends JpaRepository<Member, Integer>{ // Menu : Entity, Integer : ID
    @Query(value = "from Member  where username like :username")
    Member findByUsername(@Param("username") String username);

}
