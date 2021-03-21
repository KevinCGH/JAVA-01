package com.example.hmily.dubbo.system.a.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * AccountADTO
 *
 * @author KevinChen
 * @since 20/3/2021
 */
public class AccountADTO implements Serializable {
    private static final long serialVersionUID = 7223470850578998427L;
    private String userId;
    private BigDecimal amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
