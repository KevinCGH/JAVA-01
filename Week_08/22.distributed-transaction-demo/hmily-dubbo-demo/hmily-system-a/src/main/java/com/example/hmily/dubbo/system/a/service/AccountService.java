package com.example.hmily.dubbo.system.a.service;

import com.example.hmily.dubbo.system.a.dto.AccountADTO;
import com.example.hmily.dubbo.system.a.entity.AccountA;
import com.example.hmily.dubbo.system.b.entity.AccountB;

import java.util.List;

/**
 * AccountService
 *
 * @author KevinChen
 * @since 20/3/2021
 */
public interface AccountService {
    List<AccountA> list();

    List<AccountB> listB();

    boolean decrease(AccountADTO accountADTO);

    boolean confirm(AccountADTO accountADTO);

    boolean cancel(AccountADTO accountADTO);

    AccountA findByUserId(String userId);
}
