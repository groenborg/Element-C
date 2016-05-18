/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit;

import handlers.ResponseBuilder;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Simon
 */
@RunWith(Enclosed.class)
public class ReponseBuilderTest {

    @RunWith(Parameterized.class)
    public static class ResponseBuilderParamaterTest {

        private final String fileExtension;
        private final String mimeType;

        public ResponseBuilderParamaterTest(String fileExtension, String mimeType) {
            this.fileExtension = fileExtension;
            this.mimeType = mimeType;
        }

        @Parameters
        public static Collection getParamaters() {
            return Arrays.asList(new Object[][]{
                {"public/heuf/.git/index.html", "text/html"},
                {"public\\held.css", "text/css"},
                {"publi/javascript/app.js", "application/javascript"},
                {"somepath/consfigs/data.json", "application/json"},
                {"nothingtoseehere", "text/plain"},
                {"....", "text/plain"}
            });
        }

        /**
         * Test of getMimeType method, of class ResponseBuilder.
         */
        @Test
        public void getMimeParamaterTest() {
            ResponseBuilder res = new ResponseBuilder();
            String output = res.getMimeType(this.fileExtension);

            assertThat(output, is(mimeType));
        }

    }

    public static class ResponseBuilderFileTest {

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
        public void testFileRetriever() {

        }

    }

}
