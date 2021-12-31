package com.bilgeadam.jdbc;

import java.sql.*;

public class Connector {
    private static final String CONNECTION = "jdbc:postgresql://localhost:5432/bilgeadam";
    private static final String USER = "jdbc";
    private static final String PASSWORD = ".";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION,USER,PASSWORD);
    }
}
