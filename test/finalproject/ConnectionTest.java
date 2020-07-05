/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
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
public class ConnectionTest
{
    Element tempElement;
    
    public ConnectionTest()
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
        tempElement = new Element("e0", "null", "Element description 0", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null");        
    }
    
    @After
    public void tearDown()
    {
    }

    
    /**
     * Test of getEndElementID method, of class Connection.
     */
    @Test
    public void testGetEndElementID()
    {
        System.out.println("getEndElementID");
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4");
        instance.setEndElement(tempElement);
        String expResult = "e0";
        String result = instance.getEndElementID();
        assertEquals(expResult, result);
    }

   
    /**
     * Test of setEndElement method, of class Connection.
     */
    @Test
    public void testSetEndElement()
    {
        System.out.println("setEndElement");   
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4");
        instance.setEndElement(tempElement);
        assertNotNull(instance.getEndElement());        
    }

    /**
     * Test of getEndElement method, of class Connection.
     */
    @Test
    public void testGetEndElement()
    {
        System.out.println("getEndElement");
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4");
        instance.setEndElement(tempElement);
        Element expResult = tempElement;
        Element result = instance.getEndElement();
        assertEquals(expResult, result);
    }

   
    /**
     * Test of toString method, of class Connection.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4");
        instance.setEndElement(tempElement);
        String expResult = "c4 : e0 : Element description 0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }    
}
