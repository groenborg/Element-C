package datasource;

import java.sql.Connection;

/**
 *
 * @author Simon
 */
public interface IDBConnection {

    public Connection getConnection(String url, String username, String password);

    public void releaseConnection();

}
