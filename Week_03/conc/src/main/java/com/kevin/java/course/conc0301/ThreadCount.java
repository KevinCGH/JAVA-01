package com.kevin.java.course.conc0301;

public class ThreadCount {
    public static void main(String[] args) {
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}
