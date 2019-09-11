package com.softekh.capp.util;

/**
 * This class contain Utility methods related to string operation
 */
public class StringUtil {
    public static String toCommaSeparatedString(Object[] items ){
    StringBuilder sb = new StringBuilder();
    for(Object item : items){
    sb.append(item).append(",");
    }
    if(sb.length()>0){
    sb.deleteCharAt(sb.length()-1);
    }
    return sb.toString();
    }
    
}
