package com.newlec.rlandapi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    // @jakarta.validation.constraints.NotNull
    // @NotNull(message = "name 속성은 Null일 수 없습니다.")
    private int price;
    
    
    // 자식이 바뀌면...
    // @OneToOne(cascade = CascadeType.ALL) // ??
    // @OneToOne(fetch = FetchType.LAZY) // 1: 다 관계에서 중요하다
    @OneToOne // 부모여서 넣어준 코드
    @JoinColumn(name = "id", referencedColumnName = "menuId") // 이것(View나 join)도 지원해 준다.
    private NutritionFacts nutritionFacts;  
    

    // private List<Comment> comments; //getComments가 된 것. 주석만 풀면 오류가 난다.




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
