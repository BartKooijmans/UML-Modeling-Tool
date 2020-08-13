/*
 * Model controller class that sets out the limitations per model type for the element and connection types allowed.
 */
package finalproject;

import java.util.*;

/**
 *
 * @author Bart Kooijmans
 */
public class ModelController
{

    private TreeMap<String, TreeSet<String>> elementLimiter = new TreeMap<String, TreeSet<String>>(); //Treemap containing per model type the allowed element types 
    private TreeMap<String, TreeSet<String>> connectionLimiter = new TreeMap<String, TreeSet<String>>(); //Treemap containing per model type the allowed connection types

    /**
     * Constructor for Model controller class that also initialise both the Treemaps
     */
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
        activityElements.add("Object");
        elementLimiter.put("Activity Diagram", activityElements);

        //Adds the Connection types for a Activity Diagram
        TreeSet<String> activityConnections = new TreeSet<String>();
        activityConnections.add("Arrow");
        activityConnections.add("Zig-zag Arrow");
        connectionLimiter.put("Activity Diagram", activityConnections);

        //Adds the Element types for a Communication Diagram
        TreeSet<String> communicationElements = new TreeSet<String>();
        communicationElements.add("Object Instance");
        elementLimiter.put("Communication Diagram", communicationElements);

        //Adds the Connection types for a Communication Diagram
        TreeSet<String> communicationConnections = new TreeSet<String>();
        communicationConnections.add("Line");
        connectionLimiter.put("Communication Diagram", communicationConnections);

        //Adds the Element types for a Interaction Diagram
        TreeSet<String> interactionElements = new TreeSet<String>();
        interactionElements.add("Frame");
        interactionElements.add("Interaction");        
        interactionElements.add("Split and Merge Node");
        interactionElements.add("Initial Node");
        interactionElements.add("Fork and Join Node");
        interactionElements.add("Final Node");
        elementLimiter.put("Interaction Diagram", interactionElements);

        //Adds the Connection types for a Interaction Diagram
        TreeSet<String> interactionConnections = new TreeSet<String>();
        interactionConnections.add("Arrow");
        connectionLimiter.put("Interaction Diagram", interactionConnections);

        //Adds the Element types for a Component Diagram
        TreeSet<String> componentElements = new TreeSet<String>();
        componentElements.add("Component");
        componentElements.add("Interface require");
        componentElements.add("Interface provide");
        componentElements.add("Port");
        elementLimiter.put("Component Diagram", componentElements);

        //Adds the Connection types for a Component Diagram
        TreeSet<String> componentConnections = new TreeSet<String>();
        componentConnections.add("Line");
        componentConnections.add("Arrow");
        componentConnections.add("Dashed arrow");
        componentConnections.add("Open diamond line");
        connectionLimiter.put("Component Diagram", componentConnections);

        //Adds the Element types for a Composite Structure Diagram
        TreeSet<String> compositeStructureElements = new TreeSet<String>();
        compositeStructureElements.add("Object Instance");
        elementLimiter.put("Composite Structure Diagram", compositeStructureElements);

        //Adds the Connection types for a Composite Structure Diagram
        TreeSet<String> compositeStructureConnections = new TreeSet<String>();
        compositeStructureConnections.add("Line");
        connectionLimiter.put("Composite Structure Diagram", compositeStructureConnections);

        //Adds the Element types for a Deployment Diagram
        TreeSet<String> deploymentElements = new TreeSet<String>();
        deploymentElements.add("Artifact");
        deploymentElements.add("Node");
        elementLimiter.put("Deployment Diagram", deploymentElements);

        //Adds the Connection types for a Deployment Diagram
        TreeSet<String> deploymentConnections = new TreeSet<String>();
        deploymentConnections.add("Line");
        deploymentConnections.add("Dashed arrow");
        connectionLimiter.put("Deployment Diagram", deploymentConnections);

        //Adds the Element types for a Object Diagram
        TreeSet<String> objectElements = new TreeSet<String>();
        objectElements.add("Object");
        elementLimiter.put("Object Diagram", objectElements);

