package com.newlec.rlandapi.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @Table(name = "COMMENT")
public class Comment {
    
    @Id
    private int id;
    private String content;
    // @Column(name = "reg_date")
    private Date regDate;
    private int menuId; // 외래키 .. 이제는 부모에 대한 객체를 찾아가서 연결한다.

    // @JsonBackReference
    // @ManyToOne // 자신To상대방 => 자신이 Many쪽 / Menu가 1
    // @JoinColumn(name = "menu_id")
    // private Menu menu; // 알아서 주키를이용한다. Menu.id와 Comment.menu_id를 맵핑한다.
    
}
