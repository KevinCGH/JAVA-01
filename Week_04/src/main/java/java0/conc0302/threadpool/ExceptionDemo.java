package java0.conc0302.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExceptionDemo
 *
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExceptionDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Double> future = executorService.submit(() -> {
            throw new RuntimeException("executorService.submit()");
        });
        try {
            double b = future.get();
            System.out.println(b);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("catch submit");
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("Main Thread End");
    }
}
