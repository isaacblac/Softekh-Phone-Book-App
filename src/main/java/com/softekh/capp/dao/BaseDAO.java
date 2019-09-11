package com.softekh.capp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author ISAAC BLACK
 */
//Note: Do not use @repository, @Service or @Component Annotation
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
    @Autowired
    public void setDataSource2(DataSource ds){
        super.setDataSource(ds);
    
    }
    
}
