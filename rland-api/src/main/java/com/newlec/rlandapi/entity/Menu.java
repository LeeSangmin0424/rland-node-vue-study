package com.newlec.rlandapi.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ToString
// @Getter // lombok
// @Setter
@Entity
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // data insert할때 사용
    private int id;
    private String name;
    // @jakarta.validation.constraints.NotNull
    // @NotNull(message = "name 속성은 Null일 수 없습니다.")
    private int price;

    // update할 때, 여기서 setting한다. 
    // @Column(updatable = false, insertable = false) // 예) save할 때 사용하지 마라! 의미한다.
    // private Date regDate; // update가 안되게 fix해준다.

    // private int hit;

    
    
    // 자식이 바뀌면...
    // @OneToOne(cascade = CascadeType.ALL) // ??
    // @OneToOne(fetch = FetchType.LAZY) // 1: 다 관계에서 중요하다 // FetchType.LAZY: 객체가 참조하기 전까지 사용하지 않겠다.
    // @JsonManagedReference
    // @OneToOne(mappedBy = "menu" ) // 부모여서 넣어준 코드
    // @JoinColumn(name = "id") // 이것(View나 join)도 지원해 준다.
    // @OneToOne
    // @JoinColumn(name = "id")
    // private NutritionFacts nutritionFacts;  
    
    // @JsonManagedReference
    // @OneToMany(mappedBy = "menu") // 자신To상대방
    // private List<Comment> comments; // 서비스 계층에서 데이터를 직접 담아줘야 한다.(@가 하나도 없는 경우)




    // 1.기본 생성자. 오버로드 : 2. 모든 생성자때려 넣는 생성자 / 3. insert할 때 쓰는 생성자
    // getter / setter
    // toString

    // public Menu() {
    // }

    // public Menu(int id, String name, int price) {
    //     this.id = id;
    //     this.name = name;
    //     this.price = price;
    // }

   

    // public Menu(String name, int price) {
    //     this.name = name;
    //     this.price = price;
    // }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public int getPrice() {
    //     return price;
    // }

    // public void setPrice(int price) {
    //     this.price = price;
    // }

    // @Override
    // public String toString() {
    //     return "Menu [id=" + id + ", name=" + name + ", price=" + price + "]";
    // }

  

    
}
