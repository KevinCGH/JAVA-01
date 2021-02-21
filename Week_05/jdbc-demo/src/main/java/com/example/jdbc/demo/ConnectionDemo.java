package com.example.jdbc.demo;

import com.example.jdbc.suppert.DBSource;
import com.example.jdbc.suppert.MySQLDBSource;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ConnectionDemo
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Slf4j
public class ConnectionDemo implements Demo {
    @Override
    public void run() {
        try {
            DBSource dbSource = new MySQLDBSource();
            Connection conn = dbSource.getConnection();
            if (!conn.isClosed()) {
                log.info("数据库已连接...");
            }
            dbSource.closeConnection(conn);
            if (conn.isClosed()) {
                log.info("数据库已关闭...");
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
