/*
 * Main controller class contains the functionality behind  the interface for the program.
 */
package finalproject;

import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    private FileNameExtensionFilter filter;
    private String pathLoadedModel;
    private ElementGUI uiPanel;
    private JFrame connectionFrame;

    /**
     * Constructor for MainController class
     */
    protected MainController()
    {
        modelController = new ModelController();
        filter = new FileNameExtensionFilter(
                "JavaScript Object Notation", "json");
    }

    /**
     * Get function for Object array of supported models, uses the getDiagrams()
     * function of the ModelController class
     *
     * @return an Object array of supported models
     */
    protected Object[] getSupportedModels()
    {
        return modelController.getDiagrams();
    }

    /**
     * Get function for TreeList of Strings reflecting the allowed element types
     * based on the model type, uses the getElements() function of the
     * ModelController class
     *
     * @return an String TreeList of allowed element types based on the model
     * type
     */
    protected TreeSet<String> getAllowedElements()
    {
        return modelController.getElements(activeModel.getModelType());
    }

    /**
     * Get function for TreeList of Strings reflecting the allowed connections
     * types based on the model type, uses the getConnection() function of the
     * ModelController class
     *
     * @return an String TreeList of allowed connection types based on the model
     * type
     */
    protected TreeSet<String> getAllowedConnections()
    {
        return modelController.getConnection(activeModel.getModelType());
    }

    /**
     * Get function for the active model
     *
     * @return the active model
     */
    protected Model getModel()
    {
        return activeModel;
    }

    /**
     * Set function for a new model of the given type
     *
     * @param s String reflecting the model type
     */
    protected void newModel(String s)
    {
        Model n = new Model(s);
        activeModel = n;
    }

    /**
     * Set function for a loaded existing model
     *
     * @param type String reflecting the type of the model
     * @param present boolean reflecting if elements aare present within the
     * model, true for yes false for none.
     * @param existingE ArrayList of Elements containing the top elements within
     * the model which contain all the remaining elements and connections
     * @param existingL ArrayList of Strings containing the relative paths to
     * model files that were linked to the model as a whole
     */
    protected void existingModel(String type, boolean present, ArrayList<Element> existingE, ArrayList<String> existingL)
    {
        Model n = new Model(type, present, existingE, existingL);
        activeModel = n;
        loadAllInstances();
        linkModelConnections();
    }

    /**
     * Links the connections to the actual element object instances based on the
     * element ID.
     */
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

    /**
     * Creates/updates ArrayList containing all the different elements
     * (allElements) and connections (allConnections) contained within the
     * model, including inner elements and their connections. Uses the
     * loadAllInnerElements() function to add all the inner elements
     */
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
    }

    /**
     * Function that adds the inner elements of an element to the ArraList
     * allElements Recursive function
     *
     * @param tempElement element of which gets checked for inner elements to be
     * checked and added *
     */
    private void loadAllInnerElements(Element tempElement)
    {
        for (Element tempInnerElement : tempElement.getInnerElements())
        {
            allElements.add(tempInnerElement);
            loadAllInnerElements(tempInnerElement);
        }
    }

    /**
     * returns the Element UI reflecting the current active model.
     *
     * @return an update ElementGUI based on the current active model within the
     * mainController
     */
    protected ElementGUI updateUI()
    {
        uiPanel = new ElementGUI(this);
        return uiPanel;
    }

    /**
     * Get function for all elements within the model.
     *
     * @return ArrayList of Elements containing all individual Element objects
     * within the model
     */
    protected ArrayList<Element> getElements()
    {
        return allElements;
    }

    /**
     * Looks for an Element within all elements in the model based on the given
     * element ID.
     *
     * @param lookup String containing the element ID
     * @return null if the element is not found or the Element object instance
     * if it is found.
     */
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

    /**
     * Looks for an Connection within all Connections in the model based on the
     * given connection ID.
     *
     * @param connectionID String containing the connection ID
     * @return null if the connection is not found or the Connection object
     * instance if it is found.
     */
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

    /**
     * Looks for the next available unique Connection ID within the model
     *
     * @return a unique, within the model, Connection ID.
     */
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

    /**
     * Looks for the next available unique Element ID within the model
     *
     * @return a unique, within the model, Element ID.
     */
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

    /**
     * Loads the model from the given fileScanner. Calls the loadElement()
     * function to load the elements and adds them to the ArrayList of elements
     *
     * @param fileScanner filScanner containing the file to be loaded.
     * @param path path of the file to be loaded.
     */
    protected void loadEModel(Scanner fileScanner, String path)
    {
        pathLoadedModel = path.replace("\\", "/");;
        String type = null;
        boolean existing = false;
        ArrayList<Element> existingE = new ArrayList<Element>();
        ArrayList<String> existingLinks = new ArrayList<String>();

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
                        temp = fileScanner.nextLine().trim();
                        if (temp.startsWith("{"))
                        {
                            existingE.add(loadElement(fileScanner));
                        }
                        else if (temp.startsWith("\"linked models\":  ["))
                        {
                            temp = fileScanner.nextLine().trim();
                            while (temp.startsWith("],") == false)
                            {
                                temp = temp.substring(1, (temp.length() - 2));
                                existingLinks.add(temp);
                                temp = fileScanner.nextLine().trim();
                            }
                        }
                    }
                }
                else
                {

                }

            }

            this.existingModel(type, existing, existingE, existingLinks);
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

    /**
     * Loads an Element within the file being loaded to the model. Recursive for
     * inner elements. Uses the loadConnection function to load the connections
     * within the element.
     *
     * @param fileScanner ileScanner with the file being loaded.
     * @return Element that is getting loaded.
     */
    private Element loadElement(Scanner fileScanner)
    {
        String identifier = null;
        String type = null;
        String description = null;
        ArrayList<String> attributes = new ArrayList<String>();
        ArrayList<String> operations = new ArrayList<String>();
        ArrayList<String> responsibilities = new ArrayList<String>();
        ArrayList<String> linkedModels = new ArrayList<String>();
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
                else if (line.startsWith("\"linked models\": [") == true)
                {
                    while (line.equals("],") == false)
                    {
                        line = fileScanner.nextLine().trim();
                        if (line.equals("],") == false && line.length() > 3)
                        {
                            linkedModels.add(line.substring(1, (line.length() - 2)));
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
                System.out.println("Line end element: " + line);
            }
        }

        Element tempElement = new Element(identifier, type, description, attributes, operations, responsibilities, connections, innerElements, startLevel, endLevel, terminantionLevel, notes, linkedModels);
        return tempElement;
    }

    /**
     * Loads a connection within the file being loaded to the model.
     *
     * @param fileScanner fileScanner with the file being loaded.
     * @return Connection to be loaded.
     */
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
        ArrayList<String> linkedModels = new ArrayList<String>();
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
            else if (line.startsWith("\"type\":") == true)
            {
                cType = line.substring(7, line.length()).trim();
                cType = cType.substring(1, (cType.length() - 2));
            }
            else if (line.startsWith("\"top center\":") == true)
            {
                cTopCenter = line.substring(13, line.length()).trim();
                cTopCenter = cTopCenter.substring(1, (cTopCenter.length() - 2));
            }
            else if (line.startsWith("\"bottom center\":") == true)
            {
                cBottomCenter = line.substring(16, line.length()).trim();
                cBottomCenter = cBottomCenter.substring(1, (cBottomCenter.length() - 2));
            }
            else if (line.startsWith("\"description start\":") == true)
            {
                cDescriptionStart = line.substring(20, line.length()).trim();
                cDescriptionStart = cDescriptionStart.substring(1, (cDescriptionStart.length() - 2));
            }
            else if (line.startsWith("\"multiplicity start\":") == true)
            {
                cMultiplicityStart = line.substring(21, line.length()).trim();
                cMultiplicityStart = cMultiplicityStart.substring(1, (cMultiplicityStart.length() - 2));
            }
            else if (line.startsWith("\"description end\":") == true)
            {
                cDescriptionEnd = line.substring(18, line.length()).trim();
                cDescriptionEnd = cDescriptionEnd.substring(1, (cDescriptionEnd.length() - 2));
            }
            else if (line.startsWith("\"multiplicity end\":") == true)
            {
                cMultiplicityEnd = line.substring(19, line.length()).trim();
                cMultiplicityEnd = cMultiplicityEnd.substring(1, (cMultiplicityEnd.length() - 2));
            }
            else if (line.startsWith("\"end element\":") == true)
            {
                cEndElement = line.substring(14, line.length()).trim();
                cEndElement = cEndElement.substring(1, (cEndElement.length() - 2));
            }
            else if (line.startsWith("\"level\":") == true)
            {
                String temp = line.substring(8, line.length()).trim();
                temp = temp.substring(0, (temp.length() - 1));
                cLevel = Integer.parseInt(temp);
            }
            else if (line.startsWith("\"notes\":") == true)
            {
                cNotes = line.substring(8, line.length()).trim();
                cNotes = cNotes.substring(1, (cNotes.length() - 2));
            }
            else if (line.startsWith("\"linked models\": [") == true)
            {
                while (line.equals("],") == false)
                {
                    line = fileScanner.nextLine().trim();
                    if (line.equals("],") == false && line.length() > 3)
                    {
                        linkedModels.add(line.substring(1, (line.length() - 2)));
                    }
                }
            }
        }

        Connection tempConnection = new Connection(cIdentifier, cType, cTopCenter, cBottomCenter, cDescriptionStart, cMultiplicityStart, cDescriptionEnd, cMultiplicityEnd, cEndElement, cLevel, cNotes, linkedModels);
        return tempConnection;
    }

    /**
     * Saves the model to the selected file Uses saveElement function to save
     * the elements within the model.
     *
     * @param selectedFile
     */
    protected void savingModel(File selectedFile)
    {
        pathLoadedModel = selectedFile.getParent().replace("\\", "/");;
        Writer fileWriter = null;
        try
        {
            fileWriter = new BufferedWriter(new FileWriter(selectedFile));
            fileWriter.write("{\n");
            fileWriter.write("\"model type\": \"" + activeModel.getModelType() + "\",\n");
            fileWriter.write("\"elements\": [\n");
            for (Element temporaryElement : activeModel.getElements())
            {
                saveElement(temporaryElement, fileWriter);
            }
            fileWriter.write("],\n");
            fileWriter.write("\"linked models\": [\n");
            for (String path : activeModel.getLinkedModels())
            {
                fileWriter.write("\"" + path + "\",\n");
            }
            fileWriter.write("],\n");
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

    /**
     * Saves the element via the given writer into the file Recursive for inner
     * elements Uses the saveConnection() to save the connections within the
     * element
     *
     * @param temporaryElement element to be saved
     * @param tempWriter FileWriter with the file that the model is getting
     * saved to
     */
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
            tempWriter.write("\"linked models\": [\n");
            for (String path : temporaryElement.getLinkedModels())
            {
                tempWriter.write("\"" + path + "\",\n");
            }
            tempWriter.write("],\n");
            tempWriter.write("},\n");

        }
        catch (IOException ex)
        {
            Logger.getLogger(MainMenu.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Saves the connection via the given writer into the file
     *
     * @param tempConnection connection to be saved
     * @param tempWriter FileWriter with the file that the model is getting
     * saved to
     */
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
            tempWriter.write("\"linked models\": [\n");
            for (String path : tempConnection.getLinkedModels())
            {
                tempWriter.write("\"" + path + "\",\n");
            }
            tempWriter.write("],\n");
            tempWriter.write("},\n");

        }
        catch (IOException ex)
        {
            Logger.getLogger(MainMenu.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retrieves the connection or element ID based on the description (as shown
     * in a box)
     *
     * @param boxID String containing the element or connection description from
     * a box.
     * @return String containing the ID of the connection or element ID based on
     * the input.
     */
    protected String getIDFromBox(String boxID)
    {
        int split = boxID.indexOf(" : ");
        boxID = boxID.substring(0, split);
        return boxID;
    }

    /**
     * Removes based on the given element ID an element and any existing
     * connections to an from that element from the model.
     *
     * @param elementIDToBeRemoved String of the element to be removed
     */
    protected void removeElement(String elementIDToBeRemoved)
    {
        for (Element temp : allElements)
        {
            if (temp.getConnections().size() > 0)
            {
                int i = 0;
                while (temp.getConnections().size() > i)
                {
                    Connection connection = temp.getConnections().get(i);
                    if (connection.getEndElementID().equals(elementIDToBeRemoved) == true)
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
            if (activeModel.getElements().size() == 0)
            {
                activeModel.setElementPresent(false);
            }
        }
        else
        {
            removeInnerElement(elementIDToBeRemoved);
        }
        loadAllInstances();
    }

    /**
     * Removes an inneerElement from an element based on the given element ID.
     *
     * @param innerElementIDToBeRemoved ID of inner element to be removed
     */
    private void removeInnerElement(String innerElementIDToBeRemoved)
    {
        Element innerElementToBeRemoved = findElement(innerElementIDToBeRemoved);
        findParentElement(innerElementToBeRemoved);
        parentElement.getInnerElements().remove(innerElementToBeRemoved);
    }

    /**
     * Finds and sets the parent element of the given child element.
     *
     * @param childElementBeFound
     */
    private void findParentElement(Element childElementBeFound)
    {
        parentElement = null;
        for (Element temp : activeModel.getElements())
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

    /**
     * Searches an ArrayList of Element for the given element within their inner
     * elements
     *
     * @param parentElements ArryList of elements of which the inner elements
     * will be searched
     * @param childElementBeFound element to be found.
     */
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

    /**
     * Adds and element to the model.
     *
     * @param selectedElement element to be added
     */
    protected void addElement(Element selectedElement)
    {
        activeModel.getElements().add(selectedElement);
        if (activeModel.getElementPresent() == false)
        {
            activeModel.setElementPresent(true);
        }
        loadAllInstances();
    }

    /**
     * Returns the .json filename extension filter.
     *
     * @return filter
     */
    protected FileNameExtensionFilter getJSONfilter()
    {
        return filter;
    }

    /**
     * Returns the relative path between the linked file and the file containing
     * the active model.
     *
     * @param linkedFile file that needs to be linked.
     * @return null in case the model hasn't been saved yet otherwise returns a
     * String containing the relative path between the linked file and the
     * active models file.
     */
    protected String getRelativePath(File linkedFile)
    {
        if (pathLoadedModel != null)
        {
            String relativePath = "./";
            String linkedFilePath = linkedFile.getParent().replace("\\", "/");
            if (linkedFile.getParent().equals(pathLoadedModel))
            {
                return relativePath;
            }
            else
            {

                String[] linkedFileSplit = linkedFilePath.split("/");
                String[] loadedFileSplit = pathLoadedModel.split("/");
                int i = 0;
                boolean diverge = false;
                while (i < loadedFileSplit.length && i < linkedFileSplit.length)
                {
                    if (loadedFileSplit[i].equals(linkedFileSplit[i]) == false)
                    {
                        diverge = true;
                    }
                    if (diverge == true)
                    {
                        relativePath = "../" + relativePath + linkedFileSplit[i] + "/";
                    }
                    i++;
                }
                int x = i;
                while (x < loadedFileSplit.length)
                {
                    relativePath = "../" + relativePath;
                    x++;
                }
                while (i < linkedFileSplit.length)
                {
                    relativePath = relativePath + linkedFileSplit[i] + "/";
                    i++;
                }
            }
            String path = relativePath + linkedFile.getName();
            return path;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You need to save the model to a file before you can add linked models.");

            return null;
        }
    }

    /**
     * Adds a linked model to the active model.
     *
     * @param path String with the relative path to the file that will be linked
     * to the model.
     */
    protected void addLinkedModel(String path)
    {
        activeModel.getLinkedModels().add(path);
    }

    /**
     * Loads the linked file
     *
     * @param relativePathLinkedModel relative path of the file that needs to be
     * linked.
     */
    protected void loadLinkedModel(String relativePathLinkedModel)
    {
        File linkedModel = new File(pathLoadedModel + "/" + relativePathLinkedModel);
        if (linkedModel.exists())
        {
            try
            {
                Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(linkedModel)));
                System.out.println("test: " + linkedModel.getParent());
                loadEModel(fileScanner, linkedModel.getParent());
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Save the model to the selected file.
     */
    protected void saveChanges()
    {
        File jsonFile = null;
        String path = null;
        JFileChooser saveFileChooser = new JFileChooser();
        saveFileChooser.setFileFilter(filter);
        saveFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //opens the file selection pane and sets the file path
        int returnValue = saveFileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            if (saveFileChooser.getSelectedFile().getPath() == null)
            {

            }
            else if (saveFileChooser.getSelectedFile().getPath().toLowerCase().endsWith(".json"))
            {
                path = saveFileChooser.getSelectedFile().getPath();
            }
            else
            {
                path = saveFileChooser.getSelectedFile().getPath() + ".json";
            }
            jsonFile = new File(path);
            if (jsonFile.exists() == true)
            {
                savingModel(jsonFile);
            }
            else
            {
                savingModel(jsonFile);
            }
        }
    }

    /**
     * Closes the connection frame.
     */
    protected void closeConnection()
    {
        connectionFrame.dispatchEvent(new WindowEvent(connectionFrame, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Opens a connectionGUI for an existing connection
     *
     * @param connectionID String matching the ID of the connection that needs to be opened.
     */
    protected void editConnection(String connectionID)
    {
        Connection connection = findConnection(connectionID);
        if (connection != null)
        {
            connectionFrame = new JFrame();
            ConnectionGUI connectionGUI = new ConnectionGUI(connection, this);
            connectionFrame.add(connectionGUI);
            connectionFrame.pack();
            connectionFrame.setVisible(true);
        }
    }

    /**
     * Opens a connectionGUI for an new connection
     * 
     * @param selectedElement element the connection originates from.
     */
    protected void createNewConnection(Element selectedElement)
    {
        if (connectionFrame == null || connectionFrame.isVisible() == false)
        {
            connectionFrame = new JFrame();
            ConnectionGUI connectionGUI = new ConnectionGUI(selectedElement, this);
            connectionFrame.add(connectionGUI);
            connectionFrame.pack();
            connectionFrame.setVisible(true);
        }
    }
}
