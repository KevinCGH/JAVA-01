package java0.conc0302.lock;

/**
 * LockMain
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public class LockMain {
    public static void main(String[] args) {
        Count3 count3 = new Count3();
        ThreadA threadA = new ThreadA(count3);
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB(count3);
        threadB.setName("线程B");
        threadB.start();
    }
}
