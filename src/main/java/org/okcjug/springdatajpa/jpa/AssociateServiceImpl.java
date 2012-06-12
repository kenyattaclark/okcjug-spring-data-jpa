package org.okcjug.springdatajpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.okcjug.springdatajpa.common.AssociateService;
import org.okcjug.springdatajpa.domain.Associate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssociateServiceImpl implements AssociateService {

    @PersistenceContext
    private EntityManager em;
   
    @Override
    public Associate findById(Long id) {
        return em.find(Associate.class, id);
    }

    @Override
    public List<Associate> findAll() {

        return em.createQuery("select o from Associate o", Associate.class).getResultList();
    }

    @Override
    public List<Associate> findAll(int page, int pageSize) {
        TypedQuery<Associate> query = em.createQuery("select o from Associate o", Associate.class);

        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Associate save(final Associate associate) {
        // Is new?
        if (associate.getId() == null) {
            em.persist(associate);
            return associate;
        } else {
            return em.merge(associate);
        }
    }

    @Override
    public List<Associate> findByLastName(final String lastname, final int page, final int pageSize) {
        final TypedQuery<Associate> query = em.createQuery("select a from Associate a where a.lastName = ?1", Associate.class);

        query.setParameter(1, lastname);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }
}