package io.kimmking.spring02;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Aop1
 *
 * @author KevinChen
 * @since 21/2/2021
 */
public class Aop1 {
    // 前置通知
    public void startTransaction() {
        System.out.println("    ====>begin ding... ");
    }

    // 后置通知
    public void commitTransaction() {
        System.out.println("    ====>finish ding... ");
    }

    // 环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("    ====>around begin ding");
        joinPoint.proceed();
        System.out.println("    ====>around finish ding");
    }
}
