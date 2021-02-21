package com.example.jdbc.suppert;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * H2DBSource
 *
 * @author KevinChen
 * @since 21/2/2021
 */
public class PoolMySQLDBSource implements DBSource {
    private HikariPool pool;

    public PoolMySQLDBSource() throws IOException, ClassNotFoundException {
        this("jdbc-pool.properties");
    }

    public PoolMySQLDBSource(String configFile) throws IOException, ClassNotFoundException {
        HikariConfig cfg = new HikariConfig(new ClassPathResource(configFile).getFile().getPath());
        pool = new HikariPool(cfg);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
