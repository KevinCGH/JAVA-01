package com.example.sharding.service.OrderService;

import com.example.sharding.entity.Order;
import com.example.sharding.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * OrderService
 *
 * @author KevinChen
 * @since 14/3/2021
 */
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Long add(Order order) {
        Order saved = repository.save(order);
        return saved.getOrderId();
    }

    public Order getById(Long id) {
        return repository.findById(id).get();
    }

    public Boolean update(Order order) {
        repository.save(order);
        return Boolean.TRUE;
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }
}
