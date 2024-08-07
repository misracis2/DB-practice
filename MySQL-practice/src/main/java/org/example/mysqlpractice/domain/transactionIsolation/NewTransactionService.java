package org.example.mysqlpractice.domain.transactionIsolation;

import lombok.extern.slf4j.Slf4j;
import org.example.mysqlpractice.domain.transactionIsolation.entity.Toy;
import org.example.mysqlpractice.domain.transactionIsolation.repository.ToyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class NewTransactionService {
    private final ToyRepository toyRepository;

    public NewTransactionService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateName(String name) {
        Toy toy = toyRepository.findById(5L)
                .orElseThrow(() -> new IllegalArgumentException("not found toy"));
        toy.setName(name);
        toyRepository.save(toy);
        log.info("update toy : {}", toy.toString());
    }
}
