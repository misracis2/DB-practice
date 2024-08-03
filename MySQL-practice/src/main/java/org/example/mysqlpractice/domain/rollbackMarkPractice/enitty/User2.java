package org.example.mysqlpractice.domain.rollbackMarkPractice.enitty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ")
    private Long id;

    @Column(name = "NAME", length = 10)
    private String name;
}
