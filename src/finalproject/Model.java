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
public class Model
{
    String modelType;
    boolean elementPresent;
    ArrayList<Element> elements;
    

    protected Model(String type)
    {
        modelType = type;
        elementPresent = false;
        elements = new ArrayList<Element>();
        addElement();
    }

    protected Model(String type, boolean present, ArrayList<Element> existingE)
    {
        modelType = type;
        elementPresent = present;
        elements = existingE;
    }
    
    protected boolean getElementPresent()
    {
        return elementPresent;
    }
    
    protected void addElement()
    {
//        Element newE = new Element();
//        elements.add(newE);
    }
    
    protected void editElement()
    {
        
    }
    
    protected void removeElement()
    {
        
    }
    
    protected void addConnection()
    {
        
    }
    
    protected void editConnection()
    {
        
    }
    
    protected void removeConnection()
    {
        
    }

    protected String getModelType()
    {
        return modelType;
    }

    protected ArrayList<Element> getElements()
    {
        return elements;
    }
}
