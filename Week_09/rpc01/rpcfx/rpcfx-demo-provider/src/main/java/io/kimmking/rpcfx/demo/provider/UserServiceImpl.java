package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.demo.api.User;
import io.kimmking.rpcfx.demo.api.UserService;

/**
 * UserServiceImpl
 *
 * @author KevinChen
 * @since 22/3/2021
 */
public class UserServiceImpl implements UserService {
    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
