package com.example.hmily.dubbo.system.b.mapper;

import com.example.hmily.dubbo.system.b.dto.AccountBDTO;
import com.example.hmily.dubbo.system.b.entity.AccountB;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * The interface AccountB mapper
 *
 * @author KevinChen
 * @since 20/3/2021
 */
public interface AccountBMapper {
    @Select("select * from account_b")
    List<AccountB> list();

    /**
     * update amount
     *
     * @param accountBDTO
     * @return
     */
    @Update("update account_b set balance = balance + #{amount}," +
            " freeze_amount = freeze_amount - #{amount}, update_time = now()" +
            " where user_id = #{userId} and balance > 0")
    int increase(AccountBDTO accountBDTO);

    /**
     * Confirm
     *
     * @param accountBDTO
     * @return
     */
    @Update("update account_b set " +
            " freeze_amount = freeze_amount + #{amount}" +
            " where user_id = #{userId} and balance > 0")
    int confirm(AccountBDTO accountBDTO);

    /**
     * Cancel
     *
     * @param accountBDTO
     * @return
     */
    @Update("update account_b set balance = balance - #{amount}," +
            " freeze_amount = freeze_amount + #{amount} " +
            " where user_id = #{userId} and balance >0 and freeze_amount <> 0")
    int cancel(AccountBDTO accountBDTO);
}
