package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(
            System.getenv("DB_URL"),
            System.getenv("DB_USER"),
            System.getenv("DB_PASSWORD")
        );
    }
}