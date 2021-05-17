package com.example.springkafkademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyReceiver {
    private final String TOPIC = "spring-demo";

    @KafkaListener(topics = TOPIC)
    public void processMessage(String content) {
//        System.out.println("Receiving a Message: " + content);
        log.info("Receiving a Message[{}]:  {}", TOPIC, content);
    }
}
