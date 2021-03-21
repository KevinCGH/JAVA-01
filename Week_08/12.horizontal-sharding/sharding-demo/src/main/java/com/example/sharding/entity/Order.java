package com.example.sharding.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Order
 *
 * @author KevinChen
 * @since 14/3/2021
 */
@Data
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Integer userId;
    private String status;
}
