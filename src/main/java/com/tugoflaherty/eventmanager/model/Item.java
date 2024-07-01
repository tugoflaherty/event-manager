/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author tugoflaherty
 */
public class Item implements Comparable<Item> {
    
    private LocalTime startTime;
    private String itemTitle;

    /**
     * public static Comparator object of type Item, for sorting items by date and time
     */
    public static Comparator<Item> BY_TIME = new Item.ByStartTime();

    /**
     * This method is a getter to return the startTime attribute as type LocalTime
     * It takes in no parameters
     * @return This returns the startTime of type LocalTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * This method is a setter to set the value of the startTime attribute using a value of type LocalTime
     * It does not return a value
     * @param startTime This is the value of the startTime attribute to be set of type LocalTime
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    /**
     * This method is a setter to set the value of the startTime attribute using a value of type String
     * It does not return a value
     * @param startTime This is the value of the startTime attribute to be set of type String
     * @throws DateTimeParseException This Exception is thrown if the String value cannot be converted to type LocalTime
     */
    public void setStartTime(String startTime) {	
        try {
            this.startTime = LocalTime.parse(startTime);
        }
        catch (DateTimeParseException dtpe) {
            this.startTime = LocalTime.parse("00:00");
        }	  		 	  	 	        	     	
    }

    /**
     * This method is a getter to return the itemTitle attribute as type String
     * It takes in no parameters
     * @return This returns the itemTitle of type String
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * This method is a setter to set the value of the itemTitle attribute using a value of type String
     * It does not return a value
     * @param itemTitle This is the value of the itemTitle attribute to be set of type String
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
    
    /**
     * Constructor to construct new Item object with a value of type LocalTime for startTime and String for itemTitle
     * @param startTime This is the value of the startTime attribute to be set of type LocalTime
     * @param itemTitle This is the value of the itemTitle attribute to be set of type String
     */
    public Item(LocalTime startTime, String itemTitle) {
        this.setStartTime(startTime);
        this.setItemTitle(itemTitle);
    }
    
    /**
     * Constructor to construct new Item object with a value of type String for startTime and String for itemTitle
     * @param startTime This is the value of the startTime attribute to be set of type String
     * @param itemTitle This is the value of the itemTitle attribute to be set of type String
     */
    public Item(String startTime, String itemTitle) {
        this.setStartTime(startTime);
        this.setItemTitle(itemTitle);
    }
    
    /**
     * This method overrides the toString() method for an Item object, returning the Item object's attributes as a String in a human-readable format
     * It does not have any parameters
     * @return This returns the Item object's attributes as a human-readable format of type String
     */
    @Override
    public String toString() {
        return "Item{" + "title=" + this.getItemTitle() + "time=" + this.getStartTime().toString() + "}";
    }
    
    /**
     * This method overrides the compareTo() method for an Item object, receiving an item object of type Item and returning a boolean value depending on if the items are equal or not based on the item start time
     * @param item This is the item object of type Item being passed to the method to be compared
     * @return This is the return value of type boolean, true if the passed item is equal to the current item, otherwise false, based on the item start time
     */
    @Override
    public int compareTo(Item item) {
        return startTime.compareTo(item.getStartTime());
    }

    /**
     * This method overrides the hashCode() method for an Item object, generating a hashCode for the Item object based on its startTime and itemTitle attribute values, and returning the hashCode
     * It does not have any parameters
     * @return This is the return value of type int, generated based on the Item object's startTime and itemTitle attribute values
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.startTime);
        hash = 97 * hash + Objects.hashCode(this.itemTitle);
        return hash;
    }

    /**
     * This method overrides the equals() method for an Item object, receiving an Object and checking if the object is equal to the Item object, returning a boolean of true if it is, otherwise false
     * @param obj This is the object of type Object to be compared to the Item instance
     * @return This is the return value of type boolean, true if the object is equal to the Item instance, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemTitle, other.itemTitle)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        return true;
    }
    
    private static class ByStartTime implements Comparator<Item>{
        @Override
        public int compare(Item item1, Item item2) {
            return item1.getStartTime().compareTo(item2.getStartTime());
        }
    }
}
