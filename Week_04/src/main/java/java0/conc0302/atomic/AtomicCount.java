package java0.conc0302.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicCount
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public class AtomicCount {
    private AtomicInteger num = new AtomicInteger();

    public int add() {
        return num.getAndIncrement();
    }

    public int getNum() {
        return num.get();
    }
}
