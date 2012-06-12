package org.okcjug.springdatajpa.dao;

import org.okcjug.springdatajpa.domain.Associate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AssociateDao extends PagingAndSortingRepository<Associate, Long>, JpaSpecificationExecutor<Associate>, QueryDslPredicateExecutor<Associate> {

    Page<Associate> findByLastName(String lastName, Pageable pageable);
}