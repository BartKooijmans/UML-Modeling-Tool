/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Bart Kooijmans
 */
public class MainController
{

    private ModelController modelController;
    private ArrayList<Element> allElements = new ArrayList<Element>();
    private ArrayList<Connection> allConnections = new ArrayList<Connection>();
    private Element parentElement;
    private Model activeModel;

    protected MainController()
    {
        modelController = new ModelController();
    }

    protected Object[] getSupportedModels()
    {
        return modelController.getDiagrams();
    }

    protected TreeSet<String> getAllowedElements()
    {
        return modelController.getElements(activeModel.getModelType());
    }

    protected TreeSet<String> getAllowedConnections()
    {
        return modelController.getConnection(activeModel.getModelType());
    }

    protected Model getModel()
    {
        return activeModel;
    }

    protected void newModel(String s)
    {
        Model n = new Model(s);
        activeModel = n;
    }

    protected void existingModel(String type, boolean present, ArrayList<Element> existingE)
    {
        Model n = new Model(type, present, existingE);
        activeModel = n;
        loadAllInstances();
        linkModelConnections();
    }

    private void linkModelConnections()
    {
        for (Connection tempConnection : allConnections)
        {
            for (Element tempElement : allElements)
            {
                if (tempElement.getIdentifier().equals(tempConnection.getEndElementID()))
                {
                    tempConnection.setEndElement(tempElement);
                }
            }
        }
    }

    protected void loadAllInstances()
    {
        allElements.clear();
        allConnections.clear();
        for (Element tempElement : activeModel.getElements())
        {
            allElements.add(tempElement);
            loadAllInnerElements(tempElement);
        }
        for (Element tempElement2 : allElements)
        {
            allConnections.addAll(tempElement2.getConnections());
        }
        for (Element tempElement : allElements)
        {
            System.out.println(tempElement.toString());
        }
    }

    private void loadAllInnerElements(Element tempElement)
    {
        for (Element tempInnerElement : tempElement.getInnerElements())
        {
            allElements.add(tempInnerElement);
            loadAllInnerElements(tempInnerElement);
        }
    }

    protected JPanel updateUI()
    {
        JPanel uiPanel = new ElementGUI(this);
        return uiPanel;
    }

    protected ArrayList<Element> getElements()
    {
        return allElements;
    }

    protected Element findElement(String lookup)
    {
        for (Element search : allElements)
        {
            if (search.getIdentifier().equals(lookup))
            {
                return search;
            }
        }
        return null;
    }

    protected Connection findConnection(String connectionID)
    {
        for (Connection search : allConnections)
        {
            if (search.getIdentifier().equals(connectionID))
            {
                return search;
            }
        }
        return null;
    }

    protected String findNextAvailableConnectionID()
    {
        int i = 0;
        boolean foundFree = false;
        String lookup = "c" + i;
        while (foundFree == false)
        {
            if (findConnection(lookup) == null)
            {
                foundFree = true;
            }
            else
            {
                i++;
                lookup = "c" + i;
            }
        }
        return lookup;
    }

    protected String findNextAvailableElementID()
    {
        int i = 0;
        boolean foundFree = false;
        String lookup = "e" + i;
        while (foundFree == false)
        {
            if (findElement(lookup) == null)
            {
                foundFree = true;
            }
            else
            {
                i++;
                lookup = "e" + i;
            }
        }
        return lookup;
    }

    protected void loadEModel(Scanner fileScanner)
    {
        String type = null;
        boolean existing = false;
        ArrayList<Element> existingE = new ArrayList<Element>();

        try
        {
            String temp;
            if (fileScanner.hasNextLine())
            {
                temp = fileScanner.nextLine();
                temp = fileScanner.nextLine().trim();
                if (temp.startsWith("\"model type\":"))
                {
                    type = temp.substring(13, temp.length()).trim();
                    type = type.substring(1, (type.length() - 2));
                }
                temp = fileScanner.nextLine().trim();
                temp = fileScanner.nextLine().trim();
                if (temp.equals("{"))
                {
                    existing = true;
                    existingE.add(loadElement(fileScanner));
                    while (fileScanner.hasNextLine())
                    {
                        if (fileScanner.nextLine().startsWith("{"))
                        {
                            existingE.add(loadElement(fileScanner));
                        }
                    }
                }
                else
                {
                    temp = fileScanner.nextLine().trim();
                }

            }

            this.existingModel(type, existing, existingE);
        }
        catch (Exception aException)
        {
            System.out.println("Error while trying to read file: " + aException);
        }
        finally
        {
            try
            {
                fileScanner.close();
            }
            catch (Exception aException)
            {
                System.out.println("Error while closing file: " + aException);
            }
        }
    }

