package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpLock implements ThreadExperiment {
    @Override
    public String info() {
        return "Lock";
    }

    final Lock lock = new ReentrantLock();
    final Condition con = lock.newCondition();

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        Fibonacci fib = new Fibonacci();
        new Thread(() -> {
            lock.lock();
            try {
                fib.sum();
                con.signalAll();
            } finally {
                lock.unlock();
            }
        }).start();
        lock.lock();
        try {
            while (fib.getResult() == -1) {
                con.await();
            }
        } finally {
            lock.unlock();
        }
        return fib.getResult();
    }
}
