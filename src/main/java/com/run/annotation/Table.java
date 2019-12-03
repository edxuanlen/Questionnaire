package com.run.annotation;

import java.lang.annotation.*;

/**
 * @author edxuanlen
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String value();
}