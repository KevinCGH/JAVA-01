package com.example.hmily.dubbo.system.a.mapper;

import com.example.hmily.dubbo.system.a.entity.AccountA;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.hmily.dubbo.system.a.dto.AccountADTO;

import java.util.List;

/**
 * The interface AccountA mapper
 *
 * @author KevinChen
 * @since 20/3/2021
 */
public interface AccountAMapper {
    @Select("select * from account_a")
    List<AccountA> list();

    /**
     * update amount
     *
     * @param accountADTO
     * @return
     */
    @Update("update account_a set balance = balance - #{amount}," +
            " freeze_amount = freeze_amount + #{amount}, update_time = now()" +
            " where user_id = #{userId} and balance > 0")
    int decrease(AccountADTO accountADTO);

    /**
     * Confirm
     *
     * @param accountADTO
     * @return
     */
    @Update("update account_a set " +
            " freeze_amount = freeze_amount - #{amount}" +
            " where user_id = #{userId} and balance > 0")
    int confirm(AccountADTO accountADTO);

    /**
     * Cancel
     *
     * @param accountADTO
     * @return
     */
    @Update("update account_a set balance = balance + #{amount}," +
            " freeze_amount = freeze_amount - #{amount} " +
            " where user_id = #{userId} and balance >0")
    int cancel(AccountADTO accountADTO);

    @Select("select * from account_a " +
            " where user_id = #{userId}")
    AccountA findByUserId(String userId);
}
