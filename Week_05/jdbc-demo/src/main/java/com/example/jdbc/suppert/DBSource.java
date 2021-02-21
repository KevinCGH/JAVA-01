package com.example.jdbc.suppert;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBSource {
    public Connection getConnection() throws SQLException, ClassNotFoundException;

    public void closeConnection(Connection conn) throws SQLException;
}
