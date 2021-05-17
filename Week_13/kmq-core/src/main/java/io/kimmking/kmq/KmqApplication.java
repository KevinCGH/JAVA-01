package io.kimmking.kmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KmqApplication {
    public static void main(String[] args) {
        System.out.println("Starting!");
        SpringApplication.run(KmqApplication.class, args);
    }
}
