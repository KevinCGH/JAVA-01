package com.example.hmily.dubbo.system.a.controller;

import com.example.hmily.dubbo.system.a.service.AccountService;
import com.example.hmily.dubbo.system.a.service.PayService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * AccountController
 *
 * @author KevinChen
 * @since 20/3/2021
 */
@RestController
@RequestMapping("/a/account")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private AccountService accountService;
    private PayService payService;

    @GetMapping("/list")
    public List getAll() {
        return accountService.list();
    }

    @GetMapping("/list/b")
    public List getAllB() {
        return accountService.listB();
    }

    @PostMapping("/{fromUserId}/pay/{toUserId}")
    public String accountPay(@RequestParam("amount") BigDecimal amount,
                             @PathVariable("fromUserId") String fromUserId,
                             @PathVariable("toUserId") String toUserId) {
        log.info("用户[{}] 向 用户:[{}] 支付 {}", fromUserId, toUserId, amount);
        final long start = System.currentTimeMillis();
        payService.payToB(fromUserId, toUserId, amount);
        log.info("消耗时间为：" + (System.currentTimeMillis() - start));
        return "success";
    }

    @PostMapping("/{fromUserId}/payWithTryException/{toUserId}")
    public String accountPayWithTryException(@RequestParam("amount") BigDecimal amount,
                             @PathVariable("fromUserId") String fromUserId,
                             @PathVariable("toUserId") String toUserId) {
        log.info("用户[{}] 向 用户:[{}] 支付 {} ==> 模拟失败", fromUserId, toUserId, amount);
        final long start = System.currentTimeMillis();
        payService.payToBWithException(fromUserId, toUserId, amount);
        log.info("消耗时间为：" + (System.currentTimeMillis() - start));
        return "failed";
    }
}
