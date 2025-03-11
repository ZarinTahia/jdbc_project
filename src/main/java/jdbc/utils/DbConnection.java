package main.java.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zarin.hossain
 * @since 1/4/22
 */
public class DbConnection {

    private static Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3306/Training";
        String uname = "root";
        String password = "mypassword";
        //Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, uname, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
       // try {
            //if (connection != null) {
               // connection.close();
            //}
       // } catch (Exception e) {
           // System.out.println(e);
        //}
    }

    public static Connection getConnection() {
        return connection;
    }
}