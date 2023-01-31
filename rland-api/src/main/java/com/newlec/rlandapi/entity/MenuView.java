package com.newlec.rlandapi.entity;

import java.util.List;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Immutable
// @Table(name="menu_view")
// View는 데이터를 가져올 때 사용(읽기 전용)// 데이터를 수정, 삭제할 때는 view사용X//
public class MenuView { //MenuView로 인식해서 @Table 주석처리

    // db와 동기화되서 데이터가 바뀔 것을 염려해서 오류 발생
    // 따라서 @Immutable 써준다.
    @Id    
    private int id;
    private int price;
    private String name;

    private int calories;
    private int saturatedFat;

    // private NutritionFacts nutritionFacts;
    
    @Transient // 관리대상에서 빠진다. getter,setter는 있는데.. null로 나온다.
    private List<Comment> comments;
    
}
