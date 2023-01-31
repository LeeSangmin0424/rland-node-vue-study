package com.newlec.rlandapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data // boolean이 없으니까 @Data 써도 괜춘
@AllArgsConstructor
@Builder // 오버로드 생성자
@Entity
@Table(name = "NUTRITION_FACTS") // 이름이 다른 경우
public class NutritionFacts { // 테이블 명과 다르다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int calories;
    @Column(name = "SATURATED_FAT")  // DB와 이름이 다른 경우
    private int saturatedFat;
    // private int menuId; 

    // X @OneToOne(cascade = CascadeType.ALL) // 부모가 수정, 삭제되면 자식도 같이 하겠다. // 자식쪽에서는 조인이 필요하다
    // @JsonBackReference
    // @OneToOne 
    // @JoinColumn(name = "menu_id") // DB의 속성명 사용
    // private Menu menu; // 위의 menuId와 중복이 되는 경우가 된다. -> menuId 주석처리

}
