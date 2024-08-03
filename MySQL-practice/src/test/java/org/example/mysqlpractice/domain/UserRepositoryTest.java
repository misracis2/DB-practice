package org.example.mysqlpractice.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setName("testdddddddddddddddd");

        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}