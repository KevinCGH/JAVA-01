package com.kevin.server.core;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KmqConsumer<T> {
    private final KmqBroker broker;

    private Kmq kmq;

    @Setter
    @Getter
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
        if ((result = poll(offset)) != null) {
            offset++;
        }
        return result;
    }

    public KmqMessage<T> poll(int offset) {
        log.debug("Message received from Topic:{}", offset);
        return kmq.poll(offset);
    }
}
