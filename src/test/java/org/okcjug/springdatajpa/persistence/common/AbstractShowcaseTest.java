package org.okcjug.springdatajpa.persistence.common;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

public abstract class AbstractShowcaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData() throws Exception {
        if (countRowsInTable("Associate") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }
}