package homework.common;

/**
 * Fibonacci
 *
 * @author KevinChen
 * @since 7/2/2021
 */
public class Fibonacci {
    private volatile Integer result = -1;

    public Integer sum() {
        result = fibo(36);
        return result;
    }

    public Integer fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    public Integer getResult() {
        return result;
    }
}
