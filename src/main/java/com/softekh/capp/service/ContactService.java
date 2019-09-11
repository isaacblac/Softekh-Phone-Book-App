package com.softekh.capp.service;

import com.softekh.capp.domain.Contact;
import java.util.List;

/**
 * The interface specify all business operation for contact entity
 *
 * @author ISAAC BLACK
 */
public interface ContactService {

    public void save(Contact c);

    public void update(Contact c);

    public void delete(Integer contactId);

    public void delete(Integer[] contactIds);

    public Contact findById(Integer contactId);

    /**
     * This method return all user contact(user who is logged in)
     *
     * @param userId
     * @return
     */
    public List<Contact> findUserContact(Integer userId);

    /**
     * This method search contact for user(userId) based on
     * free-text-criteria(txt)
     *
     * @param userId User who is logged in
     * @param txt criteria use to search - free-text-search criteria
     * @return
     */
    public List<Contact> findUserContact(Integer userId, String txt);
}
