package com.capsys.db;

import java.sql.*;

public class DbConnection {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/analysis";
    static final String USER = "analysis";
    static final String PASS = "qwerty78";

    static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
