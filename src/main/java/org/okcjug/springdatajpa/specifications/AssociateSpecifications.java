package org.okcjug.springdatajpa.specifications;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDate;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;
import org.springframework.data.jpa.domain.Specification;


/**
 * Collection of {@link Specification} implementations.
 * 
 */
public class AssociateSpecifications {

	/**
	 * All transactions with an {@link Transaction} date before the given date.
	 * 
	 * @param date
	 * @return
	 */
	public static Specification<Associate> transactionDatesBefore(final LocalDate date) {

		return new Specification<Associate>() {

			@Override
			public Predicate toPredicate(Root<Associate> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Root<Transaction> transactions = query.from(Transaction.class);
				Path<Date> transactionDate = transactions.<Date> get("date");
				Predicate associateIsTransactionOwner = cb.equal(transactions.<Associate> get("associate"), root);
				Predicate transactionDateBefore = cb.lessThan(transactionDate, date.toDateMidnight().toDate());

				return cb.and(associateIsTransactionOwner, transactionDateBefore);
			}
		};
	}
}