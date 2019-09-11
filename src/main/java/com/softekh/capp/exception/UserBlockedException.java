package com.softekh.capp.exception;

/**
 *
 * @author ISAAC BLACK
 */
public class UserBlockedException extends Exception {
    /**
     * Create user object without error description
     */
    public UserBlockedException(){
    }
    /**
     * Create user object with error description
     * @param errDesc
     */
    public UserBlockedException(String errDesc){
        super(errDesc);
    }
    
}
