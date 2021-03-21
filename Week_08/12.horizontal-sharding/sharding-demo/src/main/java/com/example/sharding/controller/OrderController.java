package com.example.sharding.controller;

import com.example.sharding.entity.Order;
import com.example.sharding.service.OrderService.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * OrderController
 *
 * @author KevinChen
 * @since 14/3/2021
 */
@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity getAllOrder() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity addOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.add(order));
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.delete(id));
    }
}
