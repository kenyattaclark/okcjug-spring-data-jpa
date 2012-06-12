package org.okcjug.springdatajpa.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.okcjug.springdatajpa.common.AbstractShowcaseTest;
import org.okcjug.springdatajpa.common.AssociateService;
import org.okcjug.springdatajpa.common.TransactionService;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:application-context-jpa.xml")
public class TransactionServiceIntegrationTest extends AbstractShowcaseTest {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AssociateService associateService;

    @Test
    public void findsByAssociate() throws Exception {

        Associate associate = associateService.findById(1L);

        List<Transaction> accounts = transactionService.findByAssociate(associate);

        assertFalse(accounts.isEmpty());
        assertThat(accounts.get(0).getAssociate(), is(associate));
    }
}