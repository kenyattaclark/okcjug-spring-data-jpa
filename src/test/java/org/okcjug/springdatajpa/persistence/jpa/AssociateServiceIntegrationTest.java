package org.okcjug.springdatajpa.persistence.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.okcjug.springdatajpa.common.AssociateService;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.persistence.common.AbstractShowcaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:application-context-jpa.xml")
public class AssociateServiceIntegrationTest extends AbstractShowcaseTest {

    @Autowired
    AssociateService service;

    @Test
    public void findsAllAssociates() throws Exception {

        List<Associate> result = service.findAll();

        assertThat(result, is(notNullValue()));
        assertFalse(result.isEmpty());
    }

    @Test
    public void findsPageOfMatthews() throws Exception {

        List<Associate> customers = service.findByLastName("Matthews", 0, 2);

        assertThat(customers.size(), is(2));
    }

    @Test
    public void findsAssociateById() throws Exception {

        Associate customer = service.findById(2L);

        assertThat(customer.getFirstName(), is("Carter"));
        assertThat(customer.getLastName(), is("Beauford"));
    }
}