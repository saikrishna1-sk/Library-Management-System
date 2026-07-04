package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String user = "root";
    private static final String pass = "root";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successfull");
        } catch (SQLException s) {
            System.out.println("Database Connection failed");
            s.printStackTrace();
        } catch (Exception e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        }
        return conn;
    }
}
