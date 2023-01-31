package com.newlec.rlandapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlec.rlandapi.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{ // Menu : Entity, Integer : ID
    
}
