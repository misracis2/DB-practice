package org.example.mysqlpractice.domain.transactionIsolation.repository;

import org.example.mysqlpractice.domain.transactionIsolation.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ToyRepository extends JpaRepository<Toy, Long> {


    List<Toy> findBySeqGreaterThan(Long seq);



    Toy findFirstByName(String name);
}
