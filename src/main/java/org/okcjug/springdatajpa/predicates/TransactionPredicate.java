package org.okcjug.springdatajpa.predicates;

import org.joda.time.LocalDate;
import org.okcjug.springdatajpa.domain.QTransaction;

import com.mysema.query.types.Predicate;

public class TransactionPredicate {

    public static Predicate getPredicate(LocalDate date) {
        QTransaction transaction = QTransaction.transaction;
        return transaction.date.before(date.toDateMidnight().toDate());
    }
}