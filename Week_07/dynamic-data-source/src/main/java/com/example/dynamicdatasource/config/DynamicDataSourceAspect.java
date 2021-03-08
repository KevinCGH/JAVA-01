package com.example.dynamicdatasource.config;

import com.example.dynamicdatasource.util.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * DynamicDataSourceAspect
 *
 * @author KevinChen
 * @since 8/3/2021
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    private final String[] QUERY_PREFIX = {"get", "select"};

    @Pointcut("execution(* com.example.dynamicdatasource.mapper.*.*(..))")
    public void doAspect() {
    }

    @Before("doAspect()")
    public void switchDataSource(JoinPoint point) {
        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
        if (isQueryMethod) {
            DynamicDataSourceContextHolder.useSlaveDataSource();
            log.info("Switch DataSource to [{}] in method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }
    }

    @After("doAspect()")
    public void restoreDataSource(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
    }

    private Boolean isQueryMethod(String methodName) {
        for (String prefix : QUERY_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