        //Adds the Connection types for a Object Diagram
        TreeSet<String> objectConnections = new TreeSet<String>();
        objectConnections.add("Line");
        connectionLimiter.put("Object Diagram", objectConnections);

        //Adds the Element types for a Package Diagram
        TreeSet<String> packageElements = new TreeSet<String>();
        packageElements.add("Package");
        packageElements.add("Class");
        packageElements.add("Actor");
        elementLimiter.put("Package Diagram", packageElements);
        
        //Adds the Connection types for a Package Diagram
        TreeSet<String> packageConnections = new TreeSet<String>();
        packageConnections.add("Line");
        packageConnections.add("Closed arrow");
        packageConnections.add("Dashed arrow");
        connectionLimiter.put("Package Diagram", packageConnections);

        //Adds the Element types for a Profile Diagram
        TreeSet<String> profileElements = new TreeSet<String>();
        profileElements.add("Stereotype");
        profileElements.add("Constraint and Value");
        elementLimiter.put("Profile Diagram", profileElements);

        //Adds the Connection types for a Profile Diagram
        TreeSet<String> profileConnections = new TreeSet<String>();
        profileConnections.add("Dashed line");
        profileConnections.add("Closed arrow");
        connectionLimiter.put("Profile Diagram", profileConnections);

        //Adds the Element types for a Sequence Diagram
        TreeSet<String> sequenceElements = new TreeSet<String>();
        sequenceElements.add("Object Instance");
        elementLimiter.put("Sequence Diagram", sequenceElements);

        //Adds the Connection types for a Sequence Diagram
        TreeSet<String> sequenceConnections = new TreeSet<String>();
        sequenceConnections.add("Arrow");
        sequenceConnections.add("Closed arrow");
        sequenceConnections.add("Dashed arrow");
        connectionLimiter.put("Sequence Diagram", sequenceConnections);

        //Adds the Element types for a State Machine Diagram
        TreeSet<String> stateMachineElements = new TreeSet<String>();
        stateMachineElements.add("Initial Node");
        stateMachineElements.add("Final Node");
        stateMachineElements.add("State");
        stateMachineElements.add("Composite State");
        stateMachineElements.add("Split and Merge Node");
        stateMachineElements.add("Fork and Join Node");
        stateMachineElements.add("Protocol");
        elementLimiter.put("State Machine Diagram", stateMachineElements);

        //Adds the Connection types for a State Machine Diagram
        TreeSet<String> stateMachineConnections = new TreeSet<String>();
        stateMachineConnections.add("Arrow");
        connectionLimiter.put("State Machine Diagram", stateMachineConnections);

        //Adds the Element types for a Timing Diagram
        TreeSet<String> timingElements = new TreeSet<String>();
        timingElements.add("Instance");
        timingElements.add("Timeslot");
        elementLimiter.put("Timing Diagram", timingElements);

        //Adds the Connection types for a Timing Diagram
        TreeSet<String> timingConnections = new TreeSet<String>();
        timingConnections.add("Arrow");
        timingConnections.add("Dashed arrow");
        connectionLimiter.put("Timing Diagram", timingConnections);
    }

    /**
     * Return an TreeSet of strings containing the allowed connection types based on the model type that gets given
     * 
     * @param diagramType String representing the model type of the model
     * @return TreeSet of Strings containing the allowed connection types
     */
    protected TreeSet<String> getConnection(String diagramType)
    {
        return connectionLimiter.get(diagramType);
    }

    /**
     * Return an TreeSet of strings containing the allowed element types based on the model type that gets given
     * 
     * @param diagramType String representing the model type of the model
     * @return TreeSet of Strings containing the allowed element types
     */
    protected TreeSet<String> getElements(String diagramType)
    {
        return elementLimiter.get(diagramType);
    }

    /**
     * Returns a Object array of the allowed model types, based on the model type keyset the element type TreeSet.
     * 
     * @return Object array of the supported model types
     */
    protected Object[] getDiagrams()
    {
        Set<String> diagrams = elementLimiter.keySet();
        Object[] allowedDiagrams = diagrams.toArray();
        return allowedDiagrams;
    }
}
