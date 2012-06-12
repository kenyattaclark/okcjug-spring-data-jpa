package org.okcjug.springdatajpa.spring;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.okcjug.springdatajpa.common.AbstractShowcaseTest;
import org.okcjug.springdatajpa.dao.AssociateDao;
import org.okcjug.springdatajpa.dao.TransactionDao;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;
import org.okcjug.springdatajpa.predicates.TransactionPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:application-context-spring-data-jpa.xml")
public class TransactionDaoIntegrationTest extends AbstractShowcaseTest {

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private AssociateDao associateDao;

	@Test
	public void findsAssociatesTransactions() {

		Associate associate = associateDao.findOne(1L);
		List<Transaction> transactions = transactionDao.findByAssociate(associate);

		assertFalse(transactions.isEmpty());
		assertThat(transactions.get(0).getAssociate(), is(associate));
	}
	
	@Test
	public void findsTransactionsByAssociatesFirstName() {
	    List<Transaction> transactions = transactionDao.findByAssociateFirstName("Dave");

	    assertFalse(transactions.isEmpty());
        assertThat(transactions.size(), is(1));
	}
	
	@Test
    public void findsAssociatesByQueryDsl() throws Exception {

        @SuppressWarnings("unused")
        final Associate dave = associateDao.findOne(1L);

        LocalDate date = new LocalDate(2011, 3, 1);
        List<Associate> result = (List<Associate>) transactionDao.findAll(TransactionPredicate.getPredicate(date));

        assertThat(result.size(), is(1));
    }
}