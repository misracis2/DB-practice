package org.example.mysqlpractice.domain.lock.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private BigDecimal price;

    private Integer quantity;

    private String name;

    private String code;

    public void decreaseQuantity(int count) {
        this.quantity -= count;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Builder
    public Product(BigDecimal price, Integer quantity, String name, String code) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.code = code;
    }
}