    private Element loadElement(Scanner fileScanner)
    {
        String identifier = null;
        String type = null;
        String description = null;
        ArrayList<String> attributes = new ArrayList<String>();
        ArrayList<String> operations = new ArrayList<String>();
        ArrayList<String> responsibilities = new ArrayList<String>();
        ArrayList<Connection> connections = new ArrayList<Connection>();
        ArrayList<Element> innerElements = new ArrayList<Element>();
        int startLevel = 0;
        int endLevel = 0;
        int terminantionLevel = 0;
        String notes = null;
        String line = "";
        if (fileScanner.hasNextLine())
        {
            while (line.equals("},") == false)
            {
                if (line.startsWith("\"identifier\":") == true)
                {
                    identifier = line.substring(13, line.length()).trim();
                    identifier = identifier.substring(1, (identifier.length() - 2));
                }
                else if (line.startsWith("\"type\":") == true)
                {
                    type = line.substring(7, line.length()).trim();
                    type = type.substring(1, (type.length() - 2));
                }
                else if (line.startsWith("\"description\":") == true)
                {
                    description = line.substring(14, line.length()).trim();
                    description = description.substring(1, (description.length() - 2));
                }
                else if (line.startsWith("\"attributes\": [") == true)
                {
                    while (line.equals("],") == false)
                    {
                        line = fileScanner.nextLine().trim();
                        if (line.equals("],") == false && line.length() > 3)
                        {
                            attributes.add(line.substring(1, (line.length() - 2)));
                        }
                    }
                }
                else if (line.startsWith("\"operations\": [") == true)
                {
                    while (line.equals("],") == false)
                    {
                        line = fileScanner.nextLine().trim();
                        if (line.equals("],") == false && line.length() > 3)
                        {
                            operations.add(line.substring(1, (line.length() - 2)));
                        }
                    }
                }
                else if (line.startsWith("\"responsibilities\": [") == true)
                {
                    while (line.equals("],") == false)
                    {
                        line = fileScanner.nextLine().trim();
                        if (line.equals("],") == false && line.length() > 3)
                        {
                            responsibilities.add(line.substring(1, (line.length() - 2)));
                        }
                    }
                }
                else if (line.startsWith("\"connections\": [") == true)
                {
                    while (line.equals("],") == false)
                    {
                        line = fileScanner.nextLine().trim();
                        if (line.startsWith("{"))
                        {
                            connections.add(loadConnection(fileScanner));
                        }
                    }
                }
                else if (line.startsWith("\"inner elements\": [") == true)
                {
                    while (line.equals("],") == false)
                    {
                        line = fileScanner.nextLine().trim();
                        if (line.startsWith("{"))
                        {
                            innerElements.add(loadElement(fileScanner));
                        }
                    }
                }
                else if (line.startsWith("\"start level\":") == true)
                {
                    startLevel = Integer.parseInt(line.substring(14, (line.length() - 1)).trim());
                }
                else if (line.startsWith("\"end level\":") == true)
                {
                    endLevel = Integer.parseInt(line.substring(12, (line.length() - 1)).trim());
                }
                else if (line.startsWith("\"termination level\":") == true)
                {
                    terminantionLevel = Integer.parseInt(line.substring(20, (line.length() - 1)).trim());
                }
                else if (line.startsWith("\"notes\":") == true)
                {
                    notes = line.substring(8).trim();
                    notes = notes.substring(1, (notes.length() - 2));
                }
                line = fileScanner.nextLine().trim();
            }
        }

        Element tempElement = new Element(identifier, type, description, attributes, operations, responsibilities, connections, innerElements, startLevel, endLevel, terminantionLevel, notes);
        return tempElement;
    }

