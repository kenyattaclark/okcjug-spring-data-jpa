package org.okcjug.springdatajpa.persistence.spring;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.okcjug.springdatajpa.dao.AssociateDao;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.persistence.common.AbstractShowcaseTest;
import org.okcjug.springdatajpa.predicates.AssociatePredicate;
import org.okcjug.springdatajpa.specifications.AssociateSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:application-context-spring-data-jpa.xml")
public class AssociateDaoIntegrationTest extends AbstractShowcaseTest {

	@Autowired
	private AssociateDao associateDao;
	
	@Test
	public void findsAllAssociates() throws Exception {

		Iterable<Associate> result = associateDao.findAll();

		assertThat(result, is(notNullValue()));
		assertTrue(result.iterator().hasNext());
	}

	@Test
	public void findsFirstPageOfMatthews() throws Exception {

		Page<Associate> customers = associateDao.findByLastName("Matthews", new PageRequest(0, 2));

		assertThat(customers.getContent().size(), is(2));
		assertFalse(customers.hasPreviousPage());
	}

	@Test
	public void findsAssociateById() throws Exception {

		Associate customer = associateDao.findOne(2L);

		assertThat(customer.getFirstName(), is("Carter"));
		assertThat(customer.getLastName(), is("Beauford"));
	}

	@Test
	public void findsAssociatesBySpecification() throws Exception {

		final Associate dave = associateDao.findOne(1L);

		final LocalDate date = new LocalDate(2011, 3, 1);
		List<Associate> result = associateDao.findAll(Specifications.where(AssociateSpecifications.transactionDatesBefore((date))));

		assertThat(result.size(), is(1));
		assertThat(result, Matchers.hasItems(dave));
	}
	
	@Test
    public void findsAssociatesByPredicate() throws Exception {
	    final List<Associate> associates = (List<Associate>)associateDao.findAll(AssociatePredicate.byLastName("Matthews"));
	    
	    Assert.assertThat(associates.size(), CoreMatchers.is(4));
	    
	    final Associate associate = associateDao.findOne(AssociatePredicate.byFirstName("Dave").and(AssociatePredicate.byLastName("Matthews")));
	    Assert.assertThat(associate.getId(), CoreMatchers.is(1l));
    }
}