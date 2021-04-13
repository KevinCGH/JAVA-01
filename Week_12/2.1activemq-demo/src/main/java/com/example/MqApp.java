package com.example;

public class MqApp {
    public static void main(String[] args) {
        String name = "TEST";
        // Queue
        new Thread(new MyProducer(name, true)).start();
        new Thread(new MyConsumer(name, true)).start();

        // Topic
        new Thread(new MyProducer(name, false)).start();
        new Thread(new MyConsumer(name, false)).start();
    }
}
