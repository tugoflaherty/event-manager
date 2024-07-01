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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tugoflaherty
 */
public class EventViewerController implements ActionListener {

    /**
     * This method is an override of the actionPerformed method in ActionListener
     * It determines the option selected in the EventViewer user interface and calls the relevant method
     * It returns no values
     * @param ae This is an ActionEvent parameter to determine which  methods to run when the user interaction happens
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        //System.out.println(ae.getActionCommand()); //(un)comment for testing JButtons/JMenuItems
        EventManager eventManager = EventManager.getInstance();
        EventViewer eventViewer = EventViewer.getInstance();
        switch (ae.getActionCommand()) {
            case "newFile":
                Object[] newFileOptions = {"Keep Organisers", "Clear Organisers"};
                int newFileOption = JOptionPane.showOptionDialog(eventViewer, "Keep current stored organisers or clear organisers?", "Keep or Clear Organisers", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, null, newFileOptions, newFileOptions[0]);
                if (newFileOption == JOptionPane.YES_OPTION) {
                    eventManager.initialiseModelKeepOrganisers();
                }
                else if (newFileOption == JOptionPane.NO_OPTION) {
                    eventManager.initialiseModelDeleteOrganisers();
                }
                eventManager.modelModified();
                break;
            case "eventTitleDescending":
                eventManager.sortEventsByEventTitleDescending();
                eventManager.modelModified();
                break;
            case "eventTitleAscending":
                eventManager.sortEventsByEventTitleAscending();
                eventManager.modelModified();
                break;
            case "eventDateDescending":
                eventManager.sortEventsByDateTimeDescending();
                eventManager.modelModified();
                break;
            case "eventDateAscending":
                eventManager.sortEventsByDateTimeAscending();
                eventManager.modelModified();
                break;
            case "editOrganiser":
                int organiserToEdit = eventManager.getSelectedOrganiser(eventManager.getTextUserSelects());
                if (organiserToEdit != -1) {
                    JTextField editFirstNameInputField = new JTextField();
                    JTextField editSurnameInputField = new JTextField();
                    Object[] editOrganiserInputFields = {"New First Name:", editFirstNameInputField, "New Surname:", editSurnameInputField};
                    int editOrganiser = JOptionPane.showConfirmDialog(eventViewer, editOrganiserInputFields, "Edit Organiser", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (editOrganiser == JOptionPane.OK_OPTION) {
                        String editFirstNameTextInput = editFirstNameInputField.getText().trim();
                        String editSurnameTextInput = editSurnameInputField.getText().trim();
                        if (!editFirstNameTextInput.isEmpty() && !editSurnameTextInput.isEmpty()) {
                            boolean organiserEdited = eventManager.editOrganiser(organiserToEdit,editFirstNameTextInput, editSurnameTextInput);
                        }
                    }
                }
                eventManager.modelModified();
                break;
            case "editItem":
                int[] itemToEdit = eventManager.getSelectedItem(eventManager.getTextUserSelects());
                if (itemToEdit[0] != -1 && itemToEdit[1] != -1) {
                    JTextField editStartTimeInputField = new JTextField();
                    JTextField editItemTitleInputField = new JTextField();
                    Object[] editItemInputFields = {"New Start Time (24Hr HH:MM):", editStartTimeInputField, "New Item Title:", editItemTitleInputField};
                    int addItem = JOptionPane.showConfirmDialog(eventViewer, editItemInputFields, "Edit Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (addItem == JOptionPane.OK_OPTION) {
                        String startTimeTextInput = editStartTimeInputField.getText().trim();
                        String itemTitleTextInput = editItemTitleInputField.getText().trim();
                        if (!startTimeTextInput.isEmpty() && !itemTitleTextInput.isEmpty()) {
                            boolean itemEdited = eventManager.editItem(itemToEdit[0],itemToEdit[1],startTimeTextInput,itemTitleTextInput);
                        }
                    }
                }
                eventManager.sortItemsByStartTime();
                eventManager.modelModified();
                break;
            case "editEvent":
                int eventIndexToEdit = eventManager.getSelectedEvent(eventManager.getTextUserSelects());
                if (eventIndexToEdit != -1) {
                    JTextField editTitleInputField = new JTextField();
                    JTextField editDateInputField = new JTextField();
                    JTextField editTimeInputField = new JTextField();
                    JTextField editLocationInputField = new JTextField();
                    List<String> editOrganiserNames = new ArrayList();
                    editOrganiserNames.add("No Organiser");
                    for (Organiser organiser : eventManager.getOrganisers())
                    {
                        editOrganiserNames.add(organiser.toString());
                    }
                    Object[] editEventInputFields = {"Date and Time must always be entered together", "New Title:", editTitleInputField, "New Date (YYYY-MM-DD):", editDateInputField, "New Time (24Hr HH:MM):", editTimeInputField, "New Location:", editLocationInputField};
                    int editEvent = JOptionPane.showConfirmDialog(eventViewer, editEventInputFields, "Edit Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (editEvent == JOptionPane.OK_OPTION) {
                        String editTitleTextInput = editTitleInputField.getText().trim();
                        String editDateTextInput = editDateInputField.getText().trim();
                        String editTimeTextInput = editTimeInputField.getText().trim();
                        String editDateTimeTextInput = editDateTextInput+"T"+editTimeTextInput;
                        String editLocationTextInput = editLocationInputField.getText().trim();
                        boolean eventEdited = eventManager.editEventDetails(eventIndexToEdit, editTitleTextInput, editDateTimeTextInput, editLocationTextInput);
                        if (eventEdited == false) {
                            int errorEditingEvent = JOptionPane.showConfirmDialog(eventViewer, "Error editing event. Ensure the Event Date and Time are in the correct format, there are no commas in the Event Title and Location fields, and it is not a duplicate Event. Try again", "Error Editing Event", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                eventManager.modelModified();
                break;
            case "associateEventOrganiser":
                int eventIndexToSetOrganiser = eventManager.getSelectedEvent(eventManager.getTextUserSelects());
                if (eventIndexToSetOrganiser != -1) {
                    List<String> organiserNamesToSet = new ArrayList();
                    organiserNamesToSet.add("No Organiser");
                    for (Organiser organiser : eventManager.getOrganisers())
                    {
                        organiserNamesToSet.add(organiser.toString());
                    }
                    JComboBox setOrganisersComboBox = new JComboBox(organiserNamesToSet.toArray());
                    Object[] setOrganiserInputFields = {"Organiser:", setOrganisersComboBox};
                    int setOrganiser = JOptionPane.showConfirmDialog(eventViewer, setOrganiserInputFields, "Set Event Organiser", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (setOrganiser == JOptionPane.OK_OPTION) {
                        int setOrganiserIndex = setOrganisersComboBox.getSelectedIndex() -1;
                        if (setOrganiserIndex >= 0) {
                            eventManager.associateOrganiserToEvent(eventIndexToSetOrganiser, setOrganiserIndex);
                        }
                        else {
                            eventManager.getEvents().get(eventIndexToSetOrganiser).setOrganiser(null);
                        }
                    }
                }
                eventManager.modelModified();
                break;
            case "deleteItem":
                int[] itemToDelete = eventManager.getSelectedItem(eventManager.getTextUserSelects());
                if (itemToDelete[0] != -1 && itemToDelete[1] != -1) {
                    eventManager.getEvents().get(itemToDelete[0]).getItems().remove(itemToDelete[1]);
                }
                eventManager.sortItemsByStartTime();
                eventManager.modelModified();
                break;
            case "deleteEvent":
                int eventIndexToDelete = eventManager.getSelectedEvent(eventManager.getTextUserSelects());
                if (eventIndexToDelete != -1) {
                eventManager.getEvents().remove(eventIndexToDelete);
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
                eventManager.sortItemsByStartTime();
                eventManager.modelModified();
                break;
            case "addOrganiser":
                JTextField firstNameInputField = new JTextField();
                JTextField surnameInputField = new JTextField();
                Object[] organiserInputFields = {"First Name:", firstNameInputField, "Surname:", surnameInputField};
                int addOrganiser = JOptionPane.showConfirmDialog(eventViewer, organiserInputFields, "Add Organiser", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (addOrganiser == JOptionPane.OK_OPTION) {
                    String firstNameTextInput = firstNameInputField.getText().trim();
                    String surnameTextInput = surnameInputField.getText().trim();
                    if (!firstNameTextInput.isEmpty() && !surnameTextInput.isEmpty()) {
                        boolean organiserAdded = eventManager.addOrganiser(firstNameTextInput, surnameTextInput);
                        if (organiserAdded == false) {
                            int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding organiser. Ensure there are no commas in the Organiser's First Name and Surname fields and it is not a duplicate organiser. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding organiser. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                }
                eventManager.modelModified();
                break;
            case "saveFile":
                JFileChooser saveFileChooser = new JFileChooser();
                FileNameExtensionFilter saveFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                saveFileChooser.setFileFilter(saveFileFilter);
                int saveFileOption = saveFileChooser.showSaveDialog(eventViewer);
                if (saveFileOption == JFileChooser.APPROVE_OPTION) {
                    File fileToSave;
                    String saveFilePath;
                    fileToSave = saveFileChooser.getSelectedFile();
                    saveFilePath = fileToSave.getAbsolutePath();
                    eventManager.writeConfigFile(saveFilePath);
                    eventManager.writeOrganisersFile(saveFilePath);
                    eventManager.writeEventsFile(saveFilePath);
                    eventManager.writeItemsFile(saveFilePath);
                    eventManager.saveState(saveFilePath);
                    System.out.println("Config File Path: " + saveFilePath);
                }
                break;
            case "openFile":
                int continueOpeningFile = JOptionPane.showConfirmDialog(eventViewer, "Opening a file will erase all Organisers, Events, and Event Items unless they have already been saved. Continue?", "Continue to Open File", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (continueOpeningFile == JOptionPane.YES_OPTION) {
                    eventManager.initialiseModelDeleteOrganisers();
                    JFileChooser openFileChooser = new JFileChooser();
                    FileNameExtensionFilter openFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                    openFileChooser.setFileFilter(openFileFilter);
                    int openFileOption = openFileChooser.showOpenDialog(eventViewer);
                    if (openFileOption == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = openFileChooser.getSelectedFile();
                        String openFilePath = fileToOpen.getAbsolutePath();
                        eventManager.readConfigFile(openFilePath);
                        System.out.println("Config File Path: " + openFilePath);
                    }
                }
                eventManager.modelModified();
                break;
            case "textView":
                eventViewer.getTabPanel().getTabPane().setSelectedIndex(0);
                break;
            case "hierarchalView":
                eventViewer.getTabPanel().getTabPane().setSelectedIndex(1);
                break;
            case "quitApplication":
                System.exit(0);
                break;
            default:
                break;
                
        }
    }
}
