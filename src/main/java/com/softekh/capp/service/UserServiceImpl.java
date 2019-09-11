package com.softekh.capp.service;

import com.softekh.capp.dao.BaseDAO;
import com.softekh.capp.dao.UserDAO;
import com.softekh.capp.domain.User;
import com.softekh.capp.exception.UserBlockedException;
import com.softekh.capp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISAAC BLACK
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService  {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User u) {
        userDAO.save(u);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
       String sql="SELECT userId, name, phone, email, address, loginName, role, loginStatus FROM user WHERE loginName=:ln AND password=:pw";
       Map m = new HashMap();
       m.put("ln", loginName);
       m.put("pw", password);
       
       try{
           User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
           if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
               throw new UserBlockedException("Your account has been blocked. Contact the admin");
           }
           return u;
       }catch(EmptyResultDataAccessException ex){
           return null;
       }
    }

    @Override
    public List<User> getUserList() {
        return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void ChangeLoginStatus(Integer userId, Integer loginStatus) {
        String sql = "UPDATE user SET loginStatus=:lst WHERE userId=:uid";
        Map m = new HashMap();
        m.put("uid", userId);
        m.put("lst", loginStatus);
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public Boolean isUserNameExist(String username) {
        String sql = "SELECT count(loginName) FROM user WHERE loginName=?";
        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{username}, Integer.class);
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }
    
}
