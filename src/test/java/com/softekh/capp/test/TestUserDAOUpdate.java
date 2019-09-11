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
public class TestUserDAOUpdate {
    public static void main(String[] args) {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
       UserDAO userDAO = ctx.getBean(UserDAO.class);
       //TODO: The user details will be taken from Update User Profile page
       User u = new User();
       u.setUserId(8);
       u.setName("mice tommy");
       u.setPhone("09034935056");
       u.setEmail("mice.tom@softekh.com");
       u.setAddress("Elitor Street Chicago");
       u.setRole(1); //Admin Role
       u.setLoginStatus(1); // Active State
       
       userDAO.update(u);
       System.out.println("---------Data Updated----------");
    }
    
}
