/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Bart Kooijmans
 */
public class Connection
{
    private String identifier;
    private String type;
    private String topCenter;
    private String bottomCenter;
    private String descriptionStart;
    private String multiplicityStart;
    private String descriptionEnd;
    private String multiplicityEnd;
    private String endElementID;
    private int level;
    private String notes;
    private Element endElement;

    protected Connection()
    {

    }

    protected Connection(String cIdentifier, String cType, String cTopCenter, String cBottomCenter, String cDescriptionStart, String cMultiplicityStart, String cDescriptionEnd, String cMultiplicityEnd, String cEndElement, int cLevel, String cNotes)
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
    }

    protected Connection(String cIdentifier, String cType, String cTopCenter, String cBottomCenter, String cDescriptionStart, String cMultiplicityStart, String cDescriptionEnd, String cMultiplicityEnd, Element cEndElement, int cLevel, String cNotes)
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
    }

    protected String getIdentifier()
    {
        return identifier;
    }

    protected String getType()
    {
        return type;
    }

    protected String getTopCenter()
    {
        return topCenter;
    }

    protected String getEndElementID()
    {
        return endElementID;
    }

    protected String getBottomCenter()
    {
        return bottomCenter;
    }

    protected String getDescriptionStart()
    {
        return descriptionStart;
    }

    protected String getMultiplicityStart()
    {
        return multiplicityStart;
    }

    protected String getDescriptionEnd()
    {
        return descriptionEnd;
    }

    protected String getMultiplicityEnd()
    {
        return multiplicityEnd;
    }

    protected int getLevel()
    {
        return level;
    }

    protected String getNotes()
    {
        return notes;
    }

    protected void setEndElement(Element tempElement)
    {
        endElement = tempElement;
        endElementID = tempElement.getIdentifier();
    }

    protected Element getEndElement()
    {
        return endElement;
    }

    protected void setEndMultiplicity(String endMulti)
    {
        multiplicityEnd = endMulti;
    }

    protected void setEndText(String endText)
    {
        descriptionEnd = endText;
    }

    protected void setLevel(int cLevel)
    {
        level = cLevel;
    }

    protected void setStartMultiplicity(String startMulti)
    {
        multiplicityStart = startMulti;
    }

    protected void setStartText(String startText)
    {
        descriptionStart = startText;
    }

    protected void setTopCenter(String topCenterText)
    {
        topCenter = topCenterText;
    }

    protected void setNotes(String cNotes)
    {
        notes = cNotes;
    }

    protected void setBottomCenter(String bottomCenterText)
    {
        bottomCenter = bottomCenterText;
    }

    protected void setID(String cIdentifier)
    {
        identifier = cIdentifier;
    }
    
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

    void setType(String cType)
    {
        type = cType;
    }
}
