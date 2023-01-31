package com.newlec.rlandapi.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentView {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private Date regDate;
    private String menuName;
    private int menuPrice;
    
    
}
