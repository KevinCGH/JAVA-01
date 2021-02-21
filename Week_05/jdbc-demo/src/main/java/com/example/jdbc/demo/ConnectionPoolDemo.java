package com.example.jdbc.demo;

import com.example.jdbc.suppert.DBSource;
import com.example.jdbc.suppert.PoolMySQLDBSource;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * ConnectionPoolDemo
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Slf4j
public class ConnectionPoolDemo implements Demo {
    @Override
    public void run() {
        try {
            DBSource dbSource = new PoolMySQLDBSource();
            (new CrudDemo()).curd(dbSource);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
