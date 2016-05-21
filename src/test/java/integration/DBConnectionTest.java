package integration;

import datasource.IDBConnection;
import datasource.MySQLConnection;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simon
 */
public class DBConnectionTest {

    /**
     * This test uses different urls based on the environment
     *
     *
     */
    private Connection con;
    private IDBConnection retriever;

    // IT's a really bad idea to have credentials here
    // don't ever do it! I will probably get scolded for this
    private String url = "";
    private String username = "";
    private String password = "";

    // The mysql driver has timezone issues
    private String timeZoneFix = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String sslFix = "?useSSL=true";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        boolean ci = false, drone = false;
        try {
            ci = System.getenv("CI").equalsIgnoreCase("true");
            drone = System.getenv("DRONE").equalsIgnoreCase("true");
        } catch (SecurityException | NullPointerException x) {

        }

        if (ci && drone) {
            //CI Build
            url = "jdbc:mysql://127.0.0.1:3306/cidb" + sslFix;
            username = "root";
            password = "";

        } else {
            //local env
            url = "jdbc:mysql://localhost:8889/cidb" + timeZoneFix;
            username = "root";
            password = "root";
        }
        retriever = new MySQLConnection();
        con = retriever.getConnection(url, username, password);
    }

    @After
    public void tearDown() {
        retriever.releaseConnection();
    }

    @Test
    public void testConnectionNotNull() {
        assertNotNull(con);
    }
}
