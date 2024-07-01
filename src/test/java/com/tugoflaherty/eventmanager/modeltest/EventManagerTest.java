/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Event;
import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.model.Item;
import com.tugoflaherty.eventmanager.model.Organiser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tugoflaherty
 */
public class EventManagerTest {
    
    /**
     * This method tests the EventManager Singleton Pattern, ensuring only one instance of EventManager can be instantiated
     * This method takes in no parameter values
     * @return This returns boolean true if both eventManager instances are the same, i.e., only one eventManager object has been instantiated, otherwise false
     */
    public static boolean testSingletonEventManagerCreation() {
        EventManager eventManager = EventManager.getInstance();
        EventManager eventManager2 = EventManager.getInstance();
        return (eventManager==eventManager2);
    }
    
    /**
     * This method tests that the EventManager events ArrayList has been successfully created and is initially empty
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList has been initialised and is empty, otherwise false
     */
    public static boolean testEmptyEventManagerEventList() {
        EventManager eventManager = EventManager.getInstance();
        List<Event> eventManagerEventsList = eventManager.getEvents();
        return eventManagerEventsList.isEmpty();
    }
    
    /**
     * This method tests that the EventManager items ArrayList has been successfully created and is initially empty
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager items ArrayList has been initialised and is empty, otherwise false
     */
    public static boolean testEmptyEventManagerItemList() {
        EventManager eventManager = EventManager.getInstance();
        List<Item> eventManagerItemsList = eventManager.getItems();
        return eventManagerItemsList.isEmpty();
    }
    
    /**
     * This method tests that the EventManager organisers ArrayList has been successfully created and is initially empty
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager organisers ArrayList has been initialised and is empty, otherwise false
     */
    public static boolean testEmptyEventManagerOrganiserList() {
        EventManager eventManager = EventManager.getInstance();
        List<Organiser> eventManagerOrganisersList = eventManager.getOrganisers();
        return eventManagerOrganisersList.isEmpty();
    }
    