    private Connection loadConnection(Scanner fileScanner)
    {
        String cIdentifier = null;
        String cType = null;
        String cTopCenter = null;
        String cBottomCenter = null;
        String cDescriptionStart = null;
        String cMultiplicityStart = null;
        String cDescriptionEnd = null;
        String cMultiplicityEnd = null;
        String cEndElement = null;
        int cLevel = 0;
        String cNotes = null;
        String line = " ";
        while (line.equals("},") == false)
        {
            line = fileScanner.nextLine().trim();
            if (line.startsWith("\"identifier\":") == true)
            {
                cIdentifier = line.substring(13, line.length()).trim();
                cIdentifier = cIdentifier.substring(1, (cIdentifier.length() - 2));
            }
            if (line.startsWith("\"type\":") == true)
            {
                cType = line.substring(7, line.length()).trim();
                cType = cType.substring(1, (cType.length() - 2));
            }
            if (line.startsWith("\"top center\":") == true)
            {
                cTopCenter = line.substring(13, line.length()).trim();
                cTopCenter = cTopCenter.substring(1, (cTopCenter.length() - 2));
            }
            if (line.startsWith("\"bottom center\":") == true)
            {
                cBottomCenter = line.substring(16, line.length()).trim();
                cBottomCenter = cBottomCenter.substring(1, (cBottomCenter.length() - 2));
            }
            if (line.startsWith("\"description start\":") == true)
            {
                cDescriptionStart = line.substring(20, line.length()).trim();
                cDescriptionStart = cDescriptionStart.substring(1, (cDescriptionStart.length() - 2));
            }
            if (line.startsWith("\"multiplicity start\":") == true)
            {
                cMultiplicityStart = line.substring(21, line.length()).trim();
                cMultiplicityStart = cMultiplicityStart.substring(1, (cMultiplicityStart.length() - 2));
            }
            if (line.startsWith("\"description end\":") == true)
            {
                cDescriptionEnd = line.substring(18, line.length()).trim();
                cDescriptionEnd = cDescriptionEnd.substring(1, (cDescriptionEnd.length() - 2));
            }
            if (line.startsWith("\"multiplicity end\":") == true)
            {
                cMultiplicityEnd = line.substring(19, line.length()).trim();
                cMultiplicityEnd = cMultiplicityEnd.substring(1, (cMultiplicityEnd.length() - 2));
            }
            if (line.startsWith("\"end element\":") == true)
            {
                cEndElement = line.substring(14, line.length()).trim();
                cEndElement = cEndElement.substring(1, (cEndElement.length() - 2));
            }
            if (line.startsWith("\"level\":") == true)
            {
                String temp = line.substring(8, line.length()).trim();
                temp = temp.substring(0, (temp.length() - 1));
                cLevel = Integer.parseInt(temp);
            }
            if (line.startsWith("\"notes\":") == true)
            {
                cNotes = line.substring(8, line.length()).trim();
                cNotes = cNotes.substring(1, (cNotes.length() - 2));
            }
        }

        Connection tempConnection = new Connection(cIdentifier, cType, cTopCenter, cBottomCenter, cDescriptionStart, cMultiplicityStart, cDescriptionEnd, cMultiplicityEnd, cEndElement, cLevel, cNotes);
        return tempConnection;
    }

    protected void savingModel(Model activeModel, File selectedFile)
    {
        Writer fileWriter = null;
        try
        {
            fileWriter = new BufferedWriter(new FileWriter(selectedFile));
            fileWriter.write("{\n");
            fileWriter.write("\"model type\": \"" + activeModel.getModelType() + "\",\n");
            fileWriter.write("\"elements\":  [\n");
            for (Element temporaryElement : activeModel.getElements())
            {
                saveElement(temporaryElement, fileWriter);
            }
            fileWriter.write("]\n");
            fileWriter.write("}");
        }
        catch (IOException ex)
        {

        }
        finally
        {
            try
            {
                fileWriter.close();
            }
            catch (Exception aException)
            {
                System.out.println("Error while closing file: " + aException);
            }
        }

    }

