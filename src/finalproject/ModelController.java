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
    TreeMap<String, TreeSet<String>> ElementLimiter = new TreeMap<String, TreeSet<String>>();
    TreeMap<String, TreeSet<String>> ConnectionLimiter = new TreeMap<String, TreeSet<String>>();
    
    public ModelController()
    {
        //Adds the Element types for a Use Case Diagram
        TreeSet<String> UseCaseElements = new TreeSet<String>();
        UseCaseElements.add("UseCase");
        UseCaseElements.add("Actor");
        UseCaseElements.add("Subsystem");
        UseCaseElements.add("Package");        
        ElementLimiter.put("Use Case Diagram", UseCaseElements);
        
        //Adds the Connection types for a Use Case Diagram
        TreeSet<String> UseCaseConnections = new TreeSet<String>();
        UseCaseConnections.add("Line");
        UseCaseConnections.add("Dashed arrow");
        ConnectionLimiter.put("Use Case Diagram", UseCaseConnections);
        
        //Adds the Element types for a Class Diagram
        TreeSet<String> ClassElements = new TreeSet<String>();
        ClassElements.add("Class");
        ClassElements.add("Class with Inner class(es)");
        ClassElements.add("Dashed Class");
        ClassElements.add("Active Class");
        ClassElements.add("Interface");
        ClassElements.add("Collaboration");
        ClassElements.add("Open diamond");
        ElementLimiter.put("Class Diagram", ClassElements);
        
        //Adds the Connection types for a Class Diagram
        TreeSet<String> ClassConnections = new TreeSet<String>();
        ClassConnections.add("Line");
        ClassConnections.add("Arrow");
        ClassConnections.add("Open arrow");
        ClassConnections.add("Dashed arrow");
        ClassConnections.add("Dashed open arrow");
        ClassConnections.add("Open diamond line");
        ClassConnections.add("Closed diamond line");
        ClassConnections.add("Require");
        ClassConnections.add("provide");
        ConnectionLimiter.put("Class Diagram", ClassConnections); 
        
        //Adds the Element types for a Activity Diagram
        TreeSet<String> ActivityElements = new TreeSet<String>();
        ActivityElements.add("Action Node");
        ActivityElements.add("Object Node");
        ActivityElements.add("Split and Merge Node");
        ActivityElements.add("Fork and Join Node");
        ActivityElements.add("Initial Node");
        ActivityElements.add("Activity Final Node");
        ActivityElements.add("Flow Final Node");
        ActivityElements.add("Partition");
        
        ActivityElements.add("Class with Inner class(es)");
        ElementLimiter.put("Activity Diagram", ActivityElements);
        
        //Adds the Connection types for a Activity Diagram
        TreeSet<String> ActivityConnections = new TreeSet<String>();
        ActivityConnections.add("Arrow");
        ActivityConnections.add("Zig-zag Arrow");
        ConnectionLimiter.put("Activity Diagram", ActivityConnections);
    }
    
    
    protected TreeSet<String> getConnection(String diagramType)
    {    
        return ConnectionLimiter.get(diagramType);
    }
    
    
    protected TreeSet<String> getElements(String diagramType)
    {
        return ElementLimiter.get(diagramType);
    }
    
    protected Object[] getDiagrams()
    {
        Set<String> diagrams = ElementLimiter.keySet();
        Object[] allowedDiagrams = diagrams.toArray();        
        return allowedDiagrams;
    }
}
