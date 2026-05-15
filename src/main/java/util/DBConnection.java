package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        
        // Fallback for local testing if env variables are not set
        if (url == null) {
            url = "jdbc:postgresql://localhost:5432/hospital";
            user = "postgres";
            password = "password";
        }
        
        return DriverManager.getConnection(url, user, password);
    }
}