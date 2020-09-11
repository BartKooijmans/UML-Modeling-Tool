/*
 * Class that runs the different tests for the project
 */
package finalproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Bart Kooijmans
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    finalproject.ElementGUITest.class, finalproject.ConnectionTest.class, finalproject.ModelControllerTest.class, finalproject.ModelTest.class, finalproject.MainControllerTest.class, finalproject.ElementTest.class, finalproject.ConnectionGUITest.class
})
public class FinalprojectSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}
