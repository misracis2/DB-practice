package org.example.mysqlpractice.domain.transactionIsolation;

import lombok.extern.slf4j.Slf4j;
import org.example.mysqlpractice.domain.transactionIsolation.entity.Toy;
import org.example.mysqlpractice.domain.transactionIsolation.repository.ToyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.UUID;


@Slf4j
@Service
public class RepeatableReadService {

    private final ToyRepository toyRepository;
    private final NewTransactionService newTransactionService;

    public RepeatableReadService(ToyRepository toyRepository, NewTransactionService newTransactionService) {
        this.toyRepository = toyRepository;
        this.newTransactionService = newTransactionService;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void insertDuringSelectTwice() {
        List<Toy> toys = toyRepository.findBySeqGreaterThan(5L);
        log.info("first select toy : {}", toys.size());

        insertNewTransaction();

        List<Toy> toys2 = toyRepository.findBySeqGreaterThan(5L);
        log.info("second select toy : {}", toys2.size());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertNewTransaction() {
        Toy toy = new Toy();
        toy.setName("new toy");
        toyRepository.save(toy);
    }


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateDuringSelectTwice() {
        Toy toy = toyRepository.findById(5L)
                .orElseThrow(() -> new IllegalArgumentException("not found toy"));
        log.info("first select toy : {}", toy.getName());

        newTransactionService.updateName(UUID.randomUUID().toString().substring(0, 5));

        Toy toy2 = toyRepository.findById(5L)
                .orElseThrow(() -> new IllegalArgumentException("not found toy"));;
        log.info("second select toy : {}", toy2.getName());
    }
}
