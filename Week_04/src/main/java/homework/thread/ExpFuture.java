package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Experiment01
 *
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpFuture implements ThreadExperiment{
    @Override
    public String info() {
        return "Future";
    }

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        ExecutorService executorService  = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> new Fibonacci().sum());
        executorService.shutdown();
        return future.get();
    }
}