    /**
     * This method tests if an Event may be created and added to the EventManager events ArrayList with fully populated attributes
     * This method takes in no parameter values
     * @return This returns boolean true if the testEvent created is successfully added to the EventManager events ArrayList, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListAllAttributes() {
        EventManager eventManager = EventManager.getInstance();
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        List<Item> items = new ArrayList();
        items.add(new Item("09:00","Wake up"));
        items.add(new Item("10:00","Catch the bus"));
        items.add(new Item("11:00","Arrive at Kingston University"));
        items.add(new Item("12:00","Teach Programming"));
        items.add(new Item("17:00","Go home"));
        Event testEvent = new Event("Dave's Standard University Day",davidLivingstone,"2021-02-06T09:00","Kingston",items);
        return eventManager.getEvents().add(testEvent);
    }
    
    /**
     * This method tests if an Event may be created and added to the EventManager events ArrayList with no items attribute value
     * This method takes in no parameter values
     * @return This returns boolean true if the testEvent created is successfully added to the EventManager events ArrayList, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListNoItems() {
        EventManager eventManager = EventManager.getInstance();
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Event testEvent = new Event("James' Vaccination Booster",jamesDenholmPrice,"2020-05-12T15:00","Lewisham");
        return eventManager.getEvents().add(testEvent);
    }
    
    /**
     * This method tests if an Event may be created and added to the EventManager events ArrayList with no items and organiser attribute values
     * This method takes in no parameter values
     * @return This returns boolean true if the testEvent created is successfully added to the EventManager events ArrayList, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListNoItemsAndOrganiser() {
        EventManager eventManager = EventManager.getInstance();
        Event testEvent = new Event("Ahmed's Algorithm Workshop","2022-01-10T11:00","Manchester");
        return eventManager.getEvents().add(testEvent);
    }
    
    /**
     * This method tests if an Event has been created and added to the EventManager events ArrayList with fully populated attributes, that the EventManager events ArrayList is not empty
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList is not empty when the Event has been added, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListNotEmptyAllAttributes() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListAllAttributes();
        return !eventManager.getEvents().isEmpty();
    }
    
    /**
     * This method tests if an Event has been created and added to the EventManager events ArrayList with no items attribute value, that the EventManager events ArrayList is not empty
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList is not empty when the Event has been added, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListNotEmptyNoItems() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListNoItems();
        return !eventManager.getEvents().isEmpty();
    }
    
    /**
     * This method tests if an Event has been created and added to the EventManager events ArrayList with no items and organiser attribute values, that the EventManager events ArrayList is not empty
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList is not empty when the Event has been added, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListNotEmptyNoItemsAndOrganiser() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListNoItemsAndOrganiser();
        return !eventManager.getEvents().isEmpty();
    }
    
    /**
     * This method tests if when an Event has been created with fully populated attributes, and added to the EventManager events ArrayList, the events ArrayList contains the added Event object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList contains the Event object when the Event has been added, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListContainsAllAttributes() {
        EventManager eventManager = EventManager.getInstance();
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        List<Item> items = new ArrayList();
        items.add(new Item("09:00","Wake up"));
        items.add(new Item("10:00","Catch the bus"));
        items.add(new Item("11:00","Arrive at Kingston University"));
        items.add(new Item("12:00","Teach Programming"));
        items.add(new Item("17:00","Go home"));
        Event testEvent = new Event("Dave's Standard University Day",davidLivingstone,"2021-02-06T09:00","Kingston",items);
        eventManager.getEvents().add(testEvent);
        return eventManager.getEvents().contains(testEvent);
    }
    
    /**
     * This method tests if when an Event has been created with no items attribute value, and added to the EventManager events ArrayList, the events ArrayList contains the added Event object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList contains the Event object when the Event has been added, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListContainsNoItems() {
        EventManager eventManager = EventManager.getInstance();
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Event testEvent = new Event("James' Vaccination Booster",jamesDenholmPrice,"2020-05-12T15:00","Lewisham");
        eventManager.getEvents().add(testEvent);
        return eventManager.getEvents().contains(testEvent);
    }
    
    /**
     * This method tests if when an Event has been created with no items and organiser attribute values, and added to the EventManager events ArrayList, the events ArrayList contains the added Event object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList contains the Event object when the Event has been added, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListContainsNoItemsAndOrganiser() {
        EventManager eventManager = EventManager.getInstance();
        Event testEvent = new Event("Ahmed's Algorithm Workshop","2022-01-10T11:00","Manchester");
        eventManager.getEvents().add(testEvent);
        return eventManager.getEvents().contains(testEvent);
    }
    
    /**
     * This method checks that when an Event object has been created and added to the EventManager events ArrayList, that the ArrayList size has increased by the number of events added
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList size has increased by the number of Event objects added to it, otherwise false
     */
    public static boolean testAddEventToEventManagerEventListSize() {
        EventManager eventManager = EventManager.getInstance();
        int currentEventListSize = eventManager.getEvents().size();
        EventManagerTest.testAddEventToEventManagerEventListAllAttributes();
        EventManagerTest.testAddEventToEventManagerEventListNoItems();
        EventManagerTest.testAddEventToEventManagerEventListNoItemsAndOrganiser();
        if (eventManager.getEvents().size() == currentEventListSize + 3) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Event has been removed from the EventManager events ArrayList, the EventManager events ArrayList does not contain the Event object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList does not contain the Event object that has been deleted from it, otherwise false
     */
    public static boolean testDeleteEventFromEventManagerEventListDoesNotContain() {
        EventManager eventManager = EventManager.getInstance();
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        List<Item> items = new ArrayList();
        items.add(new Item("09:00","Wake up"));
        items.add(new Item("10:00","Catch the bus"));
        items.add(new Item("11:00","Arrive at Kingston University"));
        items.add(new Item("12:00","Teach Programming"));
        items.add(new Item("17:00","Go home"));
        Event testEvent0 = new Event("Dave's Standard University Day",davidLivingstone,"2021-02-06T09:00","Kingston",items);
        eventManager.getEvents().add(testEvent0);
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Event testEvent1 = new Event("James' Vaccination Booster",jamesDenholmPrice,"2020-05-12T15:00","Lewisham");
        eventManager.getEvents().add(testEvent1);
        Event testEvent2 = new Event("Ahmed's Algorithm Workshop","2022-01-10T11:00","Manchester");
        eventManager.getEvents().add(testEvent2);
        eventManager.deleteEvent(1);
        return !eventManager.getEvents().contains(testEvent1);
    }
    
    /**
     * This method tests that when an Event has been removed from the EventManager events ArrayList, the EventManager events ArrayList size has decreased by the number of Event objects removed
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList size has decreased by the number of Event objects removed, otherwise false
     */
    public static boolean testDeleteEventFromEventManagerEventListSize() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListAllAttributes();
        EventManagerTest.testAddEventToEventManagerEventListNoItems();
        EventManagerTest.testAddEventToEventManagerEventListNoItemsAndOrganiser();
        int currentEventListSize = eventManager.getEvents().size();
        eventManager.deleteEvent(2);
        if (eventManager.getEvents().size() == currentEventListSize -1) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that an Item can be created and added to the EventManager items ArrayList
     * This method takes in no parameter values
     * @return This returns boolean true if the Item has been successfully created and added to the EventManager items ArrayList, otherwise false
     */
    public static boolean testAddItemToEventManagerItemList() {
        EventManager eventManager = EventManager.getInstance();
        return eventManager.addItem("15:00","Presentation by guest Professor Graeme Jones");
    }
    
    /**
     * This method tests that that an Item created and added to the EventManager item ArrayList is contained within the ArrayList
     * This method takes in no parameter values
     * @return This returns boolean true if the Item created and added to the EventManager item ArrayList is contained within the ArrayList, otherwise false
     */
    public static boolean testAddItemToEventManagerItemListContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Welcome audience to conference");
        if (eventManager.getItems().get(eventManager.getItems().size()-1).getItemTitle().equals("Welcome audience to conference")) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that an Item created and added to the EventManager item ArrayList increases the size of the ArrayList by one
     * This method takes in no parameter values
     * @return This returns boolean true if the Item created and added to the EventManager item ArrayList increases the ArrayList size by one, otherwise false
     */
    public static boolean testAddItemToEventManagerItemListSize() {
        EventManager eventManager = EventManager.getInstance();
        int currentItemListSize = eventManager.getItems().size();
        EventManagerTest.testAddItemToEventManagerItemList();
        if (eventManager.getItems().size() == currentItemListSize + 1) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Item is deleted from the EventManager items ArrayList, the ArrayList does not contain the Item deleted
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager items ArrayList does not contain the Item object when it is deleted, otherwise false
     */
    public static boolean testDeleteItemFromEventManagerItemListDoesNotContain() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Wake up");
        eventManager.addItem("10:00","Catch the bus");
        eventManager.addItem("11:00","Arrive at Kingston University");
        eventManager.deleteItem(1);
        return !eventManager.getItems().get(1).getItemTitle().equals("Catch the bus");
    }
    
    /**
     * This method tests that when an Item is deleted from the EventManager items ArrayList, the ArrayList size is reduced by one to reflect that one item has been deleted
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager items ArrayList size has reduced by one after an Item object has been deleted, otherwise false
     */
    public static boolean testDeleteItemFromEventManagerItemListSize() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("9:00","Wake up");
        eventManager.addItem("10:00","Catch the bus");
        eventManager.addItem("11:00","Arrive at Kingston University");
        int previousSize = eventManager.getItems().size();
        eventManager.deleteItem(1);
        if (eventManager.getItems().size() == previousSize - 1) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Item is deleted from the EventManager items ArrayList, the ArrayList size reduces by one
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager items ArrayList size reduces by one when an Item object is deleted, otherwise false
     */
    public static boolean testDeleteEventToEventManagerItemListSize() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Wake up");
        eventManager.addItem("10:00","Catch the bus");
        eventManager.addItem("11:00","Arrive at Kingston University");
        int currentItemListSize = eventManager.getItems().size();
        eventManager.deleteItem(1);
        if (eventManager.getItems().size() == currentItemListSize -1) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Event object is created without an organiser attribute value, and an Organiser is subsequently associated with the Event, the Event organiser attribute value is not null
     * This method takes in no parameter values
     * @return This returns boolean true if the Event object organiser attribute value was previously null, and now is not null, otherwise false
     */
    public static boolean testAssociateOrganiserToEventNull() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Kingston University Open Day","2022-02-06T09:00","Kingston");
        Organiser previousOrganiser = eventManager.getEvents().get(0).getOrganiser();
        eventManager.addOrganiser("David","Livingstone");
        eventManager.associateOrganiserToEvent(0,0);
        if (previousOrganiser == null && eventManager.getEvents().get(0).getOrganiser() != null) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Event object is created without an organiser attribute value, and an Organiser is subsequently associated with the Event, the Event organiser attribute value is that of the associated Organiser object
     * This method takes in no parameter values
     * @return This returns boolean true if the Event object organiser attribute value is now that of the associated Organiser object
     */
    public static boolean testAssociateOrganiserToEventContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Kingston University Open Day","2022-02-06T09:00","Kingston");
        eventManager.addOrganiser("David","Livingstone");
        eventManager.associateOrganiserToEvent(0,0);
        if (eventManager.getEvents().get(0).getOrganiser().getFirstName().equals("David")) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Item objects are created and added to to an Event items attribute, the Event items attribute is not null
     * This method takes in no parameter values
     * @return This returns boolean true if the Event object items attribute value is not null after adding Item objects to it, otherwise false
     */
    public static boolean testAddItemsToEventNull() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Database-Driven Application Development Assessment","2022-02-17T09:00","Worcester Park");
        List<Item> currentItems = eventManager.getEvents().get(0).getItems();
        eventManager.addItem("09:00","Exam Briefing");
        eventManager.addItem("10:00","Students Enter Exam Hall");
        eventManager.addItem("11:00","Exam Starts");
        eventManager.addItem("15:00","Exam Ends");
        eventManager.addItemsToEvent(0);
        //System.out.println("Current Items:" + currentItems.size() + currentItems.toString());
        //System.out.println("EventManager Items:" + eventManager.getItems().size() + eventManager.getItems().toString());
        //System.out.println("Event(0) Items:" + eventManager.getEvents().get(0).getItems().size() + eventManager.getEvents().get(0).getItems().toString());
        if (currentItems.isEmpty() && eventManager.getEvents().get(0).getItems().size() == 4) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that when an Item objects are created and added to an Event object items attribute, the items attribute contains the added Item objects
     * This method takes in no parameter values
     * @return This returns boolean true if the Event object items attribute contains the added Item objects, otherwise false
     */
    public static boolean testAddItemsToEventContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Database-Driven Application Development Assessment","2022-02-17T09:00","Worcester Park");
        List<Item> currentItems = eventManager.getEvents().get(0).getItems();
        eventManager.addItem("09:00","Exam Briefing");
        eventManager.addItem("10:00","Students Enter Exam Hall");
        eventManager.addItem("11:00","Exam Starts");
        eventManager.addItem("15:00","Exam Ends");
        eventManager.addItemsToEvent(0);
        if (currentItems.isEmpty() && eventManager.getEvents().get(0).getItems().get(0).getItemTitle().equals("Exam Briefing")) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that the String title, String dateTime, and String location attribute values for an Event object can be edited and now contain the new attribute values
     * This method takes in no parameter values
     * @return This returns boolean true if the Event title, dateTime and location attribute values contain the new values provided, otherwise false
     */
    public static boolean testEditEventDetailsAllFields() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Computing Systems Assessment","2022-05-02T17:00","New Malden");
        eventManager.editEventDetails(0,"Programming Assignment","2022-05-02T18:00","Chessington");
        Event editedEvent = eventManager.getEvents().get(0);
        if (editedEvent.getTitle().equals("Programming Assignment") && editedEvent.getDateTime().toString().equals("2022-05-02T18:00") && editedEvent.getLocation().equals("Chessington")) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that the String title and String location attribute values for an Event object can be edited and now contain the new attribute values
     * This method takes in no parameter values
     * @return This returns boolean true if the Event title and location attribute values contain the new values provided, otherwise false
     */
    public static boolean testEditEventDetailsWithoutDate() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Computing Systems Assessment","2022-05-02T17:00","New Malden");
        eventManager.editEventDetails(0,"Programming Assignment","","Chessington");
        Event editedEvent = eventManager.getEvents().get(0);
        if (editedEvent.getTitle().equals("Programming Assignment") && editedEvent.getDateTime().toString().equals("2022-05-02T17:00") && editedEvent.getLocation().equals("Chessington")) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that the Organisers read file method is working, and that the size of the EventManager organisers ArrayList increases in size with new Organiser objects after the method is run
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager organiser ArrayList has increased after the Organisers read file method has been run, otherwise false
     */
    public static boolean testReadOrganisersFile() {
        EventManager eventManager = EventManager.getInstance();
        int currentOrganiserNumber = eventManager.getOrganisers().size();
        //System.out.println(eventManager.getOrganisers().toString());
        eventManager.readOrganisersFile("Organisers.csv");
        //System.out.println(eventManager.getOrganisers().toString());
        if (eventManager.getOrganisers().size() > currentOrganiserNumber) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that the Events read file method is working, and that the size of the EventManager events ArrayList increases in size with new Event objects after the method is run
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager events ArrayList has increased after the Events read file method has been run, otherwise false
     */
    public static boolean testReadEventsFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.readOrganisersFile("Organisers.csv");
        int currentEventNumber = eventManager.getEvents().size();
        //System.out.println(eventManager.getEvents().toString());
        eventManager.readEventsFile("Events.csv");
        //System.out.println(eventManager.getEvents().toString());
        if (eventManager.getEvents().size() > currentEventNumber) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that the Items read file method is working, and that the size of the first Event items attribute increases in size with new Item objects after the method is run
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the first Event items attribute has increased after the Items read file method has been run, otherwise false
     */
    public static boolean testReadItemsFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.readOrganisersFile("Organisers.csv");
        eventManager.readEventsFile("Events.csv");
        int eventZeroCurrentItemNumber = eventManager.getEvents().get(0).getItems().size();
        /*for (Event e : eventManager.getEvents()) {
            System.out.println(e.getItems().toString());
        }*/
        eventManager.readItemsFile("Items.csv");
        /*for (Event e : eventManager.getEvents()) {
            System.out.println(e.getItems().toString());
        }*/
        if (eventManager.getEvents().get(0).getItems().size() > eventZeroCurrentItemNumber) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that the Config read file method is working, and that the size of the EventManager events and organisers ArrayList, and first Event object items ArrayList attribute is greater than 0
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager events and organiser ArrayLists and first Event object items ArrayList is greater than 0, otherwise false
     */
    public static boolean testReadConfigFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.readConfigFile("Config.csv");
        /*for (Organiser o : eventManager.getOrganisers()) {
            System.out.println(o.toString());
        }
        for (Event e : eventManager.getEvents()) {
            System.out.println(e.toString());
        }
        for (Event e : eventManager.getEvents()) {
            System.out.println(e.getItems().toString());
        }*/
        if (eventManager.getOrganisers().size() > 0 && eventManager.getEvents().size() > 0 && eventManager.getEvents().get(0).getItems().size() > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests if the Config write file method is working, and that once the Config file is written out, it is read in and can populate the EventManager model with Event, Organiser and Item objects
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager events and organiser ArrayLists and first Event object items ArrayList is greater than 0, otherwise false
     */
    public static boolean testWriteConfigFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.writeConfigFile("ConfigTest.csv");
        eventManager.readConfigFile("ConfigTest.csv");
        if (eventManager.getOrganisers().size() > 0 && eventManager.getEvents().size() > 0 && eventManager.getEvents().get(0).getItems().size() > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests if the Organisers write file method is working, and that once the Organisers file is written out, it is read in and can populate the EventManager model with Organiser objects
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager organiser ArrayLists file doubles in size when the Organisers file is written out and read in, otherwise false
     */
    public static boolean testWriteOrganisersFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.readOrganisersFile("Organisers.csv");
        eventManager.writeOrganisersFile("OrganisersTest.csv");
        int previousOrganiserCount = eventManager.getOrganisers().size();
        eventManager.readOrganisersFile("OrganisersTest.csv");
        if (eventManager.getOrganisers().size() == previousOrganiserCount*2) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests if the Events write file method is working, and that once the Events file is written out, it is read in and can populate the EventManager model with Event objects
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager events ArrayLists file size when the file was read in is equal to the number of Event objects before the file was read in, otherwise false
     */
    public static boolean testWriteEventsFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.readOrganisersFile("Organisers.csv");
        eventManager.readEventsFile("Events.csv");
        eventManager.writeEventsFile("EventsTest.csv");
        int previousEventCount = eventManager.getEvents().size();
        eventManager.readEventsFile("EventsTest.csv");
        if (eventManager.getEvents().size() == previousEventCount) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests if the Items write file method is working, and that once the Items file is written out, it is read in and can populate the relevant Event object items attribute with Item objects
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the first Event object items attribute is double that of the initial items attribute size, otherwise false
     */
    public static boolean testWriteItemsFile() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.readOrganisersFile("Organisers.csv");
        eventManager.readEventsFile("Events.csv");
        eventManager.readItemsFile("Items.csv");
        eventManager.writeItemsFile("ItemsTest.csv");
        int eventZeroCount = eventManager.getEvents().get(0).getItems().size();
        eventManager.readItemsFile("ItemsTest.csv");
        for (int i=0; i<eventManager.getEvents().size(); i++) {
            System.out.println(eventManager.getEvents().get(i).getItems().toString());
        }
        if (eventManager.getEvents().get(0).getItems().size() == eventZeroCount*2) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that duplicate Organiser objects are not able to be added to the EventManager organisers ArrayList, based on ArrayList size
     * This method takes in no parameter values
     * @return This returns boolean true if the size of the EventManager organisers ArrayList is one after two duplicate Organiser objects have been added, otherwise false
     */
    public static boolean testAddDuplicateOrganisersSize() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addOrganiser("Paul","Neve");
        eventManager.addOrganiser("Paul","Neve");
        if (eventManager.getOrganisers().size() == 1) {
            return true;
        }
        return false;
    }
    
    /**
     * This method tests that duplicate Organiser objects are not able to be added to the EventManager organisers ArrayList, based on the ArrayList containing the duplicate Organiser object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager organisers ArrayList has a size of two, and the first Organiser object is equal to the second Organiser object, otherwise false
     */
    public static boolean testAddDuplicateOrganisersContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addOrganiser("Paul","Neve");
        eventManager.addOrganiser("Paul","Neve");
        if (eventManager.getOrganisers().size() == 2) {
            return (eventManager.getOrganisers().get(0).equals(eventManager.getOrganisers().get(1)));
        }
        return true;
    }
    
    /**
     * This method tests that duplicate Item objects are not able to be added to the EventManager items ArrayList, based on ArrayList size
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager items ArrayList has a size of one after two duplicate Item objects have been added, otherwise false
     */
    public static boolean testAddDuplicateItemsSize() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Do Work");
        eventManager.addItem("09:00","Do Work");
        if (eventManager.getItems().size() == 1) {
            return true;
        }
        return false;
    }
    
    /**
     * The method tests that duplicate Item objects are not able to be added to the EventManager items ArrayList, based on the ArrayList containing the duplicate Item object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager items ArrayList has a size of two, and the first Item object is equal to the second Item object, otherwise false
     */
    public static boolean testAddDuplicateItemsContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Do Work");
        eventManager.addItem("09:00","Do Work");
        if (eventManager.getItems().size() == 2) {
            return (eventManager.getItems().get(0).equals(eventManager.getItems().get(1)));
        }
        return true;
    }
    
