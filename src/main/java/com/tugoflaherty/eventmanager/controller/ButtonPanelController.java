/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.controller;

import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.model.Organiser;
import com.tugoflaherty.eventmanager.view.EventViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author tugoflaherty
 */
public class ButtonPanelController implements ActionListener {

    /**
     * This method is an override of the actionPerformed method in ActionListener
     * It determines the option selected in the Button Panel in the user interface and calls the relevant method
     * It returns no values
     * @param ae This is an ActionEvent parameter to determine which  methods to run when the user interaction happens
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        //System.out.println(ae.getActionCommand()); //(un)comment for testing JButtons/JMenuItems
        EventManager eventManager = EventManager.getInstance();
        EventViewer eventViewer = EventViewer.getInstance();
        switch (ae.getActionCommand()) {
            case "deleteEvent":
                int eventIndexToDelete = eventManager.getSelectedEvent(eventManager.getTextUserSelects());
                if (eventIndexToDelete != -1) {
                eventManager.getEvents().remove(eventIndexToDelete);
                }
                eventManager.modelModified();
                break;
            case "addItem":
                int eventIndex = eventManager.getSelectedEvent(eventManager.getTextUserSelects());
                if (eventIndex != -1) {
                    JTextField startTimeInputField = new JTextField();
                    JTextField itemTitleInputField = new JTextField();
                    Object[] itemInputFields = {"Start Time (24Hr HH:MM):", startTimeInputField, "Item Title:", itemTitleInputField};
                    int addItem = JOptionPane.showConfirmDialog(eventViewer, itemInputFields, "Add Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (addItem == JOptionPane.OK_OPTION) {
                        String startTimeTextInput = startTimeInputField.getText().trim();
                        String itemTitleTextInput = itemTitleInputField.getText().trim();
                        if (!startTimeTextInput.isEmpty() && !itemTitleTextInput.isEmpty()) {
                            boolean itemAdded = eventManager.addItemsToEvent(eventIndex, startTimeTextInput, itemTitleTextInput);
                            if (itemAdded == false) {
                                int errorAddItem = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure the Item Start Date is in the correct format, there are no commas in the Item's Title field, and it is not a duplicate Item. Try again", "Error Adding Item", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                eventManager.modelModified();
                break;
                case "addEvent":
                JTextField titleInputField = new JTextField();
                JTextField dateInputField = new JTextField();
                JTextField timeInputField = new JTextField();
                JTextField locationInputField = new JTextField();
                List<String> organiserNames = new ArrayList();
                organiserNames.add("No Organiser");
                for (Organiser organiser : eventManager.getOrganisers())
                {
                    organiserNames.add(organiser.toString());
                }
                JComboBox organisersComboBox = new JComboBox(organiserNames.toArray());
                Object[] eventInputFields = {"Title:", titleInputField, "Organiser:", organisersComboBox, "Date (YYYY-MM-DD):", dateInputField, "Time (24Hr HH:MM):", timeInputField, "Location:", locationInputField};
                int addEvent = JOptionPane.showConfirmDialog(eventViewer, eventInputFields, "Add Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (addEvent == JOptionPane.OK_OPTION) {
                    String titleTextInput = titleInputField.getText().trim();
                    int organiserIndex = organisersComboBox.getSelectedIndex();
                    String dateTextInput = dateInputField.getText().trim();
                    String timeTextInput = timeInputField.getText().trim();
                    String dateTimeTextInput = dateTextInput+"T"+timeTextInput;
                    String locationTextInput = locationInputField.getText().trim();
                    if (!titleTextInput.isEmpty() && !dateTextInput.isEmpty() && !timeTextInput.isEmpty() && !locationTextInput.isEmpty()) {
                        if (organiserIndex !=0) {
                            boolean eventAdded = eventManager.addEvent(titleTextInput, eventManager.getOrganisers().get(organiserIndex-1), dateTimeTextInput, locationTextInput);
                            if (eventAdded == false) {
                                int errorAddEvent = JOptionPane.showConfirmDialog(eventViewer, "Error adding event. Ensure the Event Date and Time are in the correct format, there are no commas in the Item's Title and Location fields, and it is not a duplicate Item. Try again", "Error Adding Event", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            boolean eventAdded = eventManager.addEvent(titleTextInput, dateTimeTextInput, locationTextInput);
                            if (eventAdded == false) {
                                int errorAddEvent = JOptionPane.showConfirmDialog(eventViewer, "Error adding event. Ensure the Event Date and Time are in the correct format, there are no commas in the Item's Title and Location fields, and it is not a duplicate Item. Try again", "Error Adding Event", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else {
                        int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                }
                eventManager.modelModified();
                break;
        }
    }
}