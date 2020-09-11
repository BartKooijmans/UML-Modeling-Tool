/*
 * Test class for connection class
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
        ArrayList<String> cLinkedModels = new ArrayList<String>(); 
        Connection c1 = new Connection("c1", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c1", cLinkedModels);
        eConnections1.add(c1);
        ArrayList<Element> eInnerElements1 = new ArrayList<Element>();
        ArrayList<String> eLinkedModels = new ArrayList<String>(); 
        tempElement = new Element("e0", "null", "Element description 0", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null", eLinkedModels);        
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
        ArrayList<String> cLinkedModels2 = new ArrayList<String>(); 
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4", cLinkedModels2);
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
        ArrayList<String> cLinkedModels2 = new ArrayList<String>(); 
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4", cLinkedModels2);
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
        ArrayList<String> cLinkedModels2 = new ArrayList<String>(); 
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4", cLinkedModels2);
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
        ArrayList<String> cLinkedModels2 = new ArrayList<String>(); 
        Connection instance = new Connection("c4", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c4", cLinkedModels2);
        instance.setEndElement(tempElement);
        String expResult = "c4 : e0 : Element description 0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }    
}
