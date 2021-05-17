package com.example.springkafkademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    private final String TOPIC = "spring-demo";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String content = "this is a spring boot kafka demo.";
        kafkaTemplate.send(TOPIC, content);
        log.info("Sending Message[{}]: {}", TOPIC, content);
    }
}
