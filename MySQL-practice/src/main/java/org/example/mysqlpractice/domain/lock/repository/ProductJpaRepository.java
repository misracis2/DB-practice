package org.example.mysqlpractice.domain.lock.repository;

import jakarta.persistence.LockModeType;
import org.example.mysqlpractice.domain.lock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findBySeq(Long seq);
}
