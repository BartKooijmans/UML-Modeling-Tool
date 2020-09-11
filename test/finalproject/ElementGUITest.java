/*
 * Test class for ElemenGUI class.
 */
package finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bart Kooijmans
 */
public class ElementGUITest
{
    MainController mainTestController;
    
    public ElementGUITest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of ElementGUI class constructor, with MainController with a new empty Model.
     */
    @Test
    public void testElementGUINewModel() 
    {
        mainTestController = new MainController();
        mainTestController.newModel("Class Diagram");
        ElementGUI instance = new ElementGUI(mainTestController);
        assertNotNull(instance);
    }
    
    /**
     * Test of ElementGUI class constructor, with MainController with a loaded Model.
     */
    @Test
    public void testElementGUIExistingModel() throws FileNotFoundException
    {
        File jsonTestLoadFile = new File("C:/Users/Botje/Documents/test.json");
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(jsonTestLoadFile)));
        mainTestController = new MainController();
        mainTestController.loadEModel(fileScanner,"C:/Users/Botje/Documents/");
        ElementGUI instance = new ElementGUI(mainTestController);
        assertNotNull(instance);
    }    
}
