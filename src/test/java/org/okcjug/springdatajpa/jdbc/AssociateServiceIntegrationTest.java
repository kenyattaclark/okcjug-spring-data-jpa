package org.okcjug.springdatajpa.jdbc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.okcjug.springdatajpa.common.AbstractShowcaseTest;
import org.okcjug.springdatajpa.common.AssociateService;
import org.okcjug.springdatajpa.domain.Associate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:application-context-jdbc.xml")
public class AssociateServiceIntegrationTest extends AbstractShowcaseTest {

    @Autowired
    AssociateService service;

    @Test
    public void findsAllAssociates() throws Exception {

        List<Associate> result = service.findAll();

        assertThat(result, is(CoreMatchers.notNullValue()));
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void findsAssociateById() throws Exception {

        Associate customer = service.findById(2L);

        assertThat(customer.getFirstName(), is("Carter"));
        assertThat(customer.getLastName(), is("Beauford"));
    }
}