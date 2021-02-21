package com.example.jdbc.demo;

import com.example.jdbc.suppert.DBSource;
import com.example.jdbc.suppert.MySQLDBSource;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.*;

/**
 * CrudDemo
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Slf4j
public class CrudDemo implements Demo {
    @Override
    public void run() {
        try {
            curd(new MySQLDBSource());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void curd(DBSource dbSource) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dbSource.getConnection();

            // create
            stmt = conn.prepareStatement("INSERT INTO student VALUES(?,?,?)");
            stmt.setLong(1, 10003);
            stmt.setString(2, "Lili");
            stmt.setInt(3, 20);

            stmt.execute();
            stmt.clearParameters();

            // update
            stmt = conn.prepareStatement("UPDATE STUDENT SET name=? WHERE id=?");
            stmt.setString(1, "Tom2");
            stmt.setLong(2, 10001);

            stmt.executeUpdate();
            stmt.clearParameters();

            // read
            ResultSet result = stmt.executeQuery("SELECT * FROM student");
            while (result.next()) {
                log.info("Student[id={}, name={}, age={}]",
                        result.getLong(1),
                        result.getString(2),
                        result.getInt(3));
            }

            // delete
            stmt = conn.prepareStatement("DELETE FROM student WHERE id=?");
            stmt.setLong(1, 10003);

            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    dbSource.closeConnection(conn);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

}
