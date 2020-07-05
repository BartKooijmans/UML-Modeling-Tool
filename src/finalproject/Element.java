/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Bart Kooijmans
 */
public class Element
{

    private String identifier;
    private String type;
    private String description;
    private ArrayList<String> attributes = new ArrayList<String>();
    private ArrayList<String> operations = new ArrayList<String>();
    private ArrayList<String> responsibilities = new ArrayList<String>();
    private ArrayList<Connection> connections = new ArrayList<Connection>();
    private ArrayList<Element> innerElements = new ArrayList<Element>();
    private int startLevel;
    private int endLevel;
    private int terminantionLevel;
    private String notes;

    protected Element(String eIdentifier, String eType, String eDescription, ArrayList<String> eAttributes, ArrayList<String> eOperations, ArrayList<String> eResponsibilities, ArrayList<Connection> eConnections, ArrayList<Element> eInnerElements, int eStartLevel, int eEndLevel, int eTerminantionLevel, String eNotes)
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
    }

    protected Element(String nextElementId, String eType)
    {
        identifier = nextElementId;
        type = eType;
        attributes = new ArrayList<String>();
        operations = new ArrayList<String>();
        responsibilities = new ArrayList<String>();
        connections = new ArrayList<Connection>();
        innerElements = new ArrayList<Element>();
    }

    String getIdentifier()
    {
        return identifier;
    }

    protected String getType()
    {
        return type;
    }

    protected ArrayList<String> getOperation()
    {
        return operations;
    }

    protected ArrayList<String> getAttributes()
    {
        return attributes;
    }

    protected ArrayList<String> getResponsibilities()
    {
        return responsibilities;
    }

    protected ArrayList<Connection> getConnections()
    {
        return connections;
    }

    protected ArrayList<Element> getInnerElements()
    {
        return innerElements;
    }

    protected String getNotes()
    {
        return notes;
    }

    protected int getterminationLevel()
    {
        return terminantionLevel;
    }

    protected int getEndLevel()
    {
        return endLevel;
    }

    protected int getStartLevel()
    {
        return startLevel;
    }

    protected String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        String temp = getIdentifier() + " : " + getDescription();
        return temp;
    }

    protected void setOperations(ArrayList<String> operationsList)
    {
        operations = operationsList;
    }

    protected void setAttributes(ArrayList<String> attributesList)
    {
        attributes = attributesList;
    }

    protected void setResponsibilities(ArrayList<String> responsibilitiesList)
    {
        responsibilities = responsibilitiesList;
    }

    protected void setType(String nType)
    {
        type = nType;
    }

    protected void setDescription(String nDescription)
    {
        description = nDescription;
    }

    protected void setStartLevel(int nStartLevel)
    {
        startLevel = nStartLevel;
    }

    protected void setEndLevel(int nEndLevel)
    {
        endLevel = nEndLevel;
    }

    protected void setTerminationLevel(int nTerminationLevel)
    {
        terminantionLevel = nTerminationLevel;
    }

    protected void setNotes(String nNotes)
    {
        notes = nNotes;
    }

    protected void addConnection(Connection activeConnection)
    {
        connections.add(activeConnection);
    }
}
