package com.kevin.java.course.nio02.gateway.router;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * WeightHttpEndpointRouter
 *
 * @author KevinChen
 * @since 31/1/2021
 */
public class WeightRandomHttpEndpointRouter implements HttpEndpointRouter {
    /**
     * for test
     */
    private Map<String, Integer> serverMap = new HashMap<String, Integer>() {{
        put("http://localhost:8801", 1);
        put("http://localhost:8802", 5);
    }};

    @Override
    public String route(List<String> endpoints) {
        int size = endpoints.size();
        int totalWeight = 0;
        for (String url : endpoints) {
            int w = serverMap.get(url);
            totalWeight += w;
        }
        Random random = new Random(System.currentTimeMillis());
        if (totalWeight > 0) {
            int offset = random.nextInt(totalWeight);
            for (int i = 0; i < size; i++) {
                offset -= serverMap.get(endpoints.get(i));
                if (offset < 0) {
                    return endpoints.get(i);
                }
            }
        }
        return endpoints.get(random.nextInt(size));
    }
}
