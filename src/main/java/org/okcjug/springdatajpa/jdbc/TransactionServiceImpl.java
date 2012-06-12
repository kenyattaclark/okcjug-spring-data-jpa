package org.okcjug.springdatajpa.jdbc;

import java.util.List;

import org.okcjug.springdatajpa.common.TransactionService;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;

public class TransactionServiceImpl implements TransactionService {

	/* (non-Javadoc)
	 * @see com.mbopartners.techtalks.persistence.common.TransactionService#save(com.mbopartners.techtalks.persistence.domain.Transaction)
	 */
	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mbopartners.techtalks.persistence.common.TransactionService#findTransactionsByAssociate(com.mbopartners.techtalks.persistence.domain.Associate)
	 */
	@Override
	public List<Transaction> findByAssociate(Associate associate) {
		// TODO Auto-generated method stub
		return null;
	}
}