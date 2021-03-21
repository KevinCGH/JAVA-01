package com.example.hmily.dubbo.system.a.service.impl;

import com.example.hmily.dubbo.system.a.dto.AccountADTO;
import com.example.hmily.dubbo.system.a.service.AccountService;
import com.example.hmily.dubbo.system.a.service.PayService;
import com.example.hmily.dubbo.system.b.api.AccountBService;
import com.example.hmily.dubbo.system.b.dto.AccountBDTO;
import lombok.AllArgsConstructor;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * PayServiceImpl
 *
 * @author KevinChen
 * @since 20/3/2021
 */
@Service("payService")
@AllArgsConstructor
public class PayServiceImpl implements PayService {
    private final AccountService accountService;
    private final AccountBService bService;

    @Override
    @HmilyTCC(confirmMethod = "confirmPay", cancelMethod = "cancelPay")
    public void payToB(String fromId, String toId, BigDecimal amount) {
        AccountADTO aDto = buildAccountADTO(fromId, amount);
        AccountBDTO bDto = buildAccountBDTO(toId, amount);
        accountService.decrease(aDto);
        bService.increase(bDto);
    }

    @Override
    @HmilyTCC(confirmMethod = "confirmPay", cancelMethod = "cancelPay")
    public void payToBWithException(String fromId, String toId, BigDecimal amount) {
        AccountADTO aDto = buildAccountADTO(fromId, amount);
        AccountBDTO bDto = buildAccountBDTO(toId, amount);
        accountService.decrease(aDto);
        bService.mockWithIncreaseException(bDto);
    }

    public void confirmPay(String fromId, String toId, BigDecimal amount) {
        accountService.confirm(buildAccountADTO(fromId, amount));
    }

    public void cancelPay(String fromId, String toId, BigDecimal amount) {
        accountService.cancel(buildAccountADTO(fromId, amount));
    }

    private AccountADTO buildAccountADTO(String fromId, BigDecimal amount) {
        AccountADTO dto = new AccountADTO();
        dto.setUserId(fromId);
        dto.setAmount(amount);
        return dto;
    }

    private AccountBDTO buildAccountBDTO(String toId, BigDecimal amount) {
        AccountBDTO dto = new AccountBDTO();
        dto.setUserId(toId);
        dto.setAmount(amount);
        return dto;
    }
}
