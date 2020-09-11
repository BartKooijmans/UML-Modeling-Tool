/*
 * Element component class (component of a model)
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Bart Kooijmans
 */
public class Element
{

    private String identifier; // unique element ID String
    private String type; // element type String
    private String description; // description String
    private ArrayList<String> attributes = new ArrayList<String>(); // ArrayLiist of Strings representing attributes 
    private ArrayList<String> operations = new ArrayList<String>(); // ArrayLiist of Strings representing operations
    private ArrayList<String> responsibilities = new ArrayList<String>(); // ArrayLiist of Strings representing responsibilities
    private ArrayList<Connection> connections = new ArrayList<Connection>(); // ArrayLiist of Connection components representing connections originating from this element 
    private ArrayList<Element> innerElements = new ArrayList<Element>(); // ArrayLiist of Element components representing elements contained within this element  
    private int startLevel; // integer representing the start level of the element
    private int endLevel; // integer representing the end level of the element
    private int terminantionLevel; // integer representing the termination level of the integer
    private String notes; // String representing the notes
    private ArrayList<String> linkedModels; // ArrayLiist of Strings containing the relative paths to models linked to the element

    /**
     * Element constructor existing element
     * 
     * @param eIdentifier unique element ID String
     * @param eType element type String
     * @param eDescription description String
     * @param eAttributes ArrayLiist of Strings representing attributes 
     * @param eOperations ArrayLiist of Strings representing operations
     * @param eResponsibilities ArrayLiist of Strings representing responsibilities
     * @param eConnections ArrayLiist of Connection components representing connections originating from this element 
     * @param eInnerElements ArrayLiist of Element components representing elements contained within this element  
     * @param eStartLevel Integer representing the start level of the element
     * @param eEndLevel integer representing the end level of the element
     * @param eTerminantionLevel integer representing the termination level of the integer
     * @param eNotes String representing the notes
     * @param eLinkedModels ArrayLiist of Strings containing the relative paths to models linked to the element
     */
    protected Element(String eIdentifier, String eType, String eDescription, ArrayList<String> eAttributes, ArrayList<String> eOperations, ArrayList<String> eResponsibilities, ArrayList<Connection> eConnections, ArrayList<Element> eInnerElements, int eStartLevel, int eEndLevel, int eTerminantionLevel, String eNotes, ArrayList<String> eLinkedModels)
    {
        identifier = eIdentifier;
        type = eType;
        description = eDescription;
        attributes = eAttributes;
        operations = eOperations;
        responsibilities = eResponsibilities;
        connections = eConnections;
        innerElements = eInnerElements;
        startLevel = eStartLevel;
        endLevel = eEndLevel;
        terminantionLevel = eTerminantionLevel;
        notes = eNotes;
        linkedModels = eLinkedModels;
    }

    /**
     * Constructor new element
     * 
     * @param nextElementId unique element ID String
     * @param eType element type String
     */
    protected Element(String nextElementId, String eType)
    {
        identifier = nextElementId;
        type = eType;
        attributes = new ArrayList<String>();
        operations = new ArrayList<String>();
        responsibilities = new ArrayList<String>();
        connections = new ArrayList<Connection>();
        innerElements = new ArrayList<Element>();
        linkedModels = new ArrayList<String>();
    }

    /**
     * Get method for identifier
     * 
     * @return String with element identifier
     */
    String getIdentifier()
    {
        return identifier;
    }

    /**
     * Get method for type
     * 
     * @return String with element type
     */
    protected String getType()
    {
        return type;
    }

    /**
     * Get method for operation
     * 
     * @return ArrayList of Strings with element operations
     */
    protected ArrayList<String> getOperation()
    {
        return operations;
    }

    /**
     * Get method for attributes
     * 
     * @return ArrayList of Strings with element attributes
     */
    protected ArrayList<String> getAttributes()
    {
        return attributes;
    }

    /**
     * Get method for responsibilities
     * 
     * @return ArrayList of Strings with element responsibilities
     */
    protected ArrayList<String> getResponsibilities()
    {
        return responsibilities;
    }

    /**
     * Get methods for connections
     * 
     * @return ArrayList of Connections with element connections
     */
    protected ArrayList<Connection> getConnections()
    {
        return connections;
    }

    /**
     * Get method for inner elements
     * 
     * @return ArrayList of Elements with element's inner elements
     */
    protected ArrayList<Element> getInnerElements()
    {
        return innerElements;
    }

    /**
     * Get method for notes
     * 
     * @return String with element notes
     */
    protected String getNotes()
    {
        return notes;
    }

    /**
     * Get method for termination level
     * 
     * @return int with element termination level
     */
    protected int getterminationLevel()
    {
        return terminantionLevel;
    }

    /**
     * Get method for end level
     * 
     * @return int with element end level
     */
    protected int getEndLevel()
    {
        return endLevel;
    }

    /**
     * Get method for start level
     * 
     * @return int with element start level
     */
    protected int getStartLevel()
    {
        return startLevel;
    }

    /**
     * Get method for description
     * 
     * @return String with element description
     */
    protected String getDescription()
    {
        return description;
    }

    /**
     * Overridden methods of toString
     * 
     * @return String with description consisting of "*Identifier* : *description*" 
     */
    @Override
    public String toString()
    {
        String temp = getIdentifier() + " : " + getDescription();
        return temp;
    }

    /**
     * Set method for Operation 
     * 
     * @param operationsList ArrayList of String representing the operations in the element
     */
    protected void setOperations(ArrayList<String> operationsList)
    {
        operations = operationsList;
    }

    /**
     * Set method for Attributes 
     * 
     * @param attributesList ArrayList of String representing the attributes in the element
     */
    protected void setAttributes(ArrayList<String> attributesList)
    {
        attributes = attributesList;
    }

    /**
     * Set method for responsibilities 
     * 
     * @param responsibilitiesList ArrayList of String representing the responsibilities in the element
     */
    protected void setResponsibilities(ArrayList<String> responsibilitiesList)
    {
        responsibilities = responsibilitiesList;
    }

    /**
     * Set method for type
     * 
     * @param nType String representing element type
     */
    protected void setType(String nType)
    {
        type = nType;
    }

    /**
     * Set method for description
     * 
     * @param nDescription String representing element description
     */
    protected void setDescription(String nDescription)
    {
        description = nDescription;
    }

    /**
     * Set method for start level 
     * 
     * @param nStartLevel int representing start level
     */
    protected void setStartLevel(int nStartLevel)
    {
        startLevel = nStartLevel;
    }

    /**
     * Set method for end level 
     * 
     * @param nEndLevel int representing end level
     */
    protected void setEndLevel(int nEndLevel)
    {
        endLevel = nEndLevel;
    }

    /**
     * Set method for termination level 
     * 
     * @param nTerminationLevel int representing element termination level
     */
    protected void setTerminationLevel(int nTerminationLevel)
    {
        terminantionLevel = nTerminationLevel;
    }

    /**
     * Set method for notes
     * 
     * @param nNotes String representing the element's notes
     */
    protected void setNotes(String nNotes)
    {
        notes = nNotes;
    }

    /**
     * Adds and connection to the elements connection's list
     * 
     * @param activeConnection Connection to be added
     */
    protected void addConnection(Connection activeConnection)
    {
        connections.add(activeConnection);
    }

    /**
     * Get method for linked models list
     * 
     * @return ArrayList of Strings containing the relative paths to models that are connected to the element.
     */
    protected ArrayList<String> getLinkedModels()
    {
        return linkedModels;
    }
}
