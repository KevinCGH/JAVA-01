package homework.thread;

import java.util.concurrent.ExecutionException;

/**
 * ThreadExperiment
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public interface ThreadExperiment {
    String info();
    int execute() throws ExecutionException, InterruptedException;
}
