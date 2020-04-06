package com.run.utils;

import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.jupiter.api.Assertions.*;

class Demo {
    public static void main(String args[]) {
        char c = 'A' ;
        int num = 10 ;
        switch(c) {
            case 'B' :
                num ++ ;
            case 'A' :
                num ++ ;
            case 'Y' :
                num ++ ;
                break ;
            default :
                num -- ;
        }
        System.out.println(num) ;
    }
}
