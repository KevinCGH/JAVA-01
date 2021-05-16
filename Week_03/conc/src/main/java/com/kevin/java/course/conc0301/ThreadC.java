package com.kevin.java.course.conc0301;

import java.util.concurrent.Callable;

/**
 * ThreadC
 *
 * @author KevinChen
 * @since 24/1/21
 */
public class ThreadC implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程C");
        return "线程C";
    }
}
