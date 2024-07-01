/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import com.tugoflaherty.eventmanager.controller.EventViewerController;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author tugoflaherty
 */
public class EventViewer extends JFrame {
    
    private static EventViewer INSTANCE = new EventViewer();
    
    private ButtonPanel buttonPanel = new ButtonPanel();
    private TabPanel tabPanel = new TabPanel();

    /**
     * This method is a getter to return the buttonPanel attribute as type ButtonPanel
     * It takes in no parameters
     * @return This returns the buttonPanel of type ButtonPanel
     */
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * This method is a setter to set the value of the buttonPanel attribute using a value of type ButtonPanel
     * It does not return a value
     * @param buttonPanel This is the value of the buttonPanel attribute to be set of type ButtonPanel
     */
    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    /**
     * This method is a getter to return the tabPanel attribute as type TabPanel
     * It takes in no parameters
     * @return This returns the tabPanel of type TabPanel
     */
    public TabPanel getTabPanel() {
        return tabPanel;
    }

    /**
     * This method is a setter to set the value of the tabPanel attribute using a value of type TabPanel
     * It does not return a value
     * @param tabPanel This is the value of the tabPanel attribute to be set of type TabPanel
     */
    public void setTabPanel(TabPanel tabPanel) {
        this.tabPanel = tabPanel;
    }
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenu viewMenu = new JMenu("View");
    private JMenu sortByMenu = new JMenu("Sort By");
    private JMenuItem newFile = new JMenuItem("New File");
    private JMenuItem openFile = new JMenuItem("Open File");
    private JMenuItem saveFile = new JMenuItem("Save File");
    private JMenuItem newEvent = new JMenuItem("New Event");
    private JMenuItem newItem = new JMenuItem("New Event Item");
    private JMenuItem newOrganiser = new JMenuItem("New Organiser");
    private JMenuItem quitApplication = new JMenuItem("Exit");
    private JMenuItem deleteEvent = new JMenuItem("Delete Event");
    private JMenuItem deleteItem = new JMenuItem("Delete Event Item");
    private JMenuItem associateEventOrganiser = new JMenuItem("Set Event Organiser");
    private JMenuItem editEvent = new JMenuItem("Edit Event");
    private JMenuItem editItem = new JMenuItem("Edit Item");
    private JMenuItem editOrganiser = new JMenuItem("Edit Organiser");
    private JMenuItem textView = new JMenuItem("Text View");
    private JMenuItem hierarchalView = new JMenuItem("Hierarchal View");
    private JMenuItem eventDateAscending = new JMenuItem("Event Date (Ascending)");
    private JMenuItem eventDateDescending = new JMenuItem("Event Date (Descending)");
    private JMenuItem eventTitleAscending = new JMenuItem("Event Title (Ascending)");
    private JMenuItem eventTitleDescending = new JMenuItem("Event Title (Descending)");
    
    /**
     * This method uses a Singleton Pattern to create an instance of EventViewer if one does not already exist, but if one already exists, return that instance
     * Ensures only one instance of EventViewer can be instantiated throughout the application
     * This does not take any parameters
     * @return This returns the singular instance of an EventViewer object
     */
    public static EventViewer getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new EventViewer();
            //System.out.println("New EventViewer instance created");
        }
        //System.out.println("Using the first EventViewer instance created");
        return INSTANCE;
    }
    
    private EventViewer() {
        EventViewerController eventHandler = new EventViewerController();
        ImageIcon icon = new ImageIcon("applicationIcon.jpg");
        this.setIconImage(icon.getImage());
        this.setTitle("Event Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400,0,575,425);
        this.setLayout(new BorderLayout());
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        newFile.setActionCommand("newFile");
        newFile.addActionListener(eventHandler);
        fileMenu.add(newFile);
        openFile.setActionCommand("openFile");
        openFile.addActionListener(eventHandler);
        fileMenu.add(openFile);
        saveFile.setActionCommand("saveFile");
        saveFile.addActionListener(eventHandler);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        newEvent.setActionCommand("addEvent");
        newEvent.addActionListener(eventHandler);
        fileMenu.add(newEvent);
        newItem.setActionCommand("addItem");
        newItem.addActionListener(eventHandler);
        fileMenu.add(newItem);
        newOrganiser.setActionCommand("addOrganiser");
        newOrganiser.addActionListener(eventHandler);
        fileMenu.add(newOrganiser);
        fileMenu.addSeparator();
        quitApplication.setActionCommand("quitApplication");
        quitApplication.addActionListener(eventHandler);
        fileMenu.add(quitApplication);
        editEvent.setActionCommand("editEvent");
        editEvent.addActionListener(eventHandler);
        editMenu.add(editEvent);
        editItem.setActionCommand("editItem");
        editItem.addActionListener(eventHandler);
        editMenu.add(editItem);
        editOrganiser.setActionCommand("editOrganiser");
        editOrganiser.addActionListener(eventHandler);
        editMenu.add(editOrganiser);
        editMenu.addSeparator();
        associateEventOrganiser.setActionCommand("associateEventOrganiser");
        associateEventOrganiser.addActionListener(eventHandler);
        editMenu.add(associateEventOrganiser);
        editMenu.addSeparator();
        deleteEvent.setActionCommand("deleteEvent");
        deleteEvent.addActionListener(eventHandler);
        editMenu.add(deleteEvent);
        deleteItem.setActionCommand("deleteItem");
        deleteItem.addActionListener(eventHandler);
        editMenu.add(deleteItem);
        textView.setActionCommand("textView");
        textView.addActionListener(eventHandler);
        viewMenu.add(textView);
        hierarchalView.setActionCommand("hierarchalView");
        hierarchalView.addActionListener(eventHandler);
        viewMenu.add(hierarchalView);
        viewMenu.addSeparator();
        viewMenu.add(sortByMenu);
        eventDateAscending.setActionCommand("eventDateAscending");
        eventDateAscending.addActionListener(eventHandler);
        sortByMenu.add(eventDateAscending);
        eventDateDescending.setActionCommand("eventDateDescending");
        eventDateDescending.addActionListener(eventHandler);
        sortByMenu.add(eventDateDescending);
        eventTitleAscending.setActionCommand("eventTitleAscending");
        eventTitleAscending.addActionListener(eventHandler);
        sortByMenu.add(eventTitleAscending);
        eventTitleDescending.setActionCommand("eventTitleDescending");
        eventTitleDescending.addActionListener(eventHandler);
        sortByMenu.add(eventTitleDescending);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(tabPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
