/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import com.tugoflaherty.eventmanager.controller.ButtonPanelController;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tugoflaherty
 */
public class ButtonPanel extends JPanel {
    
    private JButton addEvent = new JButton("New Event");
    private JButton addItem = new JButton("New Event Item");
    private JButton deleteEvent = new JButton("Delete Event");

    /**
     * This method is a getter to return the addEvent attribute as type JButton
     * It takes in no parameters
     * @return This returns the addEvent of type JButton
     */
    public JButton getAddEvent() {
        return addEvent;
    }

    /**
     * This method is a setter to set the value of the addEvent attribute using a value of type JButton
     * It does not return a value
     * @param addEvent This is the value of the addEvent attribute to be set of type JButton
     */
    public void setAddEvent(JButton addEvent) {
        this.addEvent = addEvent;
    }

    /**
     * This method is a getter to return the addItem attribute as type JButton
     * It takes in no parameters
     * @return This returns the addItem of type JButton
     */
    public JButton getAddItem() {
        return addItem;
    }

    /**
     * This method is a setter to set the value of the addItem attribute using a value of type JButton
     * It does not return a value
     * @param addItem This is the value of the addItem attribute to be set of type JButton
     */
    public void setAddItem(JButton addItem) {
        this.addItem = addItem;
    }

    /**
     * This method is a getter to return the deleteEvent attribute as type JButton
     * It takes in no parameters
     * @return This returns the deleteEvent of type JButton
     */
    public JButton getDeleteEvent() {
        return deleteEvent;
    }

    /**
     * This method is a setter to set the value of the deleteEvent attribute using a value of type JButton
     * It does not return a value
     * @param deleteEvent This is the value of the deleteEvent attribute to be set of type JButton
     */
    public void setDeleteEvent(JButton deleteEvent) {
        this.deleteEvent = deleteEvent;
    }
    
    /**
     * This is a constructor method to construct a new instance of ButtonPanel when called
     * It creates a new instance of eventHandler to handle user interaction and sets a FlowLayout for the buttons
     * It sets a preferred window size, associates ActionCommands and ActionListeners to the buttons and adds them to the panel
     * It does not take in any parameters
     * It does not return any values
     */
    public ButtonPanel() {
        ButtonPanelController eventHandler = new ButtonPanelController();
        this.setLayout(new FlowLayout());
        addEvent.setPreferredSize(new Dimension(150, 25));
        addItem.setPreferredSize(new Dimension(150, 25));
        deleteEvent.setPreferredSize(new Dimension(150, 25));
        addEvent.setActionCommand("addEvent");
        addEvent.addActionListener(eventHandler);
        addItem.setActionCommand("addItem");
        addItem.addActionListener(eventHandler);
        deleteEvent.setActionCommand("deleteEvent");
        deleteEvent.addActionListener(eventHandler);
        this.add(addEvent);
        this.add(addItem);
        this.add(deleteEvent);
    }
}
