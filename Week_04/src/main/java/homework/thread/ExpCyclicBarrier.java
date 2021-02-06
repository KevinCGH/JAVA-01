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
public class ExpCyclicBarrier implements ThreadExperiment {
    @Override
    public String info() {
        return "CyclicBarrier";
    }

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        Fibonacci fib = new Fibonacci();
        final CyclicBarrier barrier = new CyclicBarrier(1, () -> {
        });
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> {
            int sum = fib.sum();
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            return sum;
        });
        int result = future.get();
        executorService.shutdown();
        return result;
    }
}
