package org.example.mysqlpractice.domain.transactionIsolation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepeatableReadServiceTest {

    @Autowired
    private RepeatableReadService repeatableReadService;

    @DisplayName("팬텀 리드")
    @Test
    void insertDuringSelectTwice() {
        repeatableReadService.insertDuringSelectTwice();
    }


    @Test
    void updateDuringSelectTwice() {
        repeatableReadService.updateDuringSelectTwice();
    }
}