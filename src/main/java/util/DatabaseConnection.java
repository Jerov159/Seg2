package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://bc2hky8dpornvthdni1y-mysql.services.clever-cloud.com:3306/bc2hky8dpornvthdni1y";
    private static final String USER = "upgfp6ned3m77ha4";
    private static final String PASSWORD = "TdAsLKdnXx0XEHNwKFCB";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
