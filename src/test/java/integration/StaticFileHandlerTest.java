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
import org.junit.BeforeClass;
import server.CarbonServer;

/**
 *
 * @author Simon
 */
public class StaticFileHandlerTest {

    private CarbonServer server;
    private String url = "http://127.0.0.1:3000";
    private String rootPath = "testfiles/";
    private String address = "localhost";
    private int port = 3000;

    public StaticFileHandlerTest() {

    }

    @Before
    public void setUp() throws IOException {
        server = new CarbonServer(rootPath, address, port);
        server.start();
    }

    @After
    public void tearDown() {
        server.stop();
    }

    @Test
    public void FileHandlerCode200Test() throws MalformedURLException, IOException {
        HttpURLConnection client = (HttpURLConnection) new URL(url + "/index.html").openConnection();
        int response = client.getResponseCode();
        int expectedOKResponse = 200;

        assertThat(response, is(expectedOKResponse));
    }

    @Test
    public void FileHandlerCode404Test() throws MalformedURLException, IOException {
        HttpURLConnection client = (HttpURLConnection) new URL(url + "/ipas.pascal").openConnection();
        int response = client.getResponseCode();
        int expectedNotFoundCode = 404;

        assertThat(response, is(expectedNotFoundCode));
    }

}
