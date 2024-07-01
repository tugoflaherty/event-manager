/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author tugoflaherty
 */
public class TabPanel extends JPanel {

    private JTabbedPane tabPane = new JTabbedPane();
    private TextAreaPanel textAreaPanel = new TextAreaPanel();
    private TextAreaPanel hierarchalPanel = new TextAreaPanel();

    /**
     * This method is a getter to return the hierarchalPanel attribute as type TextAreaPanel
     * It takes in no parameters
     * @return This returns the hierarchalPanel of type TextAreaPanel
     */
    public TextAreaPanel getHierarchalPanel() {
        return hierarchalPanel;
    }

    /**
     * This method is a setter to set the value of the hierarchalPanel attribute using a value of type TextAreaPanel
     * It does not return a value
     * @param hierarchalPanel This is the value of the hierarchalPanel attribute to be set of type TextAreaPanel
     */
    public void setHierarchalPanel(TextAreaPanel hierarchalPanel) {
        this.hierarchalPanel = hierarchalPanel;
    }
    
    /**
     * This method is a getter to return the tabPane attribute as type JTabbedPane
     * It takes in no parameters
     * @return This returns the tabPane of type JTabbedPane
     */
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    /**
     * This method is a setter to set the value of the tabPane attribute using a value of type JTabbedPane
     * It does not return a value
     * @param tabPane This is the value of the tabPane attribute to be set of type JTabbedPane
     */
    public void setTabPane(JTabbedPane tabPane) {
        this.tabPane = tabPane;
    }
    
    /**
     * This method is a getter to return the textAreaPanel attribute as type TextAreaPanel
     * It takes in no parameters
     * @return This returns the textAreaPanel of type TextAreaPanel
     */
    public TextAreaPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    /**
     * This method is a setter to set the value of the textAreaPanel attribute using a value of type TextAreaPanel
     * It does not return a value
     * @param textAreaPanel This is the value of the textAreaPanel attribute to be set of type TextAreaPanel
     */
    public void setTextAreaPanel(TextAreaPanel textAreaPanel) {
        this.textAreaPanel = textAreaPanel;
    }
    
    /**
     * This is a constructor method to construct a new instance of TabPanel when called
     * It sets a BorderLayout to position the JTabbedPane instance that is added to it
     * It adds the created TextAreaPanel instances to the panel
     * It does not take in any parameters
     * It does not return any values
     */
    public TabPanel() {
        this.setLayout(new BorderLayout());
        tabPane.add("Text View",textAreaPanel);
        tabPane.add("Hierarchal View",hierarchalPanel);
        this.add(tabPane,BorderLayout.CENTER);
    }
}
