/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Event;
import com.tugoflaherty.eventmanager.model.Item;
import com.tugoflaherty.eventmanager.model.Organiser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tugoflaherty
 */
public class EventTest {

    /**
     *This is a test method to create a series of eight hard-coded Event objects, testing that Event objects can be instantiated
     * Checks appropriate Event constructor and attributes are set correctly to allow a new Event to be instantiated
     * Takes in no parameters
     * Returns no values
     */
    public static void createEvents() {
        Organiser jamesDenholmPrice = new Organiser("James", "DenholmPrice");
        Organiser davidLivingstone = new Organiser("David", "Livingstone");
        List<Item> musicConcertItems = new ArrayList();
        List<Item> assessmentCentreItems = new ArrayList();
        musicConcertItems.add(new Item("16:00", "Check in to Wembley Arena"));
        musicConcertItems.add(new Item("17:00", "Watch support act"));
        musicConcertItems.add(new Item("18:00", "Watch main act"));
        musicConcertItems.add(new Item("20:00", "Catch last train home"));
        assessmentCentreItems.add(new Item("10:00", "Attend group interview"));
        assessmentCentreItems.add(new Item("11:00", "Attend individual interview"));
        assessmentCentreItems.add(new Item("12:00", "Present individual presentation on IBM challenges"));
        assessmentCentreItems.add(new Item("13:00", "Lunch break"));
        assessmentCentreItems.add(new Item("14:00", "Review session"));
        Event musicConcert = new Event("Attend Music Concert", jamesDenholmPrice, "16:00", "Wembley", musicConcertItems);
        Event assessmentCentre = new Event("IBM Assessment Centre", davidLivingstone, "10:00", "Epsom", assessmentCentreItems);
        Event scotlandHoliday = new Event("Holiday to Glasgow", jamesDenholmPrice, "09:15", "Glasgow");
        Event websiteDevelopment = new Event("Create website for Wagons Roll", davidLivingstone, "11:30", "Manchester");
        Event vaccinationBooster = new Event("Vaccination Booster", "10:15", "Lewisham");
        Event movieFilming = new Event("Film New Blockbuster Movie", "12:00", "Bristol");
    }
    
    /**
     * This method tests whether an Event object can be instantiated, and that when it is instantiated, its attribute values are equal to those it was instantiated with, ensuring it is the same object
     * This method takes in no parameter values
     * @return This method returns boolean true if the Event object's attribute values match those that it was instantiated with, otherwise false
     */
    public static boolean testEventCreation() {
        Organiser jamesDenholmPrice = new Organiser("James", "DenholmPrice");
        List<Item> assessmentCentreItems = new ArrayList();
        assessmentCentreItems.add(new Item("10:00", "Attend group interview"));
        assessmentCentreItems.add(new Item("11:00", "Attend individual interview"));
        assessmentCentreItems.add(new Item("12:00", "Present individual presentation on IBM challenges"));
        assessmentCentreItems.add(new Item("13:00", "Lunch break"));
        assessmentCentreItems.add(new Item("14:00", "Review session"));
        Event musicConcert = new Event("Attend Assessment Centre", jamesDenholmPrice, "2022-10-21T16:00", "Croydon", assessmentCentreItems);
        if (musicConcert.getTitle().equals("Attend Assessment Centre") && musicConcert.getOrganiser().equals(jamesDenholmPrice) && musicConcert.getDateTime().toString().equals("2022-10-21T16:00") && musicConcert.getLocation().equals("Croydon") && musicConcert.getItems().equals(assessmentCentreItems)) {
            return true;
        }
        return false;
    }
}
