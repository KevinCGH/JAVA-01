package com.kevin.java.course.nio02.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * RandomHttpEndpointRouter
 *
 * @author KevinChen
 * @since 30/1/2021
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
