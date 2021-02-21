package com.example.jdbc.suppert;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * H2DBSource
 *
 * @author KevinChen
 * @since 21/2/2021
 */
public class MySQLDBSource implements DBSource {
    private Properties props;
    private String url;
    private String user;
    private String passwd;

    public MySQLDBSource() throws IOException, ClassNotFoundException {
        this("jdbc-h2.properties");
    }

    public MySQLDBSource(String configFile) throws IOException, ClassNotFoundException {
        props = new Properties();
        props.load(new FileInputStream(new ClassPathResource(configFile).getFile().getPath()));

        url = props.getProperty("mydb.url");
        user = props.getProperty("mydb.user");
        passwd = props.getProperty("mydb.password");

        Class.forName(props.getProperty("mydb.driver-class-name"));
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, passwd);
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
