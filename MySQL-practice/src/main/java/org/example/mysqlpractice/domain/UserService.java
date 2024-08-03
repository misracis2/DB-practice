package org.example.mysqlpractice.domain;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserService2 userService2;

    public UserService(UserRepository userRepository, UserService2 userService2) {
        this.userRepository = userRepository;
        this.userService2 = userService2;
    }

    @Transactional
    public void save(User user) {
        try {
            userRepository.save(user);
            userService2.errorMethod();
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
