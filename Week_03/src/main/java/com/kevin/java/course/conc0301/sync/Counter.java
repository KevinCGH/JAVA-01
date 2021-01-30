package com.kevin.java.course.conc0301.sync;

/**
 * Counter
 *
 * @author KevinChen
 * @since 24/1/21
 */
public class Counter {
    public final static int A = 20;
    public static int B = 10;

    private volatile int sum = 0;

    private void incr() {
        sum = sum + 1;
    }

    private synchronized void syncIncr() {
        sum = sum + 1;
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        int loop = 100000;

        // test single thread
        Counter counter = new Counter();
        for (int i = 0; i < loop; i++) {
            counter.incr();
        }
        System.out.println("Single thread: " + counter.getSum());

        // test multiple threads
        final Counter counter2 = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < loop / 2; i++) {
                counter2.incr();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < loop / 2; i++) {
                counter2.incr();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("Multiple threads: " + counter2.getSum());

        // test multiple threads invoke sync method
        final Counter counter3 = new Counter();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < loop / 2; i++) {
                counter3.syncIncr();
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < loop / 2; i++) {
                counter3.syncIncr();
            }
        });
        t3.start();
        t4.start();
        Thread.sleep(1000);
        System.out.println("Multiple threads with sync: " + counter3.getSum());
    }
}
