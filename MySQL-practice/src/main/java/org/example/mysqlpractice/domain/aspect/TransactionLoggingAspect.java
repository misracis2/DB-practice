package org.example.mysqlpractice.domain.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Aspect
@Component
public class TransactionLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(TransactionLoggingAspect.class);

    @Pointcut("@annotation(transactional)")
    public void transactionalMethods(Transactional transactional) {
        // 포인트컷은 @Transactional 애노테이션이 붙은 메서드를 대상으로 합니다.
    }

    @Before("transactionalMethods(transactional)")
    public void beforeTransaction(JoinPoint joinPoint, Transactional transactional) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            logger.info("Transaction Start: Method={}", joinPoint.getSignature());
        }
    }

    @AfterReturning("transactionalMethods(transactional)")
    public void afterTransactionSuccess(JoinPoint joinPoint, Transactional transactional) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            logger.info("Transaction Commit: Method={}", joinPoint.getSignature());
        }
    }

    @AfterThrowing(value = "transactionalMethods(transactional)", throwing = "ex")
    public void afterTransactionFailure(JoinPoint joinPoint, Transactional transactional, Throwable ex) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            logger.error("Transaction Rollback: Method={}, Exception={}", joinPoint.getSignature(), ex.getMessage());
        }
    }
}
