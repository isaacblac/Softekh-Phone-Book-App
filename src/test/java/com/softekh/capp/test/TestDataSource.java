
package com.softekh.capp.test;

import com.softekh.capp.config.SpringRootConfig;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ISAAC BLACK
 */
public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"isaac", "07032945056", "otisaac@gmail.com", "obinze", "isaac", "prodigy007"};
        jt.update(sql,param);
        System.out.println("-----------SQL Executed----------");
    }
    
}
