package org.example.mysqlpractice.domain.rollbackMarkPractice.repository;

import jakarta.transaction.Transactional;
import org.example.mysqlpractice.domain.rollbackMarkPractice.enitty.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    User save(User user);
}
