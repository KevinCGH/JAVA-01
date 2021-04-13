package com.example.hmily.dubbo.system.a.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * AccountA
 *
 * @author KevinChen
 * @since 20/3/2021
 */
public class AccountA implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer id;
    private String userId;
    private BigDecimal balance;
    private BigDecimal freezeAmount;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}