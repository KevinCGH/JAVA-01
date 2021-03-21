package com.example.hmily.dubbo.system.b.api;

import com.example.hmily.dubbo.system.b.entity.AccountB;
import org.dromara.hmily.annotation.Hmily;
import com.example.hmily.dubbo.system.b.dto.AccountBDTO;
import org.dromara.hmily.annotation.HmilyTCC;

import java.util.List;

/**
 * @author KevinChen
 */
public interface AccountBService {
    /**
     * 支付
     *
     * @param accountBDTO
     * @return
     */
    @Hmily
    boolean increase(AccountBDTO accountBDTO);

    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    boolean mockWithIncreaseException(AccountBDTO accountBDTO);

    List<AccountB> list();
}
