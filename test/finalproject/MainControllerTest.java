/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.*;
import java.util.*;
import javax.swing.JPanel;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Bart Kooijmans
 */
public class MainControllerTest
{
    Scanner fileScanner;
    ArrayList<Element> elementList;
    ArrayList<Connection> connectionList;
    Element e0;
    Element e2;
    Element e1;
    Connection c3;
    Connection c2;
    Connection c1; 
    
    public MainControllerTest()
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
        File jsonTestLoadFile = new File("C:/Users/Botje/Documents/test.json");
        fileScanner = new Scanner(new BufferedReader(new FileReader(jsonTestLoadFile)));
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
        e1 = new Element("element 1", "null", "Element description 1", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null");
        elementList.add(e1);
        ArrayList<String> eAttributes2 = new ArrayList<String>();
        ArrayList<String> eOperations2 = new ArrayList<String>();
        ArrayList<String> eResponsibilities2 = new ArrayList<String>();
        ArrayList<Connection> eConnections2 = new ArrayList<Connection>();
        Connection c2 = new Connection("c2", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "null");
        ArrayList<Element> eInnerElements2 = new ArrayList<Element>();
        eConnections2.add(c2);
        e2 = new Element("element 2", "null", "Element description 2", eAttributes2, eOperations2, eResponsibilities2, eConnections2, eInnerElements2, 0, 0, 0, "null");
        elementList.add(e2);
        connectionList = new ArrayList<Connection>();
        connectionList.add(c1);
        connectionList.add(c2);
        
        ArrayList<String> eAttributesInner1 = new ArrayList<String>();
        eAttributesInner1.add("Inner attribute 1");
        eAttributesInner1.add("Inner attribute 2");
        ArrayList<String> eOperationsInner1 = new ArrayList<String>();
        eOperationsInner1.add("Inner test op1");
        eOperationsInner1.add("Inner test op2");
        ArrayList<String> eResponsibilitiesInner1 = new ArrayList<String>();
        eResponsibilitiesInner1.add("Inner response 1");
        ArrayList<Connection> eConnectionsInner1 = new ArrayList<Connection>();
        Connection c3 = new Connection("c3", "null", "null", "null", "null", "null", "null", "null", "e0", 0, "test notes c3");
        eConnectionsInner1.add(c3);
        ArrayList<Element> eInnerElements3 = new ArrayList<Element>();
        e0 = new Element("e0", "null", "Element description 0", eAttributesInner1, eOperationsInner1, eResponsibilitiesInner1, eConnectionsInner1, eInnerElements3, 0, 0, 0, "null"); 
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getSupportedModels method, of class MainController.
     */
    @Test
    public void testGetSupportedModels()
    {
        System.out.println("getSupportedModels");
        MainController instance = new MainController();
        TreeSet<String> diagrams = new TreeSet<>();
        diagrams.add("Activity Diagram");
        diagrams.add("Class Diagram");
        diagrams.add("Use Case Diagram");
        Object[] expResult = diagrams.toArray();
        Object[] result = instance.getSupportedModels();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getAllowedElements method, of class MainController.
     */
    @Test
    public void testGetAllowedElements()
    {
        System.out.println("getAllowedElements");
        MainController instance = new MainController();
        instance.newModel("Class Diagram");                
        TreeSet<String> expResult = new TreeSet<>();
        expResult.add("Class");
        expResult.add("Class with Inner class(es)");
        expResult.add("Dashed Class");
        expResult.add("Active Class");
        expResult.add("Interface");
        expResult.add("Collaboration");
        expResult.add("Open diamond");
        TreeSet<String> result = instance.getAllowedElements();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllowedConnections method, of class MainController.
     */
    @Test
    public void testGetAllowedConnections()
    {
        System.out.println("getAllowedConnections");
        MainController instance = new MainController();
        instance.newModel("Activity Diagram"); 
        TreeSet<String> expResult = new TreeSet<String>();
        expResult.add("Arrow");
        expResult.add("Zig-zag Arrow");
        TreeSet<String> result = instance.getAllowedConnections();
        assertEquals(expResult, result);
    }


    /**
     * Test of newModel method, of class MainController.
     */
    @Test
    public void testNewModel()
    {
        System.out.println("newModel");
        String s = "";
        MainController instance = new MainController();
        instance.newModel("Activity Diagram");
        assertNotNull(instance.getModel());
        assertEquals("Activity Diagram", instance.getModel().getModelType());
    }

    /**
     * Test of existingModel method, of class MainController.
     */
    @Test
    public void testExistingModel()
    {
        System.out.println("existingModel");
        String type = "Class Diagram";
        boolean present = false;
        ArrayList<Element> existingE = new ArrayList<Element>();
        MainController instance = new MainController();
        instance.existingModel(type, present, existingE);
        assertNotNull(instance.getModel());
        assertEquals("Class Diagram", instance.getModel().getModelType());
        assertEquals(false, instance.getModel().getElementPresent());
        assertNotNull(instance.getModel().getElements());
        assertEquals(0, instance.getModel().getElements().size());
    }

    /**
     * Test of loadAllInstances method, of class MainController.
     */
    @Test
    public void testLoadAllInstances()
    {
        System.out.println("loadAllInstances");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        instance.loadAllInstances();
        for(Element test : instance.getModel().getElements())
        {
            assertTrue(instance.getElements().contains(test));
        }
    }

    /**
     * Test of updateUI method, of class MainController.
     */
    @Test
    public void testUpdateUI()
    {
        System.out.println("updateUI");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        JPanel result = instance.updateUI();        
        assertNotNull(result); 
    }



    /**
     * Test of findElement method, of class MainController.
     */
    @Test
    public void testFindElement()
    {
        System.out.println("findElement");
        String lookup = "element 2";
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        Element expResult = instance.getModel().getElements().get(1);
        Element result = instance.findElement(lookup);
        assertEquals(expResult, result);
    }

    /**
     * Test of findConnection method, of class MainController.
     */
    @Test
    public void testFindConnection()
    {
        System.out.println("findConnection");
        String connectionID = "c2";
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        Connection expResult = instance.getModel().getElements().get(1).getConnections().get(0);
        Connection result = instance.findConnection(connectionID);
        assertEquals(expResult, result);
    }

    /**
     * Test of findNextAvailableConnectionID method, of class MainController.
     */
    @Test
    public void testFindNextAvailableConnectionID()
    {
        System.out.println("findNextAvailableConnectionID");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        String expResult = "c0";
        String result = instance.findNextAvailableConnectionID();
        assertEquals(expResult, result);
    }

    /**
     * Test of findNextAvailableElementID method, of class MainController.
     */
    @Test
    public void testFindNextAvailableElementID()
    {
        System.out.println("findNextAvailableElementID");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        String expResult = "e0";
        String result = instance.findNextAvailableElementID();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadEModel method, of class MainController.
     */
    @Test
    public void testLoadEModel()
    {
        System.out.println("loadEModel");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        assertNotNull(instance.getModel());
        assertEquals("Activity Diagram", instance.getModel().getModelType());
        assertTrue(instance.getModel().getElementPresent());
    }

    /**
     * Test of savingModel method, of class MainController.
     */
    @Test
    public void testSavingModel() throws FileNotFoundException
    {
        System.out.println("savingModel");
        Model activeModel = new Model("Class Diagram", true, elementList);
        File selectedFile = new File("C:/Users/Botje/Documents/testSaving.json");
        MainController instance = new MainController();
        instance.savingModel(activeModel, selectedFile);
        Scanner savedFileScanner = new Scanner(new BufferedReader(new FileReader(selectedFile)));
        MainController instance2 = new MainController();
        instance2.loadEModel(savedFileScanner);
        assertEquals("Class Diagram", instance2.getModel().getModelType());
        assertTrue(instance2.getModel().getElementPresent());
        for(Element test : elementList) 
        {
            Element temp = instance2.findElement(test.getIdentifier());
            assertNotNull(temp);
        }
    }

    /**
     * Test of getIDFromBox method, of class MainController.
     */
    @Test
    public void testGetIDFromBox()
    {
        System.out.println("getIDFromBox");
        String boxID = "c1 : Connection 1";
        MainController instance = new MainController();
        String expResult = "c1";
        String result = instance.getIDFromBox(boxID);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeElement method, of class MainController.
     */
    @Test
    public void testRemoveElement()
    {
        System.out.println("removeElement");
        String elementIDToBeRemoved = "element 1";        
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        instance.removeElement(elementIDToBeRemoved);
        assertNull(instance.findElement(elementIDToBeRemoved));
        assertEquals(1, instance.getModel().getElements().size());
        assertEquals(1, instance.getElements().size());
        assertTrue(instance.getModel().getElementPresent());
        assertEquals(0, instance.getElements().get(0).getConnections().size());
    }
    
    
    /**
     * Test of removeElement method, of class MainController, where the last Element in a model gets removed.
     */
    @Test
    public void testRemoveLastElement()
    {
        System.out.println("removeElement");
        String elementIDToBeRemoved = "element 1";        
        MainController instance = new MainController();
        instance.newModel("Class Diagram");
        instance.addElement(e1);
        instance.removeElement(elementIDToBeRemoved);
        assertNull(instance.findElement(elementIDToBeRemoved));
        assertEquals(0, instance.getModel().getElements().size());
        assertEquals(0, instance.getElements().size());
        assertFalse(instance.getModel().getElementPresent());
    }
    
    
    /**
     * Test of addElement method, of class MainController with a new Model.
     */
    @Test
    public void addElementEmptyModel()
    {
        System.out.println("findNextAvailableElementID");
        MainController instance = new MainController();
        instance.newModel("Class Diagram");
        assertFalse(instance.getModel().getElementPresent());
        instance.addElement(e0);
        assertTrue(instance.getModel().getElementPresent());
        ArrayList<Element> expResult = new ArrayList<>();
        expResult.add(e0);
        ArrayList<Element> result = instance.getElements();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of addElement method, of class MainController with a existing Model.
     */
    @Test
    public void addElementExistingModel()
    {
        System.out.println("findNextAvailableElementID");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner);
        assertTrue(instance.getModel().getElementPresent());
        instance.addElement(e0);
        assertTrue(instance.getModel().getElementPresent());     
        ArrayList<Element> result = instance.getElements();
        assertTrue(result.contains(e0));
        assertEquals(3, result.size());
    }
    
}
