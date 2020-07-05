/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.*;

/**
 *
 * @author Bart Kooijmans
 */
public class ModelController
{
    private TreeMap<String, TreeSet<String>> elementLimiter = new TreeMap<String, TreeSet<String>>();
    private TreeMap<String, TreeSet<String>> connectionLimiter = new TreeMap<String, TreeSet<String>>();
    
    public ModelController()
    {
        //Adds the Element types for a Use Case Diagram
        TreeSet<String> useCaseElements = new TreeSet<String>();
        useCaseElements.add("Use case");
        useCaseElements.add("Actor");
        useCaseElements.add("Subsystem");
        useCaseElements.add("Package");        
        elementLimiter.put("Use Case Diagram", useCaseElements);
        
        //Adds the Connection types for a Use Case Diagram
        TreeSet<String> useCaseConnections = new TreeSet<String>();
        useCaseConnections.add("Line");
        useCaseConnections.add("Dashed arrow");
        connectionLimiter.put("Use Case Diagram", useCaseConnections);
        
        //Adds the Element types for a Class Diagram
        TreeSet<String> classElements = new TreeSet<String>();
        classElements.add("Class");
        classElements.add("Class with Inner class(es)");
        classElements.add("Dashed Class");
        classElements.add("Active Class");
        classElements.add("Interface");
        classElements.add("Collaboration");
        classElements.add("Open diamond");
        elementLimiter.put("Class Diagram", classElements);
        
        //Adds the Connection types for a Class Diagram
        TreeSet<String> classConnections = new TreeSet<String>();
        classConnections.add("Line");
        classConnections.add("Arrow");
        classConnections.add("Open arrow");
        classConnections.add("Dashed arrow");
        classConnections.add("Dashed open arrow");
        classConnections.add("Open diamond line");
        classConnections.add("Closed diamond line");
        classConnections.add("Require");
        classConnections.add("Provide");
        connectionLimiter.put("Class Diagram", classConnections); 
        
        //Adds the Element types for a Activity Diagram
        TreeSet<String> activityElements = new TreeSet<String>();
        activityElements.add("Action Node");
        activityElements.add("Object Node");
        activityElements.add("Split and Merge Node");
        activityElements.add("Fork and Join Node");
        activityElements.add("Initial Node");
        activityElements.add("Activity Final Node");
        activityElements.add("Flow Final Node");
        activityElements.add("Partition");        
        activityElements.add("Class with Inner class(es)");
        elementLimiter.put("Activity Diagram", activityElements);
        
        //Adds the Connection types for a Activity Diagram
        TreeSet<String> activityConnections = new TreeSet<String>();
        activityConnections.add("Arrow");
        activityConnections.add("Zig-zag Arrow");
        connectionLimiter.put("Activity Diagram", activityConnections);
    }
    
    
    protected TreeSet<String> getConnection(String diagramType)
    {    
        return connectionLimiter.get(diagramType);
    }
    
    
    protected TreeSet<String> getElements(String diagramType)
    {
        return elementLimiter.get(diagramType);
    }
    
    protected Object[] getDiagrams()
    {
        Set<String> diagrams = elementLimiter.keySet();
        Object[] allowedDiagrams = diagrams.toArray();        
        return allowedDiagrams;
    }
}
