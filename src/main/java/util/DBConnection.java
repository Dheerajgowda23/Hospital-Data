package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(

            "jdbc:mysql://mysql-1a26bd6d-dheerajb262-d588.h.aivencloud.com:19029/defaultdb?sslMode=REQUIRED",

            "avnadmin",

            "AVNS_rmy3giD7ynEoHgeN6aT"
        );
    }
}