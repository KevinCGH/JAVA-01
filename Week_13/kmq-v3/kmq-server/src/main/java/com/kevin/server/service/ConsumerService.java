package com.kevin.server.service;

import com.kevin.server.core.KmqBroker;
import com.kevin.server.core.KmqConsumer;
import com.kevin.server.core.KmqMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    private KmqBroker broker;

    public String messageDequeue(String topic, Integer offset) {
        KmqConsumer consumer = broker.createConsumer();
        consumer.subscribe(topic);
        consumer.setOffset(offset);
        KmqMessage<String> message = consumer.poll();
        return message.getBody();
    }
}
