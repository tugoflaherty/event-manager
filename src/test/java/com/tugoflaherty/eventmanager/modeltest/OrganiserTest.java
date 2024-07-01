/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Organiser;

/**
 *
 * @author tugoflaherty
 */
public class OrganiserTest {
    
    /**
     * This is a test method to create a series of five hard-coded Organiser objects, testing that Organiser objects can be instantiated
     * Checks appropriate Organiser constructor and attributes are set correctly to allow a new Organiser to be instantiated
     * Takes in no parameters
     * Returns no values
     */
    public static void createOrganisers() {
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        Organiser ahmedShihab = new Organiser("Ahmed","Shihab");
        Organiser tugOflaherty = new Organiser("Tug","O'Flaherty");
        Organiser graemeJones = new Organiser("Graeme","Jones");
    }
    
    /**
     * This method tests whether an Organiser object can be instantiated, and that when it is instantiated, its attribute values are equal to those it was instantiated with, ensuring it is the same object
     * This method takes in no parameter values
     * @return This method returns boolean true if the Organiser object's attribute values match those that it was instantiated with, otherwise false
     */
    public static boolean testOrganiserCreation() {
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        if (jamesDenholmPrice.getFirstName().equals("James") && jamesDenholmPrice.getLastName().equals("Denholm-Price")) {
            return true;
        }
        return false;
    }
}
