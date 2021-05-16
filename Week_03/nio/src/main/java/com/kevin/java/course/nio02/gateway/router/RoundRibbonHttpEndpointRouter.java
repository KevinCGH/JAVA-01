package com.kevin.java.course.nio02.gateway.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * RoundRibbonHttpEndpointRouter
 *
 * @author KevinChen
 * @since 31/1/2021
 */
public class RoundRibbonHttpEndpointRouter implements HttpEndpointRouter {
    private static final Logger logger = LoggerFactory.getLogger(RoundRibbonHttpEndpointRouter.class);

    private static RoundRibbonHttpEndpointRouter instance;

    private AtomicInteger nextServerCyclicCounter;

    private RoundRibbonHttpEndpointRouter() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    public static RoundRibbonHttpEndpointRouter getInstance() {
        if (instance == null) {
            synchronized (RoundRibbonHttpEndpointRouter.class) {
                if (instance == null) {
                    instance = new RoundRibbonHttpEndpointRouter();
                }
            }
        }
        return instance;
    }

    @Override
    public String route(List<String> endpoints) {
        int size = endpoints.size();
        if (size == 0) {
            logger.warn("No servers available.");
            return null;
        }
        int nextServerIndex = incrementAndGetModulo(size);
        return endpoints.get(nextServerIndex);
    }

    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = nextServerCyclicCounter.get();
            next = (current + 1) % modulo;
        } while (!nextServerCyclicCounter.compareAndSet(current, next));
        return next;
    }
}
