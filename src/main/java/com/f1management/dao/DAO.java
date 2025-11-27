package com.f1management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DAO {
    private static Dotenv dotenv = Dotenv.configure().load();
    public static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/F1_management";
    private static final String USER = dotenv.get("DATABASE_USER");
    private static final String PASSWORD = dotenv.get("DATABASE_PASS");

    public DAO() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connected to F1_management database successfully!");
            } catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }
    }
}