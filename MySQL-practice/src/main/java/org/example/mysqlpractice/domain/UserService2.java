package org.example.mysqlpractice.domain;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService2 {

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void errorMethod() {
        try {
            String[] arr = new String[1];
            String err = arr[2];
        }catch (Exception e) {
            System.out.println("Error in errorMethod");
            log.error(e.getStackTrace().toString());
        }



    }
}
