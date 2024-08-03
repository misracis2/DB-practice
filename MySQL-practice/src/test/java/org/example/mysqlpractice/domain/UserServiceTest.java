package org.example.mysqlpractice.domain;

import org.example.mysqlpractice.domain.rollbackMarkPractice.enitty.User;
import org.example.mysqlpractice.domain.rollbackMarkPractice.UserService;
import org.example.mysqlpractice.domain.rollbackMarkPractice.enitty.User2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @DisplayName("정상적으로 저장되는 경우(롤백마크가 찍히지 않는 경우)")
    @Test
    public void saveComplete() {
        User2 user = new User2();
        user.setName("test0803");
        try {
            userService.saveHavingTransactionRequired(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @DisplayName("동일 트랜잭션 내에 롤백마크가 찍히면 모두 롤백된다.(user 롤백, user2 에러)")
    @Test
    public void saveHavingTransactionRequired() {
        User2 user = new User2();
        user.setName("test1111");
        User2 user2 = new User2();
        user2.setName("errorerrorerrorerrorerrorerror");
        try {
            userService.saveHavingTransactionRequired(user);
            userService.saveHavingTransactionRequired(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @DisplayName("새로운 트랜잭션에서 롤백마크가 찍히면 다른 트랜잭션은 롤백되지 않는다.(user 저장, user2 에러)")
    @Test
    public void saveHavingTransactionRequiresNew() {
        User user = new User();
        user.setName("test0803");
        User user2 = new User();
        user2.setName("errorerrorerrorerrorerrorerror");
        try {
            userService.saveHavingTransactionRequiresNew(user);
            userService.saveHavingTransactionRequiresNew(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}