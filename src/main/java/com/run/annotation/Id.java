package com.run.annotation;


import java.lang.annotation.*;

/**
 * @author edxuanlen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
    String value();
}