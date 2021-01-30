package com.kevin.java.course.conc0301;

/**
 * ThreadA
 *
 * @author KevinChen
 * @since 24/1/21
 */
public class ThreadA extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}
