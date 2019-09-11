package com.softekh.capp.test;

import com.softekh.capp.config.SpringRootConfig;
import com.softekh.capp.domain.User;
import com.softekh.capp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ISAAC BLACK
 */
public class TestUserServiceRegister {
    public static void main(String[] args) {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
       UserService userService = ctx.getBean(UserService.class);
       User u = new User();
       u.setName("Hill");
       u.setPhone("0914466330");
       u.setEmail("nhill@softekh.com");
       u.setAddress("hill");
       u.setLoginName("hill");
       u.setPassword("nhill1990");
       u.setRole(UserService.ROLE_ADMIN); //Admin Role
       u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE); // Active State
       userService.register(u);
       System.out.println("---------User Registered Successfully----------");
    }
    
}
