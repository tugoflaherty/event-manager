/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.viewtest;

import com.tugoflaherty.eventmanager.view.EventViewer;

/**
 *
 * @author tugoflaherty
 */
public class MainTest {

    /**
     * This is a test main method to create a new EventViewer instance to test the eventViewer has appropriate Swing components added correctly
     * @param args This is a String Array argument parameter value for the main method
     */
    public static void main(String[] args) {
        EventViewer eventViewer = EventViewer.getInstance();
    }
}
