/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bart Kooijmans
 */
public class ElementGUI extends javax.swing.JPanel
{

    Element selectedElement;
    MainController guiController;
    String attributes = new String();
    String operations = new String();
    String responsibilities = new String();
    String notes = new String();
    int activeEditorField;
    JFrame connectionFrame = new JFrame();

    public ElementGUI(MainController suppliedGuiController)
    {
        guiController = suppliedGuiController;
        initComponents();
        for (String type : guiController.getAllowedElements())
        {
            boxType.addItem(type);
        }
        updateList();
    }

    private void updateList()
    {
        listElements.removeAll();
        for (Element tempElement : guiController.getElements())
        {
            listElements.add(tempElement.toString());
        }
        listElements.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenuItem1 = new javax.swing.JMenuItem();
        fieldIdentifier = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldDescription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldStartLevel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldEndLevel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldTeminationLevel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stringArrayEditor = new javax.swing.JEditorPane();
        editAttributesButton = new javax.swing.JButton();
        editOperationsButton = new javax.swing.JButton();
        editResponsibiltiesButton = new javax.swing.JButton();
        editConnectionButton = new javax.swing.JButton();
        connectionBox = new javax.swing.JComboBox<>();
        newConnectionButton = new javax.swing.JButton();
        removeConnectionButton = new javax.swing.JButton();
        innerElementBox = new javax.swing.JComboBox<>();
        editInnerElementButton = new javax.swing.JButton();
        removeInnerElementButton = new javax.swing.JButton();
        newInnerElementButton = new javax.swing.JButton();
        editNotesButton = new javax.swing.JButton();
        boxType = new javax.swing.JComboBox<>();
        saveButton = new javax.swing.JButton();
        listElements = new java.awt.List();
        newElementButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        fieldIdentifier.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldIdentifier.setAlignmentX(0.0F);
        fieldIdentifier.setEnabled(false);

        jLabel1.setText("Identifier:");

        jLabel2.setText("Type:");

        fieldDescription.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldDescription.setAlignmentX(0.0F);

        jLabel3.setText("Description:");

        jLabel4.setText("Attributes:");

        jLabel5.setText("Operations:");

        jLabel6.setText("Responsibilities:");

        jLabel7.setText("Connections: ");

        jLabel8.setText("Inner classes:");

        fieldStartLevel.setAlignmentX(0.0F);

        jLabel9.setText("Start level:");

        fieldEndLevel.setAlignmentX(0.0F);

        jLabel10.setText("End level:");

        fieldTeminationLevel.setAlignmentX(0.0F);

        jLabel11.setText("Termination Level:  ");

        jLabel12.setText("Notes: ");

        stringArrayEditor.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                stringArrayEditorFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(stringArrayEditor);

        editAttributesButton.setText("Edit Attributes");
        editAttributesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editAttributesButtonActionPerformed(evt);
            }
        });

        editOperationsButton.setText("Edit Operations");
        editOperationsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editOperationsButtonActionPerformed(evt);
            }
        });

        editResponsibiltiesButton.setText("Edit Responsibilities");
        editResponsibiltiesButton.setAlignmentX(0.5F);
        editResponsibiltiesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editResponsibiltiesButtonActionPerformed(evt);
            }
        });

        editConnectionButton.setText("Edit Connection");
        editConnectionButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editConnectionButtonActionPerformed(evt);
            }
        });

        connectionBox.setAlignmentX(0.0F);
        connectionBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener()
        {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt)
            {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt)
            {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt)
            {
                connectionBoxPopupMenuWillBecomeVisible(evt);
            }
        });

        newConnectionButton.setText("New Connection");
        newConnectionButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newConnectionButtonActionPerformed(evt);
            }
        });

        removeConnectionButton.setText("Remove Connection");
        removeConnectionButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeConnectionButtonActionPerformed(evt);
            }
        });

        innerElementBox.setAlignmentX(0.0F);

        editInnerElementButton.setText("Edit Element");

        removeInnerElementButton.setText("Remove Element");

        newInnerElementButton.setText("New Element");

        editNotesButton.setText("Edit Notes");
        editNotesButton.setAlignmentX(0.5F);
        editNotesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editNotesButtonActionPerformed(evt);
            }
        });

        boxType.setAlignmentX(0.0F);

        saveButton.setText("Save Changes");
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        listElements.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                listElementsActionPerformed(evt);
            }
        });

        newElementButton.setText("Create new element");
        newElementButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newElementButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(listElements, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editAttributesButton)
                                    .addComponent(boxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(connectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editConnectionButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeConnectionButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newConnectionButton))
                                    .addComponent(fieldStartLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(innerElementBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editInnerElementButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeInnerElementButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newInnerElementButton))
                                    .addComponent(fieldEndLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTeminationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editNotesButton)
                                    .addComponent(editOperationsButton)
                                    .addComponent(editResponsibiltiesButton))))
                        .addGap(44, 46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(newElementButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(boxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(editAttributesButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(editOperationsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(editResponsibiltiesButton)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(newElementButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(editConnectionButton)
                    .addComponent(connectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newConnectionButton)
                    .addComponent(removeConnectionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(editInnerElementButton)
                    .addComponent(innerElementBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newInnerElementButton)
                    .addComponent(removeInnerElementButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldStartLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldEndLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTeminationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(editNotesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(listElements, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listElementsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_listElementsActionPerformed
    {//GEN-HEADEREND:event_listElementsActionPerformed
        if (selectedElement == null)
        {
            loadSelectedElement();
        }
        else
        {
            saveChanges();
            loadSelectedElement();
            updateList();
        }

    }//GEN-LAST:event_listElementsActionPerformed

    private void saveChanges()
    {
        Object[] options =
        {
            "Yes, save",
            "No, don't save"
        };
        int n = JOptionPane.showOptionDialog(null, "Do you want to save your changes?", "Save changes?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
        if (n == 0)
        {
            saveElement();
            guiController.loadAllInstances();
        }
    }

    private void saveElement()
    {
        ArrayList<String> operationsList = splitString(operations);
        ArrayList<String> attributesList = splitString(attributes);
        ArrayList<String> responsibilitiesList = splitString(responsibilities);
        selectedElement.setOperations(operationsList);
        selectedElement.setAttributes(attributesList);
        selectedElement.setResponsibilities(responsibilitiesList);
        selectedElement.setType(boxType.getSelectedItem().toString());
        selectedElement.setDescription(fieldDescription.getText());
        selectedElement.setStartLevel(Integer.parseInt(fieldStartLevel.getText()));
        selectedElement.setEndLevel(Integer.parseInt(fieldEndLevel.getText()));
        selectedElement.setTerminationLevel(Integer.parseInt(fieldTeminationLevel.getText()));
        selectedElement.setNotes(notes);
    }

    private ArrayList<String> splitString(String n)
    {
        ArrayList<String> tempList = new ArrayList<>();
        String[] temp = n.split("\n");
        tempList.addAll(Arrays.asList(temp));
        return tempList;
    }

    private void loadSelectedElement()
    {
        String lookup = listElements.getSelectedItem();
        int split = lookup.indexOf(" : ");
        lookup = lookup.substring(0, split);
        selectedElement = guiController.findElement(lookup);
        fieldIdentifier.setText(selectedElement.getIdentifier());
        fieldDescription.setText(selectedElement.getDescription());
        fieldStartLevel.setText(Integer.toString(selectedElement.getStartLevel()));
        fieldEndLevel.setText(Integer.toString(selectedElement.getEndLevel()));
        fieldTeminationLevel.setText(Integer.toString(selectedElement.getterminationLevel()));
        attributes = "";
        operations = "";
        responsibilities = "";
        notes = "";
        activeEditorField = 0;
        stringArrayEditor.setText("");
        updateArrays();
        updateBoxes();
    }

    private void updateArrays()
    {
        for (String temp : selectedElement.getAttributes())
        {
            attributes = attributes + temp + "\n";
        }
        for (String temp : selectedElement.getOperation())
        {
            operations = operations + temp + "\n";
        }
        for (String temp : selectedElement.getOperation())
        {
            responsibilities = responsibilities + temp + "\n";
        }
        notes = selectedElement.getNotes();
    }

    private void updateBoxes()
    {
        connectionBox.removeAllItems();
        innerElementBox.removeAllItems();
        for (Connection temp : selectedElement.getConnections())
        {
            connectionBox.addItem(temp.toString());
        }
        for (Element temp : selectedElement.getInnerElements())
        {
            innerElementBox.addItem(temp.toString());
        }
    }

    private void editAttributesButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editAttributesButtonActionPerformed
    {//GEN-HEADEREND:event_editAttributesButtonActionPerformed
        if (selectedElement != null)
        {
            stringArrayEditor.setText(attributes);
            activeEditorField = 1;
        }
    }//GEN-LAST:event_editAttributesButtonActionPerformed

    private void editOperationsButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editOperationsButtonActionPerformed
    {//GEN-HEADEREND:event_editOperationsButtonActionPerformed
        if (selectedElement != null)
        {
            stringArrayEditor.setText(operations);
            activeEditorField = 2;
        }
    }//GEN-LAST:event_editOperationsButtonActionPerformed

    private void editResponsibiltiesButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editResponsibiltiesButtonActionPerformed
    {//GEN-HEADEREND:event_editResponsibiltiesButtonActionPerformed
        if (selectedElement != null)
        {
            stringArrayEditor.setText(responsibilities);
            activeEditorField = 3;
        }


    }//GEN-LAST:event_editResponsibiltiesButtonActionPerformed

    private void editNotesButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editNotesButtonActionPerformed
    {//GEN-HEADEREND:event_editNotesButtonActionPerformed
        if (selectedElement != null)
        {
            stringArrayEditor.setText(notes);
            activeEditorField = 4;
        }
    }//GEN-LAST:event_editNotesButtonActionPerformed

    private void stringArrayEditorFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_stringArrayEditorFocusLost
    {//GEN-HEADEREND:event_stringArrayEditorFocusLost
        if (activeEditorField == 1)
        {
            attributes = stringArrayEditor.getText();
        }
        else if (activeEditorField == 2)
        {
            operations = stringArrayEditor.getText();
        }
        else if (activeEditorField == 3)
        {
            responsibilities = stringArrayEditor.getText();
        }
        else if (activeEditorField == 4)
        {
            notes = stringArrayEditor.getText();
        }
    }//GEN-LAST:event_stringArrayEditorFocusLost

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButtonActionPerformed
    {//GEN-HEADEREND:event_saveButtonActionPerformed
        saveChanges();
        int temp = listElements.getSelectedIndex();
        updateList();
        listElements.select(temp);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editConnectionButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editConnectionButtonActionPerformed
    {//GEN-HEADEREND:event_editConnectionButtonActionPerformed
        String connectionID = connectionBox.getSelectedItem().toString();
        int split = connectionID.indexOf(" : ");
        connectionID = connectionID.substring(0, split);
        Connection connection = guiController.findConnection(connectionID);
        connectionFrame = new JFrame();
        ConnectionGUI connectionGUI = new ConnectionGUI(connection, guiController);
        connectionFrame.add(connectionGUI);
        connectionFrame.pack();
        connectionFrame.setVisible(true);

    }//GEN-LAST:event_editConnectionButtonActionPerformed

    private void removeConnectionButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removeConnectionButtonActionPerformed
    {//GEN-HEADEREND:event_removeConnectionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeConnectionButtonActionPerformed

    private void newConnectionButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newConnectionButtonActionPerformed
    {//GEN-HEADEREND:event_newConnectionButtonActionPerformed
        if (selectedElement != null)
        {
            connectionFrame = new JFrame();
            ConnectionGUI connectionGUI = new ConnectionGUI(selectedElement, guiController);
            connectionFrame.add(connectionGUI);
            connectionFrame.pack();
            connectionFrame.setVisible(true);
        }
        else
        {
            System.out.println("Select an element first to start the connection fromn");
        }
    }//GEN-LAST:event_newConnectionButtonActionPerformed

    private void newElementButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newElementButtonActionPerformed
    {//GEN-HEADEREND:event_newElementButtonActionPerformed
        selectedElement = null;
        fieldIdentifier.setText(guiController.findNextAvailableElementID());
        fieldDescription.setText("");
        fieldStartLevel.setText("0");
        fieldEndLevel.setText("0");
        fieldTeminationLevel.setText("0");
        attributes = "";
        operations = "";
        responsibilities = "";
        notes = "";
        activeEditorField = 0;
        stringArrayEditor.setText("");
    }//GEN-LAST:event_newElementButtonActionPerformed

    private void connectionBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt)//GEN-FIRST:event_connectionBoxPopupMenuWillBecomeVisible
    {//GEN-HEADEREND:event_connectionBoxPopupMenuWillBecomeVisible
        updateBoxes();
        this.revalidate();
    }//GEN-LAST:event_connectionBoxPopupMenuWillBecomeVisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxType;
    private javax.swing.JComboBox<String> connectionBox;
    private javax.swing.JButton editAttributesButton;
    private javax.swing.JButton editConnectionButton;
    private javax.swing.JButton editInnerElementButton;
    private javax.swing.JButton editNotesButton;
    private javax.swing.JButton editOperationsButton;
    private javax.swing.JButton editResponsibiltiesButton;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldEndLevel;
    private javax.swing.JTextField fieldIdentifier;
    private javax.swing.JTextField fieldStartLevel;
    private javax.swing.JTextField fieldTeminationLevel;
    private javax.swing.JComboBox<String> innerElementBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.List listElements;
    private javax.swing.JButton newConnectionButton;
    private javax.swing.JButton newElementButton;
    private javax.swing.JButton newInnerElementButton;
    private javax.swing.JButton removeConnectionButton;
    private javax.swing.JButton removeInnerElementButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JEditorPane stringArrayEditor;
    // End of variables declaration//GEN-END:variables

}