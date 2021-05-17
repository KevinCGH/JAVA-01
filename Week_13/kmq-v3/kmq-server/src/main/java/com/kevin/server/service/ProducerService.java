package com.kevin.server.service;

import com.kevin.server.core.KmqBroker;
import com.kevin.server.core.KmqMessage;
import com.kevin.server.core.KmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KmqBroker broker;

    public boolean messageEnqueue(String topic, String content) {
        broker.createTopic(topic);
        KmqProducer producer = broker.createProducer();
        return producer.send(topic, new KmqMessage(null, content));
    }
}
