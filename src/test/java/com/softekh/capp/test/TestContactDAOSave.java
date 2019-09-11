package com.softekh.capp.test;

import com.softekh.capp.config.SpringRootConfig;
import com.softekh.capp.dao.ContactDAO;
import com.softekh.capp.dao.UserDAO;
import com.softekh.capp.domain.Contact;
import com.softekh.capp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ISAAC BLACK
 */
public class TestContactDAOSave {
    public static void main(String[] args) {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
       ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
       Contact c = new Contact();
       c.setContactId(1);
       c.setName("mice");
       c.setPhone("09034935056");
       c.setEmail("mice@softekh.com");
       c.setAddress("Elitor Street");
       c.setRemark("It's good to be here!!!");
       contactDAO.save(c);
       System.out.println("---------Data Saved----------");
    }
    
}
