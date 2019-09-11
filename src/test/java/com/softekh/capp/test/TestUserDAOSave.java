package com.softekh.capp.test;

import com.softekh.capp.config.SpringRootConfig;
import com.softekh.capp.dao.UserDAO;
import com.softekh.capp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ISAAC BLACK
 */
public class TestUserDAOSave {
    public static void main(String[] args) {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
       UserDAO userDAO = ctx.getBean(UserDAO.class);
       User u = new User();
       u.setName("mice");
       u.setPhone("09034935056");
       u.setEmail("mice@softekh.com");
       u.setAddress("Elitor Street");
       u.setLoginName("mice");
       u.setPassword("nutymice");
       u.setRole(1); //Admin Role
       u.setLoginStatus(1); // Active State
       userDAO.save(u);
       System.out.println("---------Data Saved----------");
    }
    
}
