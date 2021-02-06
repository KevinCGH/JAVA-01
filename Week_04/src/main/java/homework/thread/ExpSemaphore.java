package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Experiment01
 *
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpSemaphore implements ThreadExperiment {
    @Override
    public String info() {
        return "Semaphore";
    }

    final Semaphore semaphore = new Semaphore(1);

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        Fibonacci fib = new Fibonacci();
        Thread thread = new Thread(() -> {
            fib.sum();
            semaphore.release();
        });
        try {
            semaphore.acquire();
            thread.start();
            semaphore.acquire();

        } finally {
            semaphore.release();
        }
        return fib.getResult();
    }
}
