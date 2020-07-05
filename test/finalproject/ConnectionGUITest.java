/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        mainTestController.loadEModel(fileScanner);
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
        System.out.println("newConnection");
        ArrayList<String> eAttributes1 = new ArrayList<String>();
        eAttributes1.add("attribute 1");
        eAttributes1.add("attribute 2");
        ArrayList<String> eOperations1 = new ArrayList<String>();
        eOperations1.add("test op1");
        eOperations1.add("test op2");
        ArrayList<String> eResponsibilities1 = new ArrayList<String>();
        ArrayList<Connection> eConnections1 = new ArrayList<Connection>();
        Connection c1 = new Connection("c1", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c1");
        eConnections1.add(c1);
        ArrayList<Element> eInnerElements1 = new ArrayList<Element>();
        element1 = new Element("e0", "null", "Element description 0", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null");
        cGUINewConnection = new ConnectionGUI(element1, mainTestController);        
        assertNotNull(cGUINewConnection);              
    }
    
     /**
     * Test of ConnectionGUI class constructor, with connection and MainController, for edit of a existing connection.
     */
    @Test
    public void testCreationGUIExistingConnection()
    {
        System.out.println("existingConnection");
        Connection c3 = new Connection("c3", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c3");
        cGUIExistingConnection = new ConnectionGUI(c3, mainTestController);
        assertNotNull(cGUIExistingConnection); 
    }
    
}
