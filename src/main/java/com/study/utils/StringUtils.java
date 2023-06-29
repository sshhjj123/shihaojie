package com.study.utils;

public class StringUtils {
    static public boolean isNotEmpty(String s){
        if(s.isEmpty()||s.length()==0){
            return false;
        }
        return true;
    }
}
