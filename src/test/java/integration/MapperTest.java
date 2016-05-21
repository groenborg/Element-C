/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import datasource.MySQLConnection;
import datasource.UserMapper;
import java.sql.Connection;
import java.util.ArrayList;
import model.User;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.Credentials;

/**
 *
 * @author Simon
 */
public class MapperTest {

    Connection con;

    public MapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Credentials cred = new Credentials();
        con = MySQLConnection.getConnection(cred.url, cred.username, cred.password);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetUsers() {
        UserMapper m = new UserMapper(con);
        ArrayList<User> result = m.getAllUsers();

        assertThat(result, is(nullValue()));
    }

}
