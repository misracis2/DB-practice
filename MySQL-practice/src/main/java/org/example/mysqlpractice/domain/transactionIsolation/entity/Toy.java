package org.example.mysqlpractice.domain.transactionIsolation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Entity
@NoArgsConstructor
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOY_SEQ")
    private Long seq;

    @Column(name = "NAME", length = 10)
    private String name;


    public void setName(String name) {
        this.name = name;
    }
}
