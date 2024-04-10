package wishlist.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection con;

    private ConnectionManager(){

    }


    public static Connection getConnection(String db_url, String uid, String pwd) {

        if (con != null) return con;

        try {
            con = DriverManager.getConnection(db_url, uid, pwd);

        } catch (SQLException e) {
            System.out.println("Couldn't connect to database.");
            e.printStackTrace();
        }
        return con;
    }

}
