package org.okcjug.springdatajpa.common;

import java.util.List;

import org.okcjug.springdatajpa.domain.Associate;


/**
 * Service interface for Associate
 */
public interface AssociateService {

    /**
     * Returns the {@link Associate} with the given id or {@literal null} if no
     * {@link Associate} with the given id was found.
     * 
     * @param id
     * @return
     */
    Associate findById(Long id);


    /**
     * Saves the given {@link Associate}.
     * 
     * @param associate
     * @return
     */
    Associate save(Associate associate);


    /**
     * Returns all Associates.
     * 
     * @return
     */
    List<Associate> findAll();


    /**
     * Returns the page of {@link Associate}s with the given index of the given
     * size.
     * 
     * @param page
     * @param pageSize
     * @return
     */
    List<Associate> findAll(int page, int pageSize);


    /**
     * Returns the page of {@link Associate}s with the given lastName and the
     * given page index and page size.
     * 
     * @param lastName
     * @param page
     * @param pageSize
     * @return
     */
    List<Associate> findByLastName(String lastName, int page, int pageSize);
}