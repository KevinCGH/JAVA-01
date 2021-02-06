package java0.conc0302.lock;

/**
 * ThreadB
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public class ThreadB extends Thread {
    private Count3 count3;

    public ThreadB(Count3 count3) {
        this.count3 = count3;
    }

    @Override
    public void run() {
        count3.lockMethod();
    }
}
