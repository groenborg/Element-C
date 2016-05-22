package integration;

import datasource.MySQLConnection;
import datasource.UserMapper;
import java.sql.Connection;
import java.util.ArrayList;
import model.User;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.Credentials;
import test.Fixture;

/**
 *
 * @author Simon
 */
public class MapperTest {

    private Connection con;
    private Fixture fixture;

    public MapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        Credentials cred = new Credentials();
        con = MySQLConnection.getNewConnection(cred.url, cred.username, cred.password);
        fixture = new Fixture(con);
        fixture.runScript();
    }

    @After
    public void tearDown() {
        MySQLConnection.releaseConnection();
    }

    @Test
    public void testGetUsers() {
        UserMapper m = new UserMapper(con);
        ArrayList<User> result = m.getAllUsers();

        assertThat(result.size(), greaterThan(2));
    }

}
