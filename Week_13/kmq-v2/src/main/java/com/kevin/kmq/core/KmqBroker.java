package com.kevin.kmq.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Broker + Connection
 */
public class KmqBroker {

    public static final int CAPACITY = 10000;

    private final Map<String, Kmq> kmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name) {
        kmqMap.putIfAbsent(name, new Kmq(name, CAPACITY));
    }

    public Kmq findKmq(String topic) {
        return this.kmqMap.get(topic);
    }

    public KmqProducer createProducer() {
        return new KmqProducer(this);
    }

    public KmqConsumer createConsumer() {
        return new KmqConsumer(this);
    }
}
