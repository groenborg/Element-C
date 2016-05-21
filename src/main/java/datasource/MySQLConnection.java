package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Simon
 */
public class MySQLConnection implements IDBConnection {

    public final static String MYSQL_DIALECT = "com.mysql.jdbc.Driver";
    private Connection dbConnection;

    @Override
    public Connection getConnection(String url, String username, String password) {
        try {
            Class.forName(MYSQL_DIALECT);
            
            dbConnection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return dbConnection;
    }

    @Override
    public void releaseConnection() {
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("No connection to close");
        }
    }

}
