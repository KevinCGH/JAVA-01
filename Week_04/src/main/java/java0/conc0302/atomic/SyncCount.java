package java0.conc0302.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SyncCount
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public class SyncCount {
    private int num = 0;
    private Lock lock = new ReentrantLock(true);

    public int add() {
        lock.lock();
        try {
            return num++;
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        return num;
    }
}
