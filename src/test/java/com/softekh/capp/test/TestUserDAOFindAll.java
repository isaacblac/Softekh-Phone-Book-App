package com.softekh.capp.test;



import com.softekh.capp.test.*;
import com.softekh.capp.config.SpringRootConfig;
import com.softekh.capp.dao.UserDAO;
import com.softekh.capp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ISAAC BLACK
 */
public class TestUserDAOFindAll {
    public static void main(String[] args) {
       ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
       UserDAO userDAO = ctx.getBean(UserDAO.class);
       
       List<User> users = userDAO.findAll();
       for(User u : users)
           System.out.println(u.getUserId()+ " "+u.getName()+ " "+u.getPhone());
       
      
    }
    
}
