package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Simon
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    endtoend.IndexPageSelTest.class,
    integration.FileHandlerTest.class,
    integration.DBConnectionTest.class,
    integration.MapperTest.class,
    unit.ReponseBuilderTest.class

})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
