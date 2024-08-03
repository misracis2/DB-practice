package org.example.mysqlpractice.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setName("testdd12ddddddddddddd");
        User user2 = new User();
        user2.setName("testdd123");
        try {
            userService.save(user2);
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}