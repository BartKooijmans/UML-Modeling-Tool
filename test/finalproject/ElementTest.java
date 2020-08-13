/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

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
public class ElementTest
{
    Element e0;
    Element eInner1;
    Connection c1;
    
    public ElementTest()
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
        ArrayList<String> cLinkedModels1 = new ArrayList<String>(); 
        c1 = new Connection("c1", "null", "null", "null", "null", "null", "null", "null", "e0", 0, "test notes c1", cLinkedModels1);
        eConnections1.add(c1);
        ArrayList<Element> eInnerElements1 = new ArrayList<Element>();
        ArrayList<String> eLinkedModels1 = new ArrayList<String>(); 
        e0 = new Element("e0", "null", "Element description 0", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null", eLinkedModels1); 
        
        ArrayList<String> eAttributesInner1 = new ArrayList<String>();
        eAttributesInner1.add("Inner attribute 1");
        eAttributesInner1.add("Inner attribute 2");
        ArrayList<String> eOperationsInner1 = new ArrayList<String>();
        eOperationsInner1.add("Inner test op1");
        eOperationsInner1.add("Inner test op2");
        ArrayList<String> eResponsibilitiesInner1 = new ArrayList<String>();
        eResponsibilitiesInner1.add("Inner response 1");
        ArrayList<Connection> eConnectionsInner1 = new ArrayList<Connection>();
        ArrayList<String> cLinkedModels2 = new ArrayList<String>();        
        Connection c2 = new Connection("c2", "null", "null", "null", "null", "null", "null", "null", "e0", 0, "test notes c1", cLinkedModels2);
        eConnectionsInner1.add(c2);
        ArrayList<Element> eInnerElements2 = new ArrayList<Element>();
        ArrayList<String> eLinkedModels2 = new ArrayList<String>(); 
        eInner1 = new Element("e1", "null", "Element description 0", eAttributesInner1, eOperationsInner1, eResponsibilitiesInner1, eConnectionsInner1, eInnerElements2, 0, 0, 0, "null", eLinkedModels2); 
        
        eInnerElements1.add(eInner1);
        ArrayList<String> eLinkedModels3 = new ArrayList<String>(); 
        e0 = new Element("e0", "null", "Element description 0", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null", eLinkedModels3); 
    }
    
    @After
    public void tearDown()
    {
    }



    /**
     * Test of getOperation method, of class Element.
     */
    @Test
    public void testGetOperation()
    {
        System.out.println("getOperation");
        Element instance = e0;
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("test op1");
        expResult.add("test op2");
        ArrayList<String> result = instance.getOperation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAttributes method, of class Element.
     */
    @Test
    public void testGetAttributes()
    {
        System.out.println("getAttributes");
        Element instance = eInner1;
        ArrayList<String> expResult = new ArrayList<>();        
        expResult.add("Inner attribute 1");
        expResult.add("Inner attribute 2");
        ArrayList<String> result = instance.getAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResponsibilities method, of class Element.
     */
    @Test
    public void testGetResponsibilities()
    {
        System.out.println("getResponsibilities");
        Element instance = eInner1;
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Inner response 1");
        ArrayList<String> result = instance.getResponsibilities();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConnections method, of class Element.
     */
    @Test
    public void testGetConnections()
    {
        System.out.println("getConnections");
        Element instance = e0;
        ArrayList<Connection> expResult = new ArrayList<>();
        expResult.add(c1);
        ArrayList<Connection> result = instance.getConnections();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInnerElements method, of class Element.
     */
    @Test
    public void testGetInnerElements()
    {
        System.out.println("getInnerElements");
        Element instance = e0;
        ArrayList<Element> expResult = new ArrayList<>();
        expResult.add(eInner1);
        ArrayList<Element> result = instance.getInnerElements();
        assertEquals(expResult, result);
    }



    /**
     * Test of toString method, of class Element.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Element instance = e0;
        String expResult = "e0 : Element description 0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addConnection method, of class Element.
     */
    @Test
    public void testAddConnection()
    {
        System.out.println("addConnection");
        Element instance = e0;
        ArrayList<String> cLinkedModels = new ArrayList<String>(); 
        Connection c3 = new Connection("c3", "null", "null", "null", "null", "null", "null", "null", "e0", 0, "test notes c3", cLinkedModels);
        instance.addConnection(c3);
        ArrayList<Connection> result = instance.getConnections();
        ArrayList<Connection> expResult = new ArrayList<>();
        expResult.add(c1);
        expResult.add(c3);               
        assertEquals(expResult, result);
    }    
}