    /**
     * This method tests that duplicate Event objects are not able to be added to the EventManager events ArrayList, based on ArrayList size
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList has a size of one after two duplicate Event objects have been added, otherwise false
     */
    public static boolean testAddDuplicateEventsSize() {
    EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Vaccination Booster","2022-02-08T12:32","Kingston");
        eventManager.addEvent("Vaccination Booster","2022-02-08T12:32","Kingston");
        if (eventManager.getEvents().size() == 1) {
            return true;
        }
        return false;
    }
    
    /**
     * The method tests that duplicate Event objects are not able to be added to the EventManager events ArrayList, based on the ArrayList containing the duplicate Event object
     * This method takes in no parameter values
     * @return This returns boolean true if the EventManager events ArrayList has a size of two, and the first Event object is equal to the second Event object, otherwise false
     */
    public static boolean testAddDuplicateEventsContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addEvent("Vaccination Booster","2022-02-08T12:32","Kingston");
        eventManager.addEvent("Vaccination Booster","2022-02-08T12:32","Kingston");
        if (eventManager.getEvents().size() == 2) {
            return (eventManager.getEvents().get(0).equals(eventManager.getEvents().get(1)));
        }
        return true;
    }
    
    /**
     * This method tests that the textViewData method is working correctly, and is returning the appropriate String text to display on the TextView of the EventViewer
     * This method takes in no parameter values
     * @return This returns the String value of the textViewData method being run
     */
    public static String testTextViewData() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.loadState();
        return eventManager.textViewData();
    }
    
    /**
     * This method tests that the hierarchalViewData method is working correctly, and is returning the appropriate String text to display on the HierarchalView of the EventViewer
     * This method takes in no parameter values
     * @return This returns the String value of the hierarchalViewData method being run
     */
    public static String testHierarchalViewData() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.loadState();
        return eventManager.hierarchalViewData();
    }
}
