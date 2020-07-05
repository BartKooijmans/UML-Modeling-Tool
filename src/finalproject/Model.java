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
    private String modelType;
    private boolean elementPresent;
    private ArrayList<Element> elements;
    

    protected Model(String type)
    {
        modelType = type;
        elementPresent = false;
        elements = new ArrayList<Element>();
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
    
    protected String getModelType()
    {
        return modelType;
    }

    protected ArrayList<Element> getElements()
    {
        return elements;
    }

    protected void setElementPresent(boolean updatedStatus)
    {
        elementPresent = updatedStatus;
    }
}
