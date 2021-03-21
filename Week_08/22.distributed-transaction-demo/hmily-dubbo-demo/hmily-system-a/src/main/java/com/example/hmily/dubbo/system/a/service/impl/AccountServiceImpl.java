package com.example.hmily.dubbo.system.a.service.impl;

import com.example.hmily.dubbo.system.a.dto.AccountADTO;
import com.example.hmily.dubbo.system.a.entity.AccountA;
import com.example.hmily.dubbo.system.a.mapper.AccountAMapper;
import com.example.hmily.dubbo.system.a.service.AccountService;
import com.example.hmily.dubbo.system.b.api.AccountBService;
import com.example.hmily.dubbo.system.b.entity.AccountB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author KevinChen
 * @since 20/3/2021
 */
@Slf4j
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private final AccountAMapper accountAMapper;
    private final AccountBService accountBService;

    @Autowired(required = false)
    public AccountServiceImpl(AccountAMapper accountAMapper, AccountBService accountBService) {
        this.accountAMapper = accountAMapper;
        this.accountBService = accountBService;
    }

    @Override
    public List<AccountA> list() {
        return accountAMapper.list();
    }

    @Override
    public List<AccountB> listB() {
        return accountBService.list();
    }

    @Override
    public boolean decrease(AccountADTO accountADTO) {
        return accountAMapper.decrease(accountADTO) > 0;
    }

    @Override
    public boolean confirm(AccountADTO accountADTO) {
        log.info("===============dubbo tcc 执行确认付款接口=================");
        accountAMapper.confirm(accountADTO);
        return Boolean.TRUE;
    }

    @Override
    public boolean cancel(AccountADTO accountADTO) {
        log.info("===============dubbo tcc 执行确认付款接口=================");
        accountAMapper.cancel(accountADTO);
        return Boolean.TRUE;
    }

    @Override
    public AccountA findByUserId(String userId) {
        return accountAMapper.findByUserId(userId);
    }


}
