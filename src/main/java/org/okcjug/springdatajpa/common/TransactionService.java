package org.okcjug.springdatajpa.common;

import java.util.List;

import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;


/**
 * Service interface for Transaction
 */
public interface TransactionService {
	/**
	 * Save a transaction
	 * @param account
	 * @return
	 */
	Transaction save(Transaction transaction);
	
	/**
	 * Find transactions by associate
	 * @param associate
	 * @return
	 */
	List<Transaction> findByAssociate(Associate associate);
}