package com.kevin.server.core;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Kmq {
    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = Collections.synchronizedList(new ArrayList<>(capacity));
        this.putIndex = new AtomicInteger(0);
    }

    private String topic;

    private int capacity;

    private AtomicInteger putIndex;

    private List<KmqMessage> queue;

    public boolean send(KmqMessage message) {
        boolean res = queue.add(message);
        if (res) {
            putIndex.incrementAndGet();
        }
        return res;
    }


    @SneakyThrows
    public KmqMessage poll(int offset) {
        if (offset >= putIndex.get()) {
            return null;
        }
        return queue.get(offset);
    }
}
