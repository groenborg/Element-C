package integration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import server.CarbonServer;

/**
 *
 * @author Simon
 */
public class StaticFileHandlerTest {
    
    public StaticFileHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws MalformedURLException, IOException {
        CarbonServer server = new CarbonServer();
        server.start();
        
        HttpURLConnection client = (HttpURLConnection) new URL("http://127.0.0.1:3000/").openConnection();
        
        server.stop();
        
        int response = client.getResponseCode();
        int expectedOKResponse = 200;
        assertThat(response, is(expectedOKResponse));
    }
    
}
