package com.kevin.kmq.core;

public class KmqConsumer<T> {
    private final KmqBroker broker;

    private Kmq kmq;

    private int offset;

    public KmqConsumer(KmqBroker broker) {
        this(broker, 0);
    }

    public KmqConsumer(KmqBroker broker, int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException();
        }
        this.broker = broker;
        this.offset = offset;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) {
            throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        }
    }

    public KmqMessage<T> poll() {
        KmqMessage result;
        if ((result = kmq.poll(offset)) != null) {
            offset++;
        }
        return result;
    }
}
