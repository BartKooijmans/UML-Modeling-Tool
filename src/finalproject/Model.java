/*
 * Model Class containing the data structure for the model
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Bart Kooijmans
 */
public class Model
{
    private String modelType;
    private boolean elementPresent;
    private ArrayList<Element> elements;
    private ArrayList<String> linkedModels;

    /**
     * Constructor for an empty model of the given type.
     * 
     * @param type String representing the type of the model to be created, values are limited to the list generated y the ModelController class
     */
    protected Model(String type)
    {
        modelType = type;
        elementPresent = false;
        elements = new ArrayList<Element>();
        linkedModels = new ArrayList<String>();
    }

    /**
     * Contructor for the model class for an existing model
     * 
     * @param type String representing the type of the model to be created, values are limited to the list generated y the ModelController class
     * @param present boolean representing if elements are present within the model (Would normally always be true for existing models)
     * @param existingE ArrayList of elements representing the models primary elements of the model (These contain all the connection and inner elements within it)
     * @param existingModels Arraylist of Stringa containing the relative path to linked models
     */
    protected Model(String type, boolean present, ArrayList<Element> existingE, ArrayList<String> existingModels)
    {
        modelType = type;
        elementPresent = present;
        elements = existingE;
        linkedModels = existingModels;
    }
    
    /**
     * Standard get function for the boolean representing if elements are present within the model
     * 
     * @return boolean elementPresent
     */
    protected boolean getElementPresent()
    {
        return elementPresent;
    }
    
    /**
     * Returns the string containing/representing the type of the model.
     * 
     * @return String modelType
     */
    protected String getModelType()
    {
        return modelType;
    }

    /**
     * Returns an ArrayList of the Element object instance that make up the model, top level elements all other elements and connections are contained within these.
     * 
     * @return ArrayList of Element instances elements
     */
    protected ArrayList<Element> getElements()
    {
        return elements;
    }

    /**
     * Set method for elementPresent which is the boolean representing if elements are present (true) or not (false) 
     * 
     * @param updatedStatus 
     */
    protected void setElementPresent(boolean updatedStatus)
    {
        elementPresent = updatedStatus;
    }
    
    /**
     * Return an ArrayList of string containing the relative path to all models linked to this model as a whole
     * 
     * @return ArryList of Strings linkedModels
     */    
    protected ArrayList<String> getLinkedModels()
    {
        return linkedModels;
    }
}
