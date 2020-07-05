/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        MainMenu app = new MainMenu();
    }

    private boolean exit;
    private JMenuBar mainMenuBar;
    private JMenu mainMenu;
    private JPanel detailsPanel;
    private MainController mainController;
    private JMenuItem start = new JMenuItem("new Model");
    private JMenuItem save = new JMenuItem("Save Model");
    private JMenuItem load = new JMenuItem("Load Model");
    private JMenuItem close = new JMenuItem("Exit");
    private JFrame mainFrame; // The main frame containg the different game elements.
    private int option; //Int the choice to representing the output to close the menu.
    private JFileChooser saveFileChooser;
    private FileNameExtensionFilter filter;

    //Below the list of options for supported diagrams
    private Object[] supportedDiagrams;

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
        saveFileChooser = new JFileChooser();
        filter = new FileNameExtensionFilter(
                "JavaScript Object Notation", "json");
        saveFileChooser.setFileFilter(filter);
        supportedDiagrams = mainController.getSupportedModels();
        startMenu();

    }

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
     * Keeps the main frame running and awaiting input
     */
    private void startMenu()
    {
        setMenuInput();
        while (exit == false)
        {
            option = 0;
            Scanner kb = new Scanner(System.in);
            while (option != 1 && option == 1)
            {
                try
                {
                    option = Integer.parseInt(kb.nextLine());
                    if (option == 1)
                    {

                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error");
                }
            }
            exit = true;
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

    private void createModel()
    {

        String s = (String) JOptionPane.showInputDialog(
                mainFrame,
                "What kind of model would yoy like to create:\n",
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
                mainController.loadEModel(fileScanner);
                addElementManagenementUI();
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void addElementManagenementUI()
    {
        detailsPanel = mainController.updateUI();
        mainFrame.setContentPane(detailsPanel);
        mainFrame.pack();
        mainFrame.revalidate();
        mainMenu.repaint();
    }

    private void saveModel()
    {
        Model temp = mainController.getModel();
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
                mainController.savingModel(temp, jsonFile);
            }
            else
            {
                mainController.savingModel(temp, jsonFile);
            }
        }
    }

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
