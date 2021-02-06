package homework.thread;

import homework.common.Fibonacci;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpCompletableFuture1 implements ThreadExperiment {
    @Override
    public String info() {
        return "CompletableFuture1";
    }


    @Override
    public int execute() throws ExecutionException, InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> list.add(new Fibonacci().sum()));
        future.get();

        return list.get(0);
    }
}
