package org.example.mysqlpractice.domain.lock;

import org.example.mysqlpractice.domain.lock.entity.Product;
import org.example.mysqlpractice.domain.lock.repository.ProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class LockServiceTest {

    @Autowired
    private LockService service;

    @Autowired
    private ProductJpaRepository repository;

    @Test
    void save(){
        repository.save(Product.builder()
                .price(new BigDecimal(10000))
                .name("참외")
                .code("Fruit")
                .quantity(10)
                .build());
    }

    @Test
    void testPessimisticLock() {
        Long productSeq = 1L;

        new Thread(() -> {
            service.decreaseProductQuantity(productSeq, 2);
        }).start();
        new Thread(() -> {
            service.decreaseProductQuantity(productSeq, 5);
        }).start();
    }


    @Test
    void testWithoutPessimisticLock() {
        Long productSeq = 1L;

        new Thread(() -> {
            service.decreaseProductQuantityWithoutLock(productSeq, 2);
        }).start();
        new Thread(() -> {
            service.decreaseProductQuantityWithoutLock(productSeq, 5);
        }).start();
    }
}