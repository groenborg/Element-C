package endtoend;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import server.CarbonServer;
import test.Environment;

/**
 *
 * @author Simon
 */
public class IndexPageSelTest {

    private Environment env = new Environment();
    private WebDriver driver;
    private String website = "http://localhost:3000/index.html";

    private static CarbonServer server;

    public IndexPageSelTest() {

    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        server = new CarbonServer("testfiles/", "localhost", 3000);
        server.start();
    }

    @AfterClass
    public static void tearDownClass() {
        server.stop();
    }

    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
        driver.get(website);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testIndexWithSelenium() {
        driver.getCurrentUrl();
        WebElement element = driver.findElement(By.tagName("p"));
        String text = element.getText();

        assertThat(text, containsString("zxcvbnm"));
    }
}
