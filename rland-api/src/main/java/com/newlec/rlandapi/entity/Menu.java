package com.newlec.rlandapi.entity;

import jakarta.persistence.Entity;
// import javax.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @ToString
// @Getter // lombok
// @Setter
@Entity
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @jakarta.validation.constraints.NotNull
    // @NotNull(message = “name 속성은 Null일 수 없습니다.”)
    private String name;
    
    private int price;

    // 1.기본 생성자. 오버로드 : 2. 모든 생성자때려 넣는 생성자 / 3. insert할 때 쓰는 생성자
    // getter / setter
    // toString

    public Menu(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Menu() {
    }

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

  

    
}
