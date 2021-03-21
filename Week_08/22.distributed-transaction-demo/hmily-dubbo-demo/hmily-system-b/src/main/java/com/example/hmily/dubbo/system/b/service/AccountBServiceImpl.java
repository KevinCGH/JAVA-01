package com.example.hmily.dubbo.system.b.service;

import com.example.hmily.dubbo.system.b.api.AccountBService;
import com.example.hmily.dubbo.system.b.dto.AccountBDTO;
import com.example.hmily.dubbo.system.b.entity.AccountB;
import com.example.hmily.dubbo.system.b.mapper.AccountBMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * AccountBServiceImpl
 *
 * @author KevinChen
 * @since 21/3/2021
 */
@Slf4j
@Service("accountBService")
@AllArgsConstructor
public class AccountBServiceImpl implements AccountBService {

    private final AccountBMapper accountBMapper;


    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean increase(AccountBDTO accountBDTO) {
        return accountBMapper.increase(accountBDTO) > 0;
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean mockWithIncreaseException(AccountBDTO accountBDTO){
        throw new HmilyRuntimeException("更新异常～");
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(AccountBDTO accountBDTO) {
        log.info("===============dubbo tcc 执行确认收款接口=================");
        accountBMapper.confirm(accountBDTO);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(AccountBDTO accountBDTO) {
        log.info("===============dubbo tcc 执行取消收款接口=================");
        accountBMapper.cancel(accountBDTO);
        return Boolean.TRUE;
    }

    @Override
    public List<AccountB> list() {
        return accountBMapper.list();
    }
}
