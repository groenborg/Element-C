package integration;

import datasource.MySQLConnection;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.Environment;

/**
 *
 * @author Simon
 */
public class DBConnectionTest {

    /**
     * This test uses different urls based on the environment
     */
    private Connection con;

    private String url = "";
    private String username = "";
    private String password = "";

    // The mysql driver has timezone issues
    private String sslFix = "?useSSL=false";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Environment c = new Environment();
        url = c.url;
        username = c.username;
        password = c.password;
        url += c.ci == true && c.drone ? sslFix : "";
    }

    @After
    public void tearDown() {
        MySQLConnection.releaseConnection();
    }

    @Test
    public void testConnectionNotNull() {
        con = MySQLConnection.getNewConnection(url, username, password);
        assertNotNull(con);
    }
}
