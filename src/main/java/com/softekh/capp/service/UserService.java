package com.softekh.capp.service;

import com.softekh.capp.domain.User;
import com.softekh.capp.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author ISAAC BLACK
 */
public interface UserService {
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    /**
     * The method handle the user registration task
     * @param u The new user details as user object.
     */
    public void register(User u);
    /**
     * The method handle login operation(authentication) using given credentials. 
     * It returns user object when successful and null when it fail!
     * When user account is blocked, exception will be thrown by this method.
     * @param loginName
     * @param password
     * @return 
     * @throws com.softekh.capp.exception.UserBlockedException when user account is blocked 
     */
    public User login(String loginName, String password) throws UserBlockedException;
    /**
     * Call this method to get list of registered users
     *@return 
     */
    public List<User> getUserList();
    /**
     * this method change the user login status for details passed as argument
     * @param userId
     * @param loginStatus
     */
    public void ChangeLoginStatus(Integer userId, Integer loginStatus);
    
    /**
     * Check user name availability
     * @param username
     * @return 
     */
    public Boolean isUserNameExist(String username);
}
