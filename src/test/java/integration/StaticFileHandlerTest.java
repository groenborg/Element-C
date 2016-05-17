package integration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import server.CarbonServer;

/**
 *
 * @author Simon
 */
public class StaticFileHandlerTest {

    CarbonServer server;

    public StaticFileHandlerTest() {
    }

    @Before
    public void setUp() throws IOException {
        server = new CarbonServer();
        server.start();
    }

    @After
    public void tearDown() {
        server.stop();
    }

    @Test
    public void staticFileServiceTest() throws MalformedURLException, IOException {
        HttpURLConnection client = (HttpURLConnection) new URL("http://127.0.0.1:3000/").openConnection();
        int response = client.getResponseCode();
        int expectedOKResponse = 200;
        
        assertThat(response, is(expectedOKResponse));
    }

}
