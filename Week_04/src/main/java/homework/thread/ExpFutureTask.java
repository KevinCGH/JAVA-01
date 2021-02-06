package homework.thread;

import homework.common.Fibonacci;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author KevinChen
 * @since 7/2/2021
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExpFutureTask implements ThreadExperiment {
    @Override
    public String info() {
        return "FutureTask";
    }

    @Override
    public int execute() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(() -> new Fibonacci().sum());
        new Thread(task).start();

        return task.get();
    }
}
