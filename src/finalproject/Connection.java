/*
 * Connection component class
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Bart Kooijmans
 */
public class Connection
{
    private String identifier; //String containing unique connection ID
    private String type; //String representing connection type
    private String topCenter; //String text top center
    private String bottomCenter; //String text bottom center   
    private String descriptionStart; //String description at the start 
    private String multiplicityStart; //String mutiplicity at the start 
    private String descriptionEnd; //String description at the end
    private String multiplicityEnd; //String multiplicity at the end
    private String endElementID; //String containing the ID of the element the connection ends at
    private int level; //Int indicating the level of the connection
    private String notes; //String with notes connection
    private Element endElement; //Element the connection leads to/ends at
    private ArrayList<String> linkedModels; //ArrayList with strings containing the relative paths to files linked to the connection
    
    /**
     * Constructor for new Connection
     */
    protected Connection()
    {
        linkedModels = new ArrayList<String>();
    }

    /**
     * Constructor existing connection with the end element ID instead of the end element (used when loading a model).
     * 
     * @param cIdentifier String with the connection ID
     * @param cType String with connection type
     * @param cTopCenter String with text top center
     * @param cBottomCenter String with text bottom center
     * @param cDescriptionStart String with description
     * @param cMultiplicityStart String with the multiplicity at the start of the connection
     * @param cDescriptionEnd String with the description at the end of the connection
     * @param cMultiplicityEnd String with multiplicity at the end of the connection
     * @param cEndElement String with the ID of the end element
     * @param cLevel int with the level of the connection
     * @param cNotes String with notes of the connection
     * @param cLinkedModels ArrayList of Strings with relative paths to model files linked to the connection
     */
    protected Connection(String cIdentifier, String cType, String cTopCenter, String cBottomCenter, String cDescriptionStart, String cMultiplicityStart, String cDescriptionEnd, String cMultiplicityEnd, String cEndElement, int cLevel, String cNotes, ArrayList<String> cLinkedModels)
    {
        identifier = cIdentifier;
        type = cType;
        topCenter = cTopCenter;
        bottomCenter = cBottomCenter;
        descriptionStart = cDescriptionStart;
        multiplicityStart = cMultiplicityStart;
        descriptionEnd = cDescriptionEnd;
        multiplicityEnd = cMultiplicityEnd;
        endElementID = cEndElement;
        level = cLevel;
        notes = cNotes;
        linkedModels = cLinkedModels;
    }

    /**
     * Constructor existing connection with the end element instead of the end element ID (used when not loading a model).
     * 
     * @param cIdentifier String with the connection ID
     * @param cType String with connection type
     * @param cTopCenter String with text top center
     * @param cBottomCenter String with text bottom center
     * @param cDescriptionStart String with description
     * @param cMultiplicityStart String with the multiplicity at the start of the connection
     * @param cDescriptionEnd String with the description at the end of the connection
     * @param cMultiplicityEnd String with multiplicity at the end of the connection
     * @param cEndElement Element instance of the end element the end element of the connection
     * @param cLevel int with the level of the connection
     * @param cNotes String with notes of the connection
     * @param cLinkedModels ArrayList of Strings with relative paths to model files linked to the connection
     */
    protected Connection(String cIdentifier, String cType, String cTopCenter, String cBottomCenter, String cDescriptionStart, String cMultiplicityStart, String cDescriptionEnd, String cMultiplicityEnd, Element cEndElement, int cLevel, String cNotes, ArrayList<String> cLinkedModels)
    {
        identifier = cIdentifier;
        type = cType;
        topCenter = cTopCenter;
        bottomCenter = cBottomCenter;
        descriptionStart = cDescriptionStart;
        multiplicityStart = cMultiplicityStart;
        descriptionEnd = cDescriptionEnd;
        multiplicityEnd = cMultiplicityEnd;
        endElement = cEndElement;
        level = cLevel;
        notes = cNotes;
        endElementID = cEndElement.getIdentifier();
        linkedModels = cLinkedModels;
    }

    /**
     * Get method for identifier
     * 
     * @return String with connection unique ID
     */
    protected String getIdentifier()
    {
        return identifier;
    }

