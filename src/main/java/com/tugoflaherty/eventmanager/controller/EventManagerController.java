/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.controller;

import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.view.EventViewer;

/**
 *
 * @author tugoflaherty
 */
public class EventManagerController {

    /**
     * This is the main method into the application when the application is run, creating instances of EventManager and EventViewer
     * It initialises the model, loads in the previous closed state and calls the viewer to update based on this loaded in file
     * @param args The main String Array arguments parameter used for the initialisation of the application in the main method
     */
    public static void main(String[] args) {
        EventManager eventManager = EventManager.getInstance();
        eventManager.initialiseModelDeleteOrganisers();
        eventManager.loadState();
        EventViewer eventViewer = EventViewer.getInstance();
        eventManager.modelModified();
        //eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().setText(eventManager.textViewData());
        //eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().setText(eventManager.hierarchalViewData());
    }
}
