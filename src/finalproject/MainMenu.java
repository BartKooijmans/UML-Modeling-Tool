/*
 * Main class of the UML modeling tool project starts the application and creates the main menu and relevant controller class.
 */
package finalproject;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Bart Kooijmans
 */
public class MainMenu
{

    /**
     * Main method that Starts the application
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MainMenu app = new MainMenu();
    }

    private boolean exit;
    private JMenuBar mainMenuBar;
    private JMenu mainMenu;
    private JPanel detailsPanel;
    private MainController mainController;
    //4 main menu items
    private JMenuItem start = new JMenuItem("new Model");
    private JMenuItem save = new JMenuItem("Save Model");
    private JMenuItem load = new JMenuItem("Load Model");
    private JMenuItem close = new JMenuItem("Exit");
    private JFrame mainFrame; // The main frame containg the different game elements.
    private JFileChooser saveFileChooser;

    //Array used to store the options for supported diagrams
    private Object[] supportedDiagrams;

    /**
     * Main constructor for the Main Menu class, creates and set the main menu and an empty main panel and initialises the main controller
     */
    protected MainMenu()
    {
        exit = false;
        detailsPanel = new JPanel();
        mainFrame = new JFrame();
        mainFrame.setJMenuBar(createMainMenu());
        mainFrame.setSize(320, 60); //Set the initial size of the menu
        mainFrame.setLocationByPlatform(true); //Sets the standard location of the mainFrame relative to the platform
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setTitle("UML Model Manager");
        mainController = new MainController();        
        saveFileChooser = new JFileChooser(); //File selector for loading and saving files
        saveFileChooser.setFileFilter(mainController.getJSONfilter()); //Sets the filter for the file selector to just displaying .json files.
        supportedDiagrams = mainController.getSupportedModels(); //Fills the array of supported models.
        startMenu();

    }

    /**
     * Returns the main menu.
     * 
     * @return Main menu bar with the 4 options, Start (new model), save (save model), load (load model), 
     */
    private JMenuBar createMainMenu()
    {
        mainMenuBar = new JMenuBar();
        mainMenu = new JMenu();
        mainMenu.setText("Main");
        mainMenu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        mainMenuBar.add(mainMenu);
        mainMenu.add(start);
        mainMenu.add(save);
        mainMenu.add(load);
        mainMenu.add(close);
        return mainMenuBar;
    }

    /**
     * Keeps the main frame and checks continously if elements are present within the model to see if it should allow for the saving of the model.
     */
    private void startMenu()
    {
        setMenuInput();
        while (exit == false)
        {
                if (mainController.getModel() != null && mainController.getModel().getElementPresent() == true)
                {
                    save.setEnabled(true);
                }
                else
                {
                    save.setEnabled(false);
                }
        }
    }

    /**
     * Set up the menu item actions and adds the actions to the menu buttons
     */
    private void setMenuInput()
    {
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newModel();
            }

        });
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveModel();
            }

        });
        load.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                loadModel();
            }

        });
        close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                closeModel();
            }

        });
    }

    /**
     * Check if there is a current model with elements open asks to save if there is and calls the createModel() function to create a new model.
     */
    private void newModel()
    {
        if (mainController.getModel() != null && mainController.getModel().getElementPresent() == true)
        {
            Object[] options =
            {
                "Yes, save",
                "No, don't save",
                "Cancel"
            };
            int n = JOptionPane.showOptionDialog(mainFrame, "Do you want to save your existing model before creating a new one?", "Are you sure you want to exit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
            if (n == 0)
            {
                saveModel();
                createModel();
            }
            else if (n == 1)
            {
                createModel();
            }
        }
        else
        {
            createModel();
        }
    }

    /**
     * Creates a popup requesting the user to select the desired model type from a dropdown box passes it on to the main controller to create the request new model and updates the UI with the model management UI.
     */
    private void createModel()
    {

        String s = (String) JOptionPane.showInputDialog(
                mainFrame,
                "What kind of model would you like to create:\n",
                "Model Type",
                JOptionPane.PLAIN_MESSAGE,
                null,
                supportedDiagrams,
                supportedDiagrams[0]);
        if ((s != null) && (s.length() > 0))
        {
            mainController.newModel(s);
            addElementManagenementUI();
        }
    }

    /**
     * Check if there is a current model with elements open asks to save if there is and calls the loadExistingModel() function to load a file containing a model.
     */
    private void loadModel()
    {
        if (mainController.getModel() != null && mainController.getModel().getElementPresent() == true)
        {
            Object[] options =
            {
                "Yes, save",
                "No, don't save",
                "Cancel"
            };
            int n = JOptionPane.showOptionDialog(mainFrame, "Do you want to save your existing model before loading another model?", "Are you sure you want to exit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
            if (n == 0)
            {
                saveModel();
                loadExistingModel();
            }
            else if (n == 1)
            {
                loadExistingModel();
            }
        }
        else
        {
            loadExistingModel();
        }

    }

    /**
     * Creates the pop up window to select the file to be loaded, attempts to open the file scanner, than passes it with the file path on to the maincontroller to load the model with the loadEModel()
     */     
    private void loadExistingModel()
    {
        // sets it to only accept files
        saveFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        //opens the file selection pane and sets the file path
        int returnValue = saveFileChooser.showOpenDialog(null);
        File jsonFile = null;

        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            jsonFile = saveFileChooser.getSelectedFile();
        }
        if (jsonFile != null)
        {
            Scanner fileScanner;
            try
            {
                fileScanner = new Scanner(new BufferedReader(new FileReader(jsonFile)));
                mainController.loadEModel(fileScanner, jsonFile.getParent());
                addElementManagenementUI();
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Adds the element management part to the UI and resizes
     */
    private void addElementManagenementUI()
    {
        detailsPanel = mainController.updateUI();
        mainFrame.setContentPane(detailsPanel);
        mainFrame.pack();
        mainFrame.revalidate();
        mainMenu.repaint();
    }

    /**
     * Opens the file selector for the save file, adds the .json file extension at the end if it was missing and passes the file on to the main controller via the savingModel() function who will save the active model in the file
     */
    private void saveModel()
    {
        File jsonFile = null;
        String path = null;
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
                mainController.savingModel(jsonFile);
            }
            else
            {
                mainController.savingModel(jsonFile);
            }
        }
    }

    /**
     * Checks if a model is ope, if it is asks if they want to save it before closing, closes the application. 
     */
    private void closeModel()
    {
        if (mainController.getModel() != null && mainController.getModel().getElementPresent() == true)
        {
            Object[] options =
            {
                "Yes, save",
                "No, don't save",
                "Cancel"
            };
            int n = JOptionPane.showOptionDialog(mainFrame, "Do you want to save your model before exiting?", "Are you sure you want to exit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
            if (n == 0)
            {
                saveModel();
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
            else if (n == 1)
            {
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        }
        else
        {
            mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        }
    }

}
