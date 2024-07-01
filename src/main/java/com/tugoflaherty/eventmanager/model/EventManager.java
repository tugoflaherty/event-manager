/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import com.tugoflaherty.eventmanager.view.EventViewer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tugoflaherty
 */
public class EventManager {

    private static EventManager INSTANCE = new EventManager();
    private List<Event> events = new ArrayList();
    private List<Item> items = new ArrayList();
    private List<Organiser> organisers = new ArrayList();
    
    /**
     * This method is a getter to return the events attribute as type List of Event objects
     * It takes in no parameters
     * @return This returns the events of type List of Event objects
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * This method is a setter to set the value of the events attribute using a value of type List of Event objects
     * It does not return a value
     * @param events This is the value of the events attribute to be set of type List of Event objects
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * This method is a getter to return the items attribute as type List of Item objects
     * It takes in no parameters
     * @return This returns the items of type List of Item objects
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * This method is a setter to set the value of the items attribute using a value of type List of Item objects
     * It does not return a value
     * @param items This is the value of the items attribute to be set of type List of Item objects
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * This method is a getter to return the organisers attribute as type List of Organiser objects
     * It takes in no parameters
     * @return This returns the organisers of type List of Organiser objects
     */
    public List<Organiser> getOrganisers() {
        return organisers;
    }

    /**
     * This method is a setter to set the value of the organisers attribute using a value of type List of Organiser objects
     * It does not return a value
     * @param organisers This is the value of the organisers attribute to be set of type List of Organiser objects
     */
    public void setOrganisers(List<Organiser> organisers) {
        this.organisers = organisers;
    }
    
    private EventManager() {
        
    }
    
