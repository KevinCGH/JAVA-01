package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.demo.api.Order;
import io.kimmking.rpcfx.demo.api.OrderService;

/**
 * OrderServiceImpl
 *
 * @author KevinChen
 * @since 22/3/2021
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
