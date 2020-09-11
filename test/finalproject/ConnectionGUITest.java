/*
 * Test class for ConnectionGUI class
 */
package finalproject;

import java.io.*;
import java.util.*;
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
public class ConnectionGUITest
{    
    ConnectionGUI cGUINewConnection;
    ConnectionGUI cGUIExistingConnection;
    Element element1;
    MainController mainTestController;
    
    public ConnectionGUITest()
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
    public void setUp() throws FileNotFoundException
    {
        
        mainTestController = new MainController();
        File jsonTestLoadFile = new File("C:/Users/Botje/Documents/test.json");
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(jsonTestLoadFile)));
        mainTestController.loadEModel(fileScanner,"C:/Users/Botje/Documents/");
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of ConnectionGUI class constructor, with Element and MainController, for a new connection to an element.
     */
    @Test
    public void testCreationGUINewConnection()
    {
        cGUINewConnection = new ConnectionGUI(mainTestController.getModel().getElements().get(0), mainTestController);        
        assertNotNull(cGUINewConnection);              
    }
    
     /**
     * Test of ConnectionGUI class constructor, with connection and MainController, for edit of a existing connection.
     */
    @Test
    public void testCreationGUIExistingConnection()
    {
        System.out.println("existingConnection");
        ArrayList<String> linkedModels = new ArrayList<String>();
        linkedModels.add("./test2.json");
        Connection c3 = new Connection("c3", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c3", linkedModels);
        cGUIExistingConnection = new ConnectionGUI(c3, mainTestController);
        assertNotNull(cGUIExistingConnection); 
    }    
}
