package org.example.mysqlpractice.domain.rollbackMarkPractice;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.mysqlpractice.domain.rollbackMarkPractice.enitty.User;
import org.example.mysqlpractice.domain.rollbackMarkPractice.enitty.User2;
import org.example.mysqlpractice.domain.rollbackMarkPractice.repository.User2Repository;
import org.example.mysqlpractice.domain.rollbackMarkPractice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final User2Repository user2Repository;

    public UserService(UserRepository userRepository,
                       User2Repository user2Repository
    ) {
        this.userRepository = userRepository;
        this.user2Repository = user2Repository;
    }

    @Transactional
    public void saveHavingTransactionRequiresNew(User user) {
        try {
            userRepository.save(user);
            log.info("{} saved", user.getName());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Transactional
    public void saveHavingTransactionRequired(User2 user) {
        try {
            user2Repository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
