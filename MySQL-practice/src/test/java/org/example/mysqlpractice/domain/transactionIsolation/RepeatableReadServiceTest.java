package org.example.mysqlpractice.domain.transactionIsolation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepeatableReadServiceTest {

    @Autowired
    private RepeatableReadService repeatableReadService;

    @DisplayName("팬텀 리드 테스트")
    @Test
    void insertDuringSelectTwice() {
        repeatableReadService.insertDuringSelectTwice();
    }
    
    @DisplayName("REPEATABLE_READ 테스트")
    @Test
    void updateDuringSelectTwice() {
        repeatableReadService.updateDuringSelectTwice();
    }
}