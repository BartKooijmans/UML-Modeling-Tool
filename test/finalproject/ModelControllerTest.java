/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.TreeSet;
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
public class ModelControllerTest
{
    
    public ModelControllerTest()
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
     * Test of getConnection method, of class ModelController.
     */
    @Test
    public void testGetConnection()
    {
        System.out.println("getConnection");
        String diagramType = "Class Diagram";
        ModelController instance = new ModelController();
        TreeSet<String> expResult = new TreeSet<>();
        expResult.add("Line");
        expResult.add("Arrow");
        expResult.add("Open arrow");
        expResult.add("Dashed arrow");
        expResult.add("Dashed open arrow");
        expResult.add("Open diamond line");
        expResult.add("Closed diamond line");
        expResult.add("Require");
        expResult.add("Provide");
        TreeSet<String> result = instance.getConnection(diagramType);
        assertEquals(expResult, result);
     }

    /**
     * Test of getElements method, of class ModelController.
     */
    @Test
    public void testGetElements()
    {
        System.out.println("getElements");
        String diagramType = "Activity Diagram";
        ModelController instance = new ModelController();
        TreeSet<String> expResult = new TreeSet<>();
        expResult.add("Action Node");
        expResult.add("Object");
        expResult.add("Object Node");
        expResult.add("Split and Merge Node");
        expResult.add("Fork and Join Node");
        expResult.add("Initial Node");
        expResult.add("Activity Final Node");
        expResult.add("Flow Final Node");
        expResult.add("Partition");        
        TreeSet<String> result = instance.getElements(diagramType);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDiagrams method, of class ModelController.
     */
    @Test
    public void testGetDiagrams()
    {
        System.out.println("getDiagrams");
        ModelController instance = new ModelController();
        Object[] expResult = new Object[14];
        expResult[0] = "Activity Diagram";
        expResult[1] = "Class Diagram";
        expResult[2] = "Communication Diagram";
        expResult[3] = "Component Diagram";
        expResult[4] = "Composite Structure Diagram";
        expResult[5] = "Deployment Diagram";
        expResult[6] = "Interaction Diagram";
        expResult[7] = "Object Diagram";
        expResult[8] = "Package Diagram";
        expResult[9] = "Profile Diagram";
        expResult[10] = "Sequence Diagram";
        expResult[11] = "State Machine Diagram";
        expResult[12] = "Timing Diagram";
        expResult[13] = "Use Case Diagram";
        Object[] result = instance.getDiagrams();
        assertArrayEquals(expResult, result);
    }
    
}