    /**
     * This method uses a Singleton Pattern to create an instance of EventManager if one does not already exist, but if one already exists, return that instance
     * Ensures only one instance of EventManager can be instantiated throughout the application
     * This does not take any parameters
     * @return This returns the singular instance of an EventManager object
     */
    public static EventManager getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new EventManager();
            //System.out.println("New EventManager instance created");
        }
        //System.out.println("Using the first EventManager instance created");
        return INSTANCE;
    }
    
    /**
     * This method creates a new Event object with the a String title, Organiser organiser, String dateTime, String location and List of Item objects, if the title and location values do not contain a comma, and adds it to the Events ArrayList in EventManager, returning a boolean true if the Event has been added, otherwise false
     * @param title This is the value of the title attribute to be set of type String
     * @param organiser This is the value of the organiser attribute to be set of type Organiser
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @param location This is the value of the location attribute to be set of type String
     * @param items This is the value of the items attribute to be set of type List of Item objects
     * @return This returns a boolean value of true if the event was successfully created and added to the EventManager, otherwise false
     */
    public boolean addEvent(String title, Organiser organiser, String dateTime, String location, List<Item> items) {
        if (!title.contains(",") && !location.contains(",")) {
            Event newEvent = new Event(title, organiser, dateTime, location, items);
            if (!this.getEvents().contains(newEvent)) {
                return this.getEvents().add(newEvent);
            }
        }
        return false;
    }
    
    /**
     * This method creates a new Event object with the a String title, Organiser organiser, String dateTime, and String location, if the title and location values do not contain a comma, and adds it to the Events ArrayList in EventManager, returning a boolean true if the Event has been added, otherwise false
     * @param title This is the value of the title attribute to be set of type String
     * @param organiser This is the value of the organiser attribute to be set of type Organiser
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @param location This is the value of the location attribute to be set of type String
     * @return This returns a boolean value of true if the event was successfully created and added to the EventManager, otherwise false
     */
    public boolean addEvent(String title, Organiser organiser, String dateTime, String location) {
        if (!title.contains(",") && !location.contains(",")) {
            Event newEvent = new Event(title, organiser, dateTime, location);
            if (!this.getEvents().contains(newEvent)) {
                return this.getEvents().add(newEvent);
            }
        }
        return false;
    }
    
    /**
     * This method creates a new Event object with the a String title, String dateTime, and String location, if the title and location values do not contain a comma, and adds it to the Events ArrayList in EventManager, returning a boolean true if the Event has been added, otherwise false
     * @param title This is the value of the title attribute to be set of type String
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @param location This is the value of the location attribute to be set of type String
     * @return This returns a boolean value of true if the event was successfully created and added to the EventManager, otherwise false
     */
    public boolean addEvent(String title, String dateTime, String location) {
        if (!title.contains(",") && !location.contains(",")) {
            Event newEvent = new Event(title, dateTime, location);
            if (!this.getEvents().contains(newEvent)) {
                return this.getEvents().add(newEvent);
            }
        }
        return false;
    }
    
    /**
     * This method takes in an int eventIndex and removes the Event object at that index in the EventManager events ArrayList, deleting the Event object and returning boolean true if deleted, otherwise false
     * @param eventIndex This is the value of the index in the EventManager events ArrayList of the item to delete
     * @return This returns boolean true if the event was removed from the EventManager events ArrayList, otherwise false
     */
    public boolean deleteEvent(int eventIndex) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            this.getEvents().remove(eventIndex);
            return true;
        }
        return false;
    }
    
    /**
     * This method creates a new Item object using the supplied String startTime and String itemTitle parameter values, and adds this item to the EventManager items ArrayList
     * @param startTime This is the String item start time value
     * @param itemTitle This is the String item title value
     * @return This returns boolean true if the Item was successfully created and added to the EventManager items ArrayList, otherwise false
     */
    public boolean addItem(String startTime, String itemTitle) {
        if (!itemTitle.contains(",")) {
            Item newItem = new Item(startTime, itemTitle);
            if (!this.getItems().contains(newItem)) {
                return this.getItems().add(newItem);
            }
        }
        return false;
    }
    
    /**
     * This method deletes an Item object from the items ArrayList in EventManager based on the specified item index, returning true if the item has been deleted, otherwise false
     * @param itemIndex This is the int index of the item to delete from the ArrayList
     * @return This is the return boolean value, true if the item object has been deleted from the EventManager ArrayList, otherwise false
     */
    public boolean deleteItem(int itemIndex) {
        if (this.getItems().size() > 0 && this.getItems().size() >= itemIndex) {
            this.getItems().remove(itemIndex);
            return true;
        }
        return false;
    }
    
    /**
     * This method creates a new Organiser object and adds it to the EventManager organisers ArrayList if the passed String firstName and String lastName parameter values do not contain commas, and returns boolean true if added, otherwise false
     * @param firstName This is the String firstName of the Organiser
     * @param lastName This is the String lastName of the Organiser
     * @return This is the boolean return value, true if the Organiser object has been created and added to the EventManager organisers ArrayList, otherwise false
     */
    public boolean addOrganiser(String firstName, String lastName) {
        if (!firstName.contains(",") && !lastName.contains(",")) {
            Organiser newOrganiser = new Organiser(firstName, lastName);
            if (!this.getOrganisers().contains(newOrganiser)) {
                return this.getOrganisers().add(newOrganiser);
            }
        }
        return false;
    }
    
    /**
     * This method deletes an Organiser object from the organisers ArrayList in EventManager based on the specified organiser index, returning true if the organiser has been deleted, otherwise false
     * @param organiserIndex This is the int index of the organiser to delete from the ArrayList
     * @return This is the return boolean value, true if the organiser object has been deleted from the EventManager ArrayList, otherwise false
     */
    public boolean deleteOrganiser(int organiserIndex) {
        if (this.getOrganisers().size() > 0 && this.getOrganisers().size() >= organiserIndex) {
            this.getOrganisers().remove(organiserIndex);
            return true;
        }
        return false;
    }
    
    /**
     * This method sets the organiser attribute value of type Organiser for an Event at the int eventIndex parameter value in the EventManager events ArrayList to the Organiser at the int organiserIndex parameter value at the EventManager organisers ArrayList, returns boolean true if value was set, otherwise false
     * @param eventIndex This is the int value of the Event object's index in the EventManager events ArrayList
     * @param organiserIndex This is the int value of the Organiser object's index in the EventManager organisers ArrayList
     * @return This returns boolean true if the Event object's organiser attribute value was set, otherwise false
     */
    public boolean associateOrganiserToEvent(int eventIndex, int organiserIndex) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex && this.getOrganisers().size() > 0 && this.getOrganisers().size() >= organiserIndex) {
            Event selectedEvent = this.getEvents().get(eventIndex);
            Organiser selectedOrganiser = this.getOrganisers().get(organiserIndex);
            selectedEvent.setOrganiser(selectedOrganiser);
            return true;
        }
        return false;
    }
    
    /**
     * This method adds the contents of the EventManager items ArrayList to the event of type Event items ArrayList at the int eventIndex value in the EventManager events ArrayList and then clears the EventManager items ArrayList, returns boolean true if items added to event, otherwise false 
     * @param eventIndex This is the int value of the Event object's index in the EventManager events ArrayList
     * @return This returns boolean true if the Event object's items attribute value was set, otherwise false
     */
    public boolean addItemsToEvent(int eventIndex) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            this.getEvents().get(eventIndex).setItems(new ArrayList<Item>(this.getItems()));
            this.getItems().clear();
            return true;
        }
        return false;
    }
    
    /**
     * This method creates a new instance of Item from the String startTime and String itemTitle parameter values and adds it to the items ArrayList for the Event object at the int eventIndex parameter value in the EventManager events ArrayList, returning true if the new Item has been created and added, otherwise false
     * @param eventIndex This is the int value of the Event object's index in the EventManager events ArrayList
     * @param startTime This is the String value of the startTime attribute for the Item instance to be created
     * @param itemTitle This is the String value of the itemTitle attribute for the Item instance to be created
     * @return This returns boolean true if the Item object has been instantiated and added to the EventManager events ArrayList, otherwise false
     */
    public boolean addItemsToEvent(int eventIndex, String startTime, String itemTitle) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            this.getEvents().get(eventIndex).addItem(new Item(startTime,itemTitle));
            return true;
        }
        return false;
    }
    
    /**
     * This method sets the title and/or dateTime and/or location attribute values for the Event object at the specified int eventIndex index of the EventManager events ArrayList based on the inputted String parameter values
     * @param eventIndex This is the int value of the Event object's index in the EventManager events ArrayList
     * @param title This is the String value of the title attribute for the Event instance to be replaced
     * @param dateTime This is the String value of the dateTime attribute for the Item instance to be replaced
     * @param location This is the String value of the location attribute for the Item instance to be replaced
     * @return This returns boolean true if the Event object has been edited in the EventManager events ArrayList, otherwise false
     */
    public boolean editEventDetails(int eventIndex, String title, String dateTime, String location) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            Event selectedEvent = this.getEvents().get(eventIndex);
            if (title.equals("") && dateTime.equals("") && location.equals("")) {
                return false;
            }
            else {
                if (!title.equals("")) {
                    selectedEvent.setTitle(title);
                }
                if (!dateTime.equals("T")) {
                    selectedEvent.setDateTime(dateTime);
                }
                if (!location.equals("")) {
                    selectedEvent.setLocation(location);
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method reads in the initialisation 'Config' file for the application, to populate the application with saved Events, Items and Organisers
     * The 'Config' file contains the file paths of the Organisers, Events and Items files, and this method calls the respective method to load in the relevant objects
     * This method does not return a value
     * @param filePath This is the String value of the file path of the 'Config' file to load in
     */
    public void readConfigFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String fileList[] = line.trim().split(",");
                this.readOrganisersFile(fileList[0]);
                this.readEventsFile(fileList[1]);
                this.readItemsFile(fileList[2]);
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Config file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method reads in the Organisers file for the application, to populate the application with saved Organisers
     * The Organisers file contains the saved Organiser objects, and this method calls the constructs these relevant Organisers from the file data
     * This method does not return a value
     * @param filePath This is the String value of the file path of the Organisers file to load in
     */
    public void readOrganisersFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String organiserList[] = line.trim().split(",");
                this.addOrganiser(organiserList[0],organiserList[1]);
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Organisers file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method reads in the Events file for the application, to populate the application with saved Events
     * The Events file contains the saved Event objects, and this method calls the constructs these relevant Events from the file data
     * This method does not return a value
     * @param filePath This is the String value of the file path of the Events file to load in
     */
    public void readEventsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String eventList[] = line.trim().split(",");
                if (eventList[1].equals("null") ) {
                    this.addEvent(eventList[0],eventList[2],eventList[3]);
                }
                else {
                    this.addEvent(eventList[0],this.getOrganisers().get(Integer.parseInt(eventList[1])),eventList[2],eventList[3]);
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Events file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method reads in the Items file for the application, to populate the application's Events with saved Items
     * The Items file contains the saved Item objects, and this method calls the constructs these relevant Items from the file data
     * This method does not return a value
     * @param filePath This is the String value of the file path of the Items file to load in
     */
    public void readItemsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String itemList[] = line.trim().split(",");
                if (itemList.length !=0 && !itemList[0].equals("")) {
                    this.addItemsToEvent(Integer.parseInt(itemList[0]),itemList[1],itemList[2]);
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Items file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method writes out the initialisation 'Config' file for the application, to save the application's Events, Items and Organisers (file locations) for re-initialisation
     * The 'Config' file contains the file paths of the Organisers, Events and Items files
     * This method does not return a value
     * @param filePath This is the String value of the file path of the 'Config' file to save the file to
     */
    public void writeConfigFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+".csv"))) {
            String line = filePath+"Organisers.csv,"+filePath+"Events.csv,"+filePath+"Items.csv";
            bWriter.write(line);
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Config file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method writes out the Organisers file for the application, to save the application's Organiser objects for re-initialisation
     * The Organisers file contains the stored Organiser objects in a CSV format, with the attributes for each Organiser, and a new line per Organiser
     * This method does not return a value
     * @param filePath This is the String value of the file path of the Organisers file to save the file to
     */
    public void writeOrganisersFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+"Organisers.csv"))) {
            for (int i=0; i<this.getOrganisers().size(); i++) {
                String line = this.getOrganisers().get(i).getFirstName() + "," + this.getOrganisers().get(i).getLastName();
                bWriter.write(line);
                if (i != this.getOrganisers().size() - 1) {
                    bWriter.newLine();
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Organisers file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method writes out the Events file for the application, to save the application's Event objects for re-initialisation
     * The Events file contains the stored Event objects in a CSV format, with the attributes for each Event, and a new line per Event
     * This method does not return a value
     * @param filePath This is the String value of the file path of the Events file to save the file to
     */
    public void writeEventsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+"Events.csv"))) {
            for (int i=0; i<this.getEvents().size(); i++) {
                if (this.getEvents().get(i).getOrganiser() != null) {
                    String line = this.getEvents().get(i).getTitle() + "," + this.getOrganisers().indexOf(this.getEvents().get(i).getOrganiser()) + "," + this.getEvents().get(i).getDateTime().toString() + "," + this.getEvents().get(i).getLocation();
                    bWriter.write(line);
                }
                else {
                    String line = this.getEvents().get(i).getTitle() + "," + "null" + "," + this.getEvents().get(i).getDateTime().toString() + "," + this.getEvents().get(i).getLocation();
                    bWriter.write(line);
                }
                if (i != this.getEvents().size() - 1) {
                    bWriter.newLine();
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Events file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method writes out the Items file for the application, to save the application's Item objects for re-initialisation
     * The Items file contains the stored Item objects for each Event object in a CSV format, with the attributes for each Item, and a new line per Item
     * This method does not return a value
     * @param filePath This is the String value of the file path of the Items file to save the file to
     */
    public void writeItemsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+"Items.csv"))) {
            for (int i=0; i<this.getEvents().size(); i++) {
                for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                    if (!this.getEvents().get(i).getItems().isEmpty()) {
                        String line = i + "," + this.getEvents().get(i).getItems().get(j).getStartTime().toString() + "," + this.getEvents().get(i).getItems().get(j).getItemTitle();
                        bWriter.write(line);
                    }
                    //if ((!this.getEvents().get(i).getItems().isEmpty()) && (i != this.getEvents().size()-1) && (j != this.getEvents().get(this.getEvents().size()-1).getItems().size()-1)) {
                        bWriter.newLine();
                    //}
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Items file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    /**
     * This method writes out the State file for the application, to store the last saved file, for application re-initialisation with the last saved state
     * The state file is always stored at _EventManagerLastOpenedState_.csv, relative to the application, and contains the file path of the last saved file
     * The method returns no values
     * @param lastSavedPath This is the String file path of the last saved file
     */
    public void saveState(String lastSavedPath) {
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter("_EventManagerLastOpenedState_.csv"))) {
            if (!lastSavedPath.isBlank()) {
                String line = lastSavedPath + ".csv";
                bWriter.write(line);
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing State file");	 	  	 	        	     	
        }
    }
    
    /**
     * This method loads in the State file for the application, to open the last saved file, for application re-initialisation with the last saved state
     * The state file is always stored at _EventManagerLastOpenedState_.csv, relative to the application, and contains the file path of the last saved file
     * The method returns no values
     * The method takes in no parameter values
     */
    public void loadState() {
        try(BufferedReader bReader = new BufferedReader(new FileReader("_EventManagerLastOpenedState_.csv"))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String fileList[] = line.trim().split(",");
                if (!fileList[0].isBlank()) {
                    this.readConfigFile(fileList[0]);
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading State file");	 	  	 	        	     	
        }
    }
    
    /**
     * This method constructs a String of model data, including Event, Organiser, and Item attribute values for each Event, to be displayed on the TextView JTextArea of the EventViewer
     * It takes in no parameter values
     * @return This is the String return value to be displayed on the Text View JTextArea of the EventViewer
     */
    public String textViewData() {
        String textViewString = "";
        for (int i=0; i<this.getEvents().size(); i++) {
            Event currentEvent = this.getEvents().get(i);
            //System.out.println(currentEvent.toString());
            textViewString = textViewString + (i+1) + " " + currentEvent.getTitle();
            if (currentEvent.getOrganiser() != null) {
                textViewString = textViewString + " organised by " + currentEvent.getOrganiser().getFirstName() + " " + currentEvent.getOrganiser().getLastName();
            }
            String dateTime = currentEvent.getDateTime().toString();
            String[] dateTimeArray = dateTime.split("T");
            textViewString = textViewString + " at " + dateTimeArray[0] + " at " + dateTimeArray[1] + " in " + currentEvent.getLocation();
            if (!currentEvent.getItems().isEmpty()) {
                textViewString = textViewString + " with agenda: ";
                for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                    Item currentItem = this.getEvents().get(i).getItems().get(j);
                    textViewString = textViewString + currentItem.getStartTime().toString() + " - " + currentItem.getItemTitle();
                    if (j != this.getEvents().get(i).getItems().size() - 1) {
                        textViewString = textViewString + ", ";
                    }
                    else if (j == this.getEvents().get(i).getItems().size() - 1) {
                        textViewString = textViewString + System.lineSeparator();
                    }
                }
            }
            else {
                textViewString = textViewString + System.lineSeparator();
            }
        }
        return textViewString;
    }
    
    /**
     * This method constructs a String of model data, including Event, Organiser, and Item attribute values for each Event, to be displayed on the HierarchalView JTextArea of the EventViewer
     * It takes in no parameter values
     * @return This is the String return value to be displayed on the Hierarchal View JTextArea of the EventViewer
     */
    public String hierarchalViewData() {
        String hierarchalViewString = "";
        for (int i=0; i<this.getEvents().size(); i++) {
            Event currentEvent = this.getEvents().get(i);
            //System.out.println(currentEvent.toString());
            hierarchalViewString = hierarchalViewString + currentEvent.getTitle();
            if (currentEvent.getOrganiser() != null) {
                hierarchalViewString = hierarchalViewString + " organised by " + currentEvent.getOrganiser().getFirstName() + " " + currentEvent.getOrganiser().getLastName();
            }
            String dateTime = currentEvent.getDateTime().toString();
            String[] dateTimeArray = dateTime.split("T");
            hierarchalViewString = hierarchalViewString + " at " + dateTimeArray[0] + " at " + dateTimeArray[1] + " in " + currentEvent.getLocation() + System.lineSeparator();
            if (!currentEvent.getItems().isEmpty()) {
                for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                    Item currentItem = this.getEvents().get(i).getItems().get(j);
                    hierarchalViewString = hierarchalViewString + "    " + currentItem.getStartTime().toString() + " - " + currentItem.getItemTitle() + System.lineSeparator();
                    if (j == this.getEvents().get(i).getItems().size() - 1) {
                        hierarchalViewString = hierarchalViewString + System.lineSeparator();
                    }
                }
            }
            else {
                hierarchalViewString = hierarchalViewString + System.lineSeparator();
            }
        }
        return hierarchalViewString;
    }
    
    /**
     * This method finds the selected Event object based upon the Event title attribute value matching the String selectedText parameter value, returning the int index of the Event in the EventManager events ArrayList
     * @param selectedText This is a String value of the text to search for a matching Event by
     * @return This is the int index of the matching Event object in the EventManager events ArrayList, if not found, returns -1
     */
    public int getSelectedEvent(String selectedText) {
        String searchableText = selectedText.trim();
        int index = -1;
        for (int i=0; i<this.getEvents().size(); i++) {
            if (searchableText.equals(this.getEvents().get(i).getTitle())) {
               index = i;
               break;
            }
        }
        return index;
    }
    
    /**
     * This method finds the selected Organiser object based upon the Organiser firstName and lastName attribute values matching the String selectedText parameter value, returning the int index of the Event in the EventManager organisers ArrayList
     * @param selectedText This is a String value of the text to search for a matching Organiser by
     * @return This is the int index of the matching Organiser object in the EventManager organisers ArrayList, if not found, returns -1
     */
    public int getSelectedOrganiser(String selectedText) {
        int index = -1;
        String searchableText = selectedText.trim();
        String[] organiserDetails = searchableText.split(" ");
        Organiser comparableOrganiser = new Organiser(organiserDetails[0], organiserDetails[1]);
        for (int i=0; i<this.getOrganisers().size(); i++) {
            if (comparableOrganiser.equals(this.getOrganisers().get(i))) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    /**
     * This method finds the selected Item object from an Event object based upon the Item startTime and itemTitle attribute values matching the String selectedText parameter value, returning the int Array index of the Event the Item is linked to, and the index of the Item in the particular Event items ArrayList
     * @param selectedText This is a String value of the text to search for a matching Item by
     * @return This is the int Array index of the matching Event object the Event the Item is linked to, and the index of the Item in the particular Event items ArrayList, if not found, returns -1,-1
     */
    public int[] getSelectedItem(String selectedText) {
        int[] selectedItemLocation = new int[2];
        selectedItemLocation[0] = -1;
        selectedItemLocation[1] = -1;
        String searchableText = selectedText.trim();
        String[] itemDetails = searchableText.split("-");
        System.out.println(itemDetails[0]+itemDetails[1]);
        Item comparableItem = new Item(itemDetails[0].trim(), itemDetails[1].trim());
        for (int i=0; i<this.getEvents().size(); i++) {
            for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                if (comparableItem.equals(this.getEvents().get(i).getItems().get(j))) {
                    selectedItemLocation[0] = i;
                    selectedItemLocation[1] = j;
                    return selectedItemLocation;
                }
            }
        }
        System.out.println(selectedItemLocation[0] + " " + selectedItemLocation[1]);
        return selectedItemLocation;
    }
    
    /**
     * This method sets the startTime and/or itemTitle attribute values for the Item object at the specified int eventIndex index of the EventManager events ArrayList and int itemIndex index of the selected Event's items ArrayList based on the inputted String parameter values
     * @param eventIndex This is the int value of the Event object's index in the EventManager events ArrayList
     * @param itemIndex This is the int index of the item to edit in the ArrayList
     * @param startTime This is the String value of the startTime attribute for the Item instance to be replaced
     * @param itemTitle This is the String value of the startTime attribute for the Item instance to be replaced
     * @return This returns boolean true if the Item object has been edited in the Event object's items ArrayList attribute, otherwise false
     */
    public boolean editItem(int eventIndex, int itemIndex, String startTime, String itemTitle) {
        Item itemToEdit = this.getEvents().get(eventIndex).getItems().get(itemIndex);
        if (itemToEdit != null) {
            if (!startTime.equals("")) {
                itemToEdit.setStartTime(startTime);
            }
            if (!itemTitle.equals("")) {
                itemToEdit.setItemTitle(itemTitle);
            }
            return true;
        }
        return false;
    }
    
    /**
     * This method sets the firstName and/or lastName attribute values for the Organiser object at the specified int organiserIndex index of the EventManager organisers ArrayList based on the inputted String parameter values
     * @param organiserIndex This is the int index of the organiser to delete from the ArrayList
     * @param firstName This is the String value of the firstName attribute for the Organiser instance to be replaced
     * @param lastName This is the String value of the lastName attribute for the Organiser instance to be replaced
     * @return This returns boolean true if the Organiser object has been edited in the EventManager organisers ArrayList, otherwise false
     */
    public boolean editOrganiser(int organiserIndex, String firstName, String lastName) {
        Organiser organiserToEdit = this.getOrganisers().get(organiserIndex);
        if (organiserToEdit != null) {
            if (!firstName.equals("")) {
                organiserToEdit.setFirstName(firstName);
            }
            if (!lastName.equals("")) {
                organiserToEdit.setLastName(lastName);
            }
            return true;
        }
        return false;
    }
    
    /**
     * This method sorts the EventManager events ArrayList by the Event title attribute value in ascending, alphabetical order
     * The method takes in no parameter values
     * The method returns no values
     */
    public void sortEventsByEventTitleAscending(){
        Collections.sort(this.getEvents(), Event.BY_EVENTTITLE);
    }
    
    /**
     * This method sorts the EventManager events ArrayList by the Event title attribute value in descending, reverse alphabetical order
     * The method takes in no parameter values
     * The method returns no values
     */
    public void sortEventsByEventTitleDescending() {
        Collections.sort(this.getEvents(), Event.BY_EVENTTITLE);
        Collections.reverse(this.getEvents());
    }
    
    /**
     * This method sorts the EventManager events ArrayList by the Event dateTime attribute value in ascending, numerical, order
     * The method takes in no parameter values
     * The method returns no values
     */
    public void sortEventsByDateTimeAscending() {
        Collections.sort(this.getEvents(), Event.BY_DATE);
    }
    
    /**
     * This method sorts the EventManager events ArrayList by the Event dateTime attribute value in descending, numerical, order
     * The method takes in no parameter values
     * The method returns no values
     */
    public void sortEventsByDateTimeDescending() {
        Collections.sort(this.getEvents(), Event.BY_DATE);
        Collections.reverse(this.getEvents());
    }
    
    /**
     * This method sorts the Event items ArrayList for each Event in the EventManager events ArrayList by the Item startTime attribute value in ascending, numerical, order
     * The method takes in no parameter values
     * The method returns no values
     */
    public void sortItemsByStartTime() {
        for (int i=0; i<this.getEvents().size(); i++)
        {
            Collections.sort(this.getEvents().get(i).getItems(), Item.BY_TIME);
        }
    }
    
    /**
     * This method updates the TextView and HierarchalView JTextArea components of the EventViewer based on the textViewData method and current model data
     * This method takes in no parameter values
     * This method returns no values
     */
    public void modelModified() {
        EventViewer eventViewer = EventViewer.getInstance();
        eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().setText(this.textViewData());
        eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().setText(this.hierarchalViewData());
    }
    
    /**
     * This method initialises the EventManager model by deleting all Events and Items from the associated EventManager events and items ArrayLists
     * It does not affect the EventManager organisers ArrayList
     * This method takes in no parameter values
     * This method returns no values
     */
    public void initialiseModelKeepOrganisers() {
        this.getEvents().clear();
        this.getItems().clear();
    }
    
    /**
     * This method initialises the EventManager model by deleting all Organisers, Events and Items from the associated EventManager organisers, events and items ArrayLists
     * This method takes in no parameter values
     * This method returns no values
     */
    public void initialiseModelDeleteOrganisers() {
        this.getEvents().clear();
        this.getItems().clear();
        this.getOrganisers().clear();
    }
    
    /**
     * This method gets the text the user has selected on either the TextView JTextArea or the HierarchalView JTextArea and returns the selected text
     * This method takes in no parameter values
     * @return This is the String return value of the text the user has selected in the EventViewer JTextArea
     */
    public String getTextUserSelects() {
        EventViewer eventViewer = EventViewer.getInstance();
        String textUserSelects = "";
        if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
            textUserSelects = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
        }
        if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
            textUserSelects = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
        }
        return textUserSelects;
    }
}
