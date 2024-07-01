/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Item;

/**
 *
 * @author tugoflaherty
 */
public class ItemTest {
    
    /**
     * This is a test method to create a series of eight hard-coded Item objects, testing that Item objects can be instantiated
     * Checks appropriate Item constructor and attributes are set correctly to allow a new Item to be instantiated
     * Takes in no parameters
     * Returns no values
     */
    public static void createItems() {
    Item welcomeTalk = new Item("09:00","Welcome and introductions");
    Item keynote = new Item("09:15","Keynote by Wes Streeting MP: Student Health During a Pandemic");
    Item coffeeBreak = new Item("10:15","Coffee break");
    Item markPresentation = new Item("10:30","Presentation by Professor Mark Fielder: Pandemic Lessons");
    Item andreaPresentation = new Item("11:30","Presentation by Professor Andrea Petroczi: Covid and Public Health");
    Item lunch = new Item("12:30","Lunch");
    Item posters = new Item("13:30","Posters and lightning talks with coffee");
    Item closing = new Item("15:00","Keynote and Closing Remarks with Larissa Kennedy, NUS President");
    }
    
    /**
     * This method tests whether an Item object can be instantiated, and that when it is instantiated, its attribute values are equal to those it was instantiated with, ensuring it is the same object
     * This method takes in no parameter values
     * @return This method returns boolean true if the Item object's attribute values match those that it was instantiated with, otherwise false
     */
    public static boolean testItemCreation() {
        Item welcomeTalk = new Item("09:00","Welcome and introductions");
        if (welcomeTalk.getStartTime().toString().equals("09:00") && welcomeTalk.getItemTitle().equals("Welcome and introductions")) {
            return true;
        }
        return false;
    }
}
