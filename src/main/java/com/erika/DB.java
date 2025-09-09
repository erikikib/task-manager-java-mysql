package com.erika;
import java.sql.*;

public class DB {
    public static Connection connect() throws Exception {
        String url  = "jdbc:mysql://localhost:3306/taskdb";
        String user = "root";       // <-- change if needed
        String pass = "password";   // <-- change if needed
        return DriverManager.getConnection(url, user, pass);
    }
}
