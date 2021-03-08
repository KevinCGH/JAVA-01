package com.example.dynamicdatasource.config;

import java.lang.annotation.*;

/**
 * @author KevinChen
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
