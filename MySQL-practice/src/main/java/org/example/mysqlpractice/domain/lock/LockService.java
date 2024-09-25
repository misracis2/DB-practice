package org.example.mysqlpractice.domain.lock;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mysqlpractice.domain.lock.entity.Product;
import org.example.mysqlpractice.domain.lock.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LockService {

    private final ProductJpaRepository repository;

    @Transactional
    public void decreaseProductQuantity(Long productSeq, int count) {
        Product product = repository.findBySeq(productSeq)
                .orElseThrow(() -> new IllegalArgumentException("not found product"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        product.decreaseQuantity(count);
        log.info("decrease quantity {}. then {}", count, product.getQuantity());

    }

    @Transactional
    public void decreaseProductQuantityWithoutLock(Long productSeq, int count) {
        Product product = repository.findById(productSeq)
                .orElseThrow(() -> new IllegalArgumentException("not found product"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        product.decreaseQuantity(count);
        log.info("decrease quantity {}. then {}", count, product.getQuantity());

    }

}
