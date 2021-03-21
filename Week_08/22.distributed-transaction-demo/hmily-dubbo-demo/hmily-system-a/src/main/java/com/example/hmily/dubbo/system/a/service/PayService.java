package com.example.hmily.dubbo.system.a.service;

import java.math.BigDecimal;

/**
 * PayService
 *
 * @author KevinChen
 * @since 20/3/2021
 */
public interface PayService {
    void payToB(String fromId, String toId, BigDecimal amount);

    void payToBWithException(String fromUserId, String toUserId, BigDecimal amount);
}
