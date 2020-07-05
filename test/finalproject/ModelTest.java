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
public class ModelTest
{
    ArrayList<Element> elementList;
    
    public ModelTest()
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
        elementList = new ArrayList<Element>();
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
        elementList.add(new Element("element 1", "null", "Element description 1", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null"));
        ArrayList<String> eAttributes2 = new ArrayList<String>();
        ArrayList<String> eOperations2 = new ArrayList<String>();
        ArrayList<String> eResponsibilities2 = new ArrayList<String>();
        ArrayList<Connection> eConnections2 = new ArrayList<Connection>();
        Connection c2 = new Connection("c2", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "null");
        ArrayList<Element> eInnerElements2 = new ArrayList<Element>();
        eConnections2.add(c2);
        elementList.add(new Element("element 2", "null", "Element description 2", eAttributes2, eOperations2, eResponsibilities2, eConnections2, eInnerElements2, 0, 0, 0, "null"));
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getElements method, of class Model.
     */
    @Test
    public void testGetElements()
    {
        System.out.println("getElements");
        Model instance = new Model("Class Diagram", true, elementList);
        ArrayList<Element> expResult = elementList;
        ArrayList<Element> result = instance.getElements();
        assertEquals(expResult, result);
    }
    
}
