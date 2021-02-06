package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpJoin implements ThreadExperiment {
    @Override
    public String info() {
        return "Join";
    }

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        Fibonacci fib = new Fibonacci();
        Thread thread = new Thread(() -> fib.sum());
        thread.start();
        thread.join();
        return fib.getResult();
    }
}
