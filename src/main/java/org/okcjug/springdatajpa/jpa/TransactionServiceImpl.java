package org.okcjug.springdatajpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.okcjug.springdatajpa.common.TransactionService;
import org.okcjug.springdatajpa.domain.Associate;
import org.okcjug.springdatajpa.domain.Transaction;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Transaction save(final Transaction transaction) {
        if (transaction.getId() == null) {
            em.persist(transaction);
            return transaction;
        } else {
            return em.merge(transaction);
        }
    }

    @Override
    public List<Transaction> findByAssociate(final Associate associate) {
        TypedQuery<Transaction> query = em.createQuery("select o from Transaction o where o.associate = ?1", Transaction.class);
        query.setParameter(1, associate);

        return query.getResultList();
    }
}