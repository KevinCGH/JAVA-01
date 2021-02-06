package java0.conc0302.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * ExecutorServiceDemo
 *
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);
        try {
            String str = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
                }
            }).get();
            System.out.println("str=" + str);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