    private void saveElement(Element temporaryElement, Writer tempWriter)
    {
        try
        {
            tempWriter.write("{\n");
            tempWriter.write("\"identifier\": \"" + temporaryElement.getIdentifier() + "\",\n");
            tempWriter.write("\"type\": \"" + temporaryElement.getType() + "\",\n");
            tempWriter.write("\"description\": \"" + temporaryElement.getDescription() + "\",\n");
            tempWriter.write("\"attributes\": [\n");
            for (String attribute : temporaryElement.getAttributes())
            {
                tempWriter.write("\"" + attribute + "\",\n");
            }
            tempWriter.write("],\n");
            tempWriter.write("\"operations\": [\n");
            for (String operation : temporaryElement.getOperation())
            {
                tempWriter.write("\"" + operation + "\",\n");
            }
            tempWriter.write("],\n");
            tempWriter.write("\"responsibilities\": [\n");
            for (String responsibility : temporaryElement.getResponsibilities())
            {
                tempWriter.write("\"" + responsibility + "\",\n");
            }
            tempWriter.write("],\n");
            tempWriter.write("\"connections\": [\n");
            for (Connection tempConnection : temporaryElement.getConnections())
            {
                saveConnection(tempConnection, tempWriter);
            }
            tempWriter.write("],\n");
            tempWriter.write("\"inner elements\": [\n");
            for (Element tempInnerElement : temporaryElement.getInnerElements())
            {
                saveElement(tempInnerElement, tempWriter);
            }
            tempWriter.write("],\n");
            tempWriter.write("\"start level\": " + temporaryElement.getStartLevel() + ",\n");
            tempWriter.write("\"end level\":" + temporaryElement.getEndLevel() + ",\n");
            tempWriter.write("\"termination level\": " + temporaryElement.getterminationLevel() + ",\n");
            tempWriter.write("\"notes\": \"" + temporaryElement.getNotes() + "\",\n");
            tempWriter.write("},\n");

        }
        catch (IOException ex)
        {
            Logger.getLogger(MainMenu.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveConnection(Connection tempConnection, Writer tempWriter)
    {
        try
        {
            tempWriter.write("{\n");
            tempWriter.write("\"identifier\": \"" + tempConnection.getIdentifier() + "\",\n");
            tempWriter.write("\"type\": \"" + tempConnection.getType() + "\",\n");
            tempWriter.write("\"top center\": \"" + tempConnection.getTopCenter() + "\",\n");
            tempWriter.write("\"bottom center\": \"" + tempConnection.getBottomCenter() + "\",\n");
            tempWriter.write("\"description start\": \"" + tempConnection.getDescriptionStart() + "\",\n");
            tempWriter.write("\"multiplicity start\": \"" + tempConnection.getMultiplicityStart() + "\",\n");
            tempWriter.write("\"description end\": \"" + tempConnection.getDescriptionEnd() + "\",\n");
            tempWriter.write("\"multiplicity end\": \"" + tempConnection.getMultiplicityEnd() + "\",\n");
            tempWriter.write("\"end element\": \"" + tempConnection.getEndElementID() + "\",\n");
            tempWriter.write("\"level\":" + tempConnection.getLevel() + ",\n");
            tempWriter.write("\"notes\": \"" + tempConnection.getNotes() + "\",\n");
            tempWriter.write("},\n");

        }
        catch (IOException ex)
        {
            Logger.getLogger(MainMenu.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected String getIDFromBox(String boxID)
    {
        int split = boxID.indexOf(" : ");
        boxID = boxID.substring(0, split);
        return boxID;
    }

    protected void removeElement(String elementIDToBeRemoved)
    {
        for(Element temp : allElements)
        {
            if (temp.getConnections().size() > 0)
            {
                int i = 0;
                while (temp.getConnections().size() > i)
                {
                    Connection connection = temp.getConnections().get(i);
                    if (connection.endElementID.equals(elementIDToBeRemoved) == true)
                    {
                        temp.getConnections().remove(connection);
                    }
                    else
                    {
                        i++;
                    }
                }
            }
        }
        Element elementToBeRemoved = findElement(elementIDToBeRemoved);
        if (activeModel.getElements().contains(elementToBeRemoved))
        {
            activeModel.getElements().remove(elementToBeRemoved);
        }
        else
        {
            removeInnerElement(elementIDToBeRemoved);
        }
        loadAllInstances();
    }

    private void removeInnerElement(String innerElementIDToBeRemoved)
    {
        Element innerElementToBeRemoved = findElement(innerElementIDToBeRemoved);
        findParentElement(innerElementToBeRemoved);
        parentElement.getInnerElements().remove(innerElementToBeRemoved);
    }

    private void findParentElement(Element childElementBeFound)
    {
        parentElement = null;
        for (Element temp : activeModel.elements)
        {
            if (temp.getInnerElements().size() > 0)
            {
                if (temp.getInnerElements().contains(childElementBeFound))
                {
                    parentElement = temp;
                }
                else
                {
                    searchInnerElement(temp.getInnerElements(), childElementBeFound);
                }
            }
        }
    }

    private void searchInnerElement(ArrayList<Element> parentElements, Element childElementBeFound)
    {
        for (Element temp : parentElements)
        {
            if (temp.getInnerElements().size() > 0)
            {
                if (temp.getInnerElements().contains(childElementBeFound))
                {
                    parentElement = temp;
                }
                else
                {
                    searchInnerElement(temp.getInnerElements(), childElementBeFound);
                }
            }
        }
    }
}
