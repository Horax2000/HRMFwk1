package org.HRMFwk.Utils;

import org.HRMFwk.Setup.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    public static Connection getMySqlConnection() throws SQLException {
        String url = Config.DB_URL.getValue();
        String user = Config.DB_USERNAME.getValue();
        String password = Config.DB_PASSWORD.getValue();
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getOracleConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:yourdatabase";
        String user = "username";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getSqlServerConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost;databaseName=yourdatabase";
        String user = "username";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }
}