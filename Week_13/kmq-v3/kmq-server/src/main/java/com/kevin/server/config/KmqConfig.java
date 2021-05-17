package com.kevin.server.config;

import com.kevin.server.core.KmqBroker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KmqConfig {

    @Bean
    public KmqBroker getBroker() {
        KmqBroker broker = new KmqBroker();
        return broker;
    }
}
