package com.kevin.java.course.jvm;

/**
 * @author KevinChen
 */
public class Hello {
    public static void main(String[] args) {
        // 基本类型
        int a = 2;
        int b = 1;
        double c = 5.0D;
        boolean flag = true;
        // 四则运算
        int sum = a + b;
        int sub = a - b;
        int mul = a * b;
        int div = 0;
        // if
        if (b != 0 && flag) {
            div = a / b;
        }
        // for
        for (int i = 0; i < 5; i++) {
            c++;
        }
    }
}
