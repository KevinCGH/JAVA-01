package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.*;

/**
 * Experiment01
 *
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpCountDownLatch implements ThreadExperiment {
    @Override
    public String info() {
        return "CountDownLatch";
    }

    final CountDownLatch count = new CountDownLatch(1);

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        Fibonacci fib = new Fibonacci();
        new Thread(() -> {
            fib.sum();
            count.countDown();
        }).start();
        count.await();
        return fib.getResult();
    }
}
