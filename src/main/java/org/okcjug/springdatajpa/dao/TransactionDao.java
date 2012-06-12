package org.okcjug.springdatajpa.dao;

import java.util.List;

import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;


public interface TransactionDao extends CrudRepository<Transaction, Long>, QueryDslPredicateExecutor<Associate>{
    
    /**
     * Returns all transactions belonging to the given {@link Associate}.
     * 
     * @param customer
     * @return
     */
    List<Transaction> findByAssociate(Associate associate);
    
    /**
     * Property traversal on associate's first name property
     * @param firstName
     * @return
     */
    List<Transaction> findByAssociateFirstName(String firstName);
//    @Query("from Transaction t where t.associate.firstName = :firstName")
//    List<Transaction> findByAssociateFirstName(@Param("firstName") String firstName);
    
}