package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Simon
 */
public class MySQLConnection {

    public final static String MYSQL_DIALECT = "com.mysql.cj.jdbc.Driver";
    private static Connection dbConnection;

    private MySQLConnection() {

    }

    public static Connection getConnection(String url, String username, String password) {

        if (dbConnection == null) {
            try {
                dbConnection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }
        return dbConnection;
    }

    public static void releaseConnection() {
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("No connection to close");
        }
    }

}
