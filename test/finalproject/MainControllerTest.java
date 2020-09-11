/*
 * Test class for the main controller class.
 */
package finalproject;

import java.io.*;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        ArrayList<String> cLinkedModels1 = new ArrayList<String>();
        Connection c1 = new Connection("c1", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "test notes c1", cLinkedModels1);
        eConnections1.add(c1);
        ArrayList<Element> eInnerElements1 = new ArrayList<Element>();
        ArrayList<String> eLinkedModels1 = new ArrayList<String>();
        eLinkedModels1.add("./test2.json");
        e1 = new Element("element 1", "null", "Element description 1", eAttributes1, eOperations1, eResponsibilities1, eConnections1, eInnerElements1, 0, 0, 0, "null", eLinkedModels1);
        elementList.add(e1);
        ArrayList<String> eAttributes2 = new ArrayList<String>();
        ArrayList<String> eOperations2 = new ArrayList<String>();
        ArrayList<String> eResponsibilities2 = new ArrayList<String>();
        ArrayList<Connection> eConnections2 = new ArrayList<Connection>();
        ArrayList<String> cLinkedModels2 = new ArrayList<String>();
        Connection c2 = new Connection("c2", "null", "null", "null", "null", "null", "null", "null", "element 1", 0, "null", cLinkedModels2);
        ArrayList<Element> eInnerElements2 = new ArrayList<Element>();
        eConnections2.add(c2);
        ArrayList<String> eLinkedModels2 = new ArrayList<String>();
        e2 = new Element("element 2", "null", "Element description 2", eAttributes2, eOperations2, eResponsibilities2, eConnections2, eInnerElements2, 0, 0, 0, "null", eLinkedModels2);
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
        ArrayList<String> cLinkedModels3 = new ArrayList<String>();
        Connection c3 = new Connection("c3", "null", "null", "null", "null", "null", "null", "null", "e0", 0, "test notes c3", cLinkedModels3);
        eConnectionsInner1.add(c3);
        ArrayList<Element> eInnerElements3 = new ArrayList<Element>();
        ArrayList<String> eLinkedModels3 = new ArrayList<String>();
        e0 = new Element("e0", "null", "Element description 0", eAttributesInner1, eOperationsInner1, eResponsibilitiesInner1, eConnectionsInner1, eInnerElements3, 0, 0, 0, "null", eLinkedModels3);
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
        diagrams.add("Communication Diagram");
        diagrams.add("Component Diagram");
        diagrams.add("Composite Structure Diagram");
        diagrams.add("Deployment Diagram");
        diagrams.add("Interaction Diagram");
        diagrams.add("Object Diagram");
        diagrams.add("Package Diagram");
        diagrams.add("Profile Diagram");
        diagrams.add("Sequence Diagram");
        diagrams.add("State Machine Diagram");
        diagrams.add("Timing Diagram");
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
        ArrayList<String> linkedModels = new ArrayList<String>();
        linkedModels.add("./test2.json");
        instance.existingModel(type, present, existingE, linkedModels);
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
        instance.loadAllInstances();
        for (Element test : instance.getModel().getElements())
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
        assertNotNull(instance.getModel());
        assertEquals("Activity Diagram", instance.getModel().getModelType());
        assertTrue(instance.getModel().getElementPresent());
    }

    /**
     * Test of savingModel method, of class MainController.
     * 
     * Saving model has been modified no longer adds the model.
     */
    @Test
    public void testSavingModel() throws FileNotFoundException
    {
        System.out.println("savingModel");   
        File selectedFile = new File("C:/Users/Botje/Documents/testSaving.json");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents");
        instance.savingModel(selectedFile);
        Scanner savedFileScanner = new Scanner(new BufferedReader(new FileReader(selectedFile)));
        MainController instance2 = new MainController();
        instance2.loadEModel(savedFileScanner, "C:/Users/Botje/Documents/");
        assertEquals("Activity Diagram", instance2.getModel().getModelType());
        assertTrue(instance2.getModel().getElementPresent());
        for (Element test : elementList)
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
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
        instance.removeElement(elementIDToBeRemoved);
        assertNull(instance.findElement(elementIDToBeRemoved));
        assertEquals(1, instance.getModel().getElements().size());
        assertEquals(1, instance.getElements().size());
        assertTrue(instance.getModel().getElementPresent());
        assertEquals(0, instance.getElements().get(0).getConnections().size());
    }

    /**
     * Test of removeElement method, of class MainController, where the last
     * Element in a model gets removed.
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
    public void testAddElementEmptyModel()
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
    public void testAddElementExistingModel()
    {
        System.out.println("findNextAvailableElementID");
        MainController instance = new MainController();
        instance.loadEModel(fileScanner, "C:/Users/Botje/Documents/");
        assertTrue(instance.getModel().getElementPresent());
        instance.addElement(e0);
        assertTrue(instance.getModel().getElementPresent());
        ArrayList<Element> result = instance.getElements();
        assertTrue(result.contains(e0));
        assertEquals(3, result.size());
    }

    /**
     * Test of getRelativePath(File linkedFile) method, of class MainController
     * with a existing Model with a path of C:\Users\Botje\Documents and a
     * linked model in a lower folder.
     */
    @Test
    public void testGetRelativePathLower()
    {
        System.out.println("getRelativePathLower");
        MainController testController = new MainController();
        testController.loadEModel(fileScanner, "C:/Users/Botje/Documents");
        File testFile = new File("C:/Users/Botje/Documents/TestJson/test5.json");
        String result = testController.getRelativePath(testFile);
        String expResult = "./TestJson/test5.json";
        assertEquals(expResult, result);
    }

    /**
     * Test of getRelativePath(File linkedFile) method, of class MainController
     * with a existing Model with a path of C:\Users\Botje\Documents\TestJson
     * and a linked model in a higher folder.
     */
    @Test
    public void testGetRelativePathHigher() throws FileNotFoundException
    {
        System.out.println("getRelativePathHigher");
        MainController testController = new MainController();
        File testMainFile = new File("C:/Users/Botje/Documents/TestJson/test5.json");
        Scanner testFileScanner = new Scanner(new BufferedReader(new FileReader(testMainFile)));
        testController.loadEModel(testFileScanner, "C:/Users/Botje/Documents/TestJson");
        File testLinkedFile = new File("C:/Users/Botje/Documents/test.json");
        String result = testController.getRelativePath(testLinkedFile);
        String expResult = ".././test.json";
        assertEquals(expResult, result);
    }

    /**
     * Test of addLinkedModel method, of class MainController with an existing Model.
     */
    @Test
    public void testAddLinkedModel()
    {
        MainController testController = new MainController();
        testController.loadEModel(fileScanner, "C:/Users/Botje/Documents");
        int expResult = testController.getModel().getLinkedModels().size() + 1;
        testController.addLinkedModel("./TestJson/test5.json");
        int result = testController.getModel().getLinkedModels().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadLinkedMode method, of class MainController with an existing Model.
     */
    @Test
    public void loadLinkedModel()
    {
        MainController testController = new MainController();
        testController.loadEModel(fileScanner, "C:/Users/Botje/Documents");
        testController.loadLinkedModel("./TestJson/test5.json");
        assertNotNull(testController.getModel());
        int result = testController.getModel().getElements().get(0).getInnerElements().size();
        assertEquals(1, result);
    }

}