    /**
     * Get method for type
     * 
     * @return String with connection type
     */
    protected String getType()
    {
        return type;
    }

    /**
     * Get method for top center text
     * 
     * @return String with connection top center text
     */
    protected String getTopCenter()
    {
        return topCenter;
    }

    /**
     * Get method for end element ID
     * 
     * @return String with connection end element ID
     */
    protected String getEndElementID()
    {
        return endElementID;
    }

    /**
     * Get method for bottom center text
     * 
     * @return String with connection bottom center text
     */
    protected String getBottomCenter()
    {
        return bottomCenter;
    }

    /**
     * Get method for description at the start
     * 
     * @return String with connection description at the start
     */
    protected String getDescriptionStart()
    {
        return descriptionStart;
    }

    /**
     * Get method for type
     * 
     * @return String with connection type
     */
    protected String getMultiplicityStart()
    {
        return multiplicityStart;
    }

    /**
     * Get method for description at the end
     * 
     * @return String with connection description at the end
     */
    protected String getDescriptionEnd()
    {
        return descriptionEnd;
    }

    /**
     * Get method for multiplicity at the end
     * 
     * @return String with connection multiplicity at the end
     */
    protected String getMultiplicityEnd()
    {
        return multiplicityEnd;
    }

    /**
     * Get method for level
     * 
     * @return int with connection level
     */
    protected int getLevel()
    {
        return level;
    }

    /**
     * Get method for notes
     * 
     * @return String with connection notes
     */
    protected String getNotes()
    {
        return notes;
    }

    /**
     * Set method for end element
     * 
     * @param tempElement end element to be set also sets end Element ID to the ID of the given element
     */
    protected void setEndElement(Element tempElement)
    {
        endElement = tempElement;
        endElementID = tempElement.getIdentifier();
    }

    /**
     * Get method for end element
     * 
     * @return Element of the connection's end element
     */
    protected Element getEndElement()
    {
        return endElement;
    }

    /**
     * Set method for end multiplicity
     * 
     * @param endMulti String with end multiplicity
     */
    protected void setEndMultiplicity(String endMulti)
    {
        multiplicityEnd = endMulti;
    }

    /**
     * Set method for end text
     * 
     * @param endText String with text at the end
     */
    protected void setEndText(String endText)
    {
        descriptionEnd = endText;
    }

    /**
     * Set method for level
     * 
     * @param cLevel int with the end level
     */
    protected void setLevel(int cLevel)
    {
        level = cLevel;
    }

    /**
     * Set method for start multiplicity
     * 
     * @param startMulti String with start multiplicity
     */
    protected void setStartMultiplicity(String startMulti)
    {
        multiplicityStart = startMulti;
    }

    /**
     * Set method for start text
     * 
     * @param startText String with start text
     */
    protected void setStartText(String startText)
    {
        descriptionStart = startText;
    }

    /**
     * Set method for top center text
     * 
     * @param topCenterText String with top center text
     */
    protected void setTopCenter(String topCenterText)
    {
        topCenter = topCenterText;
    }

    /**
     * Set method for notes
     * 
     * @param cNotes String with notes
     */
    protected void setNotes(String cNotes)
    {
        notes = cNotes;
    }

    /**
     * Set method for bottom center text
     * 
     * @param bottomCenterText String with bottom center text
     */
    protected void setBottomCenter(String bottomCenterText)
    {
        bottomCenter = bottomCenterText;
    }

    /**
     * Set method for connection identifier
     * 
     * @param cIdentifier connection identifier
     */
    protected void setID(String cIdentifier)
    {
        identifier = cIdentifier;
    }
    
    /**
     * Overwritten method of toString
     * 
     * @return String with *connection id* : *end element ID and description* 
     */
    @Override
    public String toString()
    {
        String temp = getIdentifier() + " : ";
        if(endElement != null)
        {
            temp = temp + endElement.toString();
        }
        return temp;
    }

    /**
     * Set method for start type
     * 
     * @param cType String with connection type
     */
    protected void setType(String cType)
    {
        type = cType;
    }

     /**
     * Get method for linked models
     * 
     * @return ArrayList of Strings with relative paths to models linked to the connection
     */
    protected ArrayList<String> getLinkedModels()
    {
        return linkedModels;
    }
}
