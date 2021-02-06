package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.ExecutionException;

/**
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpSynchronized implements ThreadExperiment {
    @Override
    public String info() {
        return "Synchronized";
    }

    public static Object u = new Object();

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        Fibonacci fib = new Fibonacci();
        new Thread(() -> {
            synchronized (u) {
                fib.sum();
                u.notifyAll();
            }
        }).start();
        synchronized (u) {
            while (fib.getResult() == -1) {
                u.wait();
            }
        }

        return fib.getResult();
    }
}
