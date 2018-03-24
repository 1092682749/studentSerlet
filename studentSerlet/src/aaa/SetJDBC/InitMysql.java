package aaa.SetJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitMysql {
    private static Connection connection = null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/framedbc?useUnicode=true&characterEncoding=utf8";
        connection = DriverManager.getConnection(url,"root","root");
        return connection;
    }
}
