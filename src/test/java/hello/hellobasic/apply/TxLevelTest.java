package hello.hellobasic.apply;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
public class TxLevelTest {

    @Autowired
    LevelService levelService;

    @Test
    void orderTest(){
        levelService.write();
        levelService.read();
    }


    @TestConfiguration
    static class  TxApplyBasicConfig{
        @Bean
        LevelService levelService(){
            return new LevelService();
        }
    }


    @Transactional(readOnly = true)
    static class LevelService{

        // default readOnly = false
        @Transactional(readOnly = false)
        public void write(){
            log.info("call write");
            printTxInfo();
        }

        public void read(){
            log.info("call read");
            printTxInfo();
        }

        public void printTxInfo(){
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("tx active={}",txActive);
            boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            log.info("tx readOnly={}",readOnly);
        }

    }
}
