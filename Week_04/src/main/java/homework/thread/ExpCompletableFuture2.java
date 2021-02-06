package homework.thread;

import homework.common.Fibonacci;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpCompletableFuture2 implements ThreadExperiment {
    @Override
    public String info() {
        return "CompletableFuture2";
    }


    @Override
    public int execute() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> new Fibonacci().sum());
        return future.get();
    }
}
