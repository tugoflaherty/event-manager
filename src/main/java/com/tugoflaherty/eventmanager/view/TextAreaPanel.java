/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author tugoflaherty
 */
public class TextAreaPanel extends JPanel {
    
    private JTextArea textAreaPanel = new JTextArea();
    private JScrollPane textAreaScrollPane = new JScrollPane(textAreaPanel);

    /**
     * This method is a getter to return the textAreaScrollPane attribute as type JScrollPane
     * It takes in no parameters
     * @return This returns the textAreaScrollPane of type JScrollPane
     */
    public JScrollPane getTextAreaScrollPane() {
        return textAreaScrollPane;
    }

    /**
     * This method is a setter to set the value of the textAreaScrollPane attribute using a value of type JScrollPane
     * It does not return a value
     * @param textAreaScrollPane This is the value of the textAreaScrollPane attribute to be set of type JScrollPane
     */
    public void setTextAreaScrollPane(JScrollPane textAreaScrollPane) {
        this.textAreaScrollPane = textAreaScrollPane;
    }
    
    /**
     * This method is a getter to return the textAreaPanel attribute as type JTextArea
     * It takes in no parameters
     * @return This returns the textAreaPanel of type JTextArea
     */
    public JTextArea getTextAreaPanel() {
        return textAreaPanel;
    }

    /**
     * This method is a setter to set the value of the textAreaPanel attribute using a value of type JTextArea
     * It does not return a value
     * @param textAreaPanel This is the value of the textAreaPanel attribute to be set of type JTextArea
     */
    public void setTextAreaPanel(JTextArea textAreaPanel) {
        this.textAreaPanel = textAreaPanel;
    }
    
    /**
     * This is a constructor method to construct a new instance of TextAreaPanel when called
     * It sets a BorderLayout, font type, and makes the textAreaPanel not editable for the TextAreaPanel
     * It adds the created textAreaPanel instance to the panel
     * It does not take in any parameters
     * It does not return any values
     */
    public TextAreaPanel() {
        this.setLayout(new BorderLayout());
        this.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        this.textAreaPanel.setEditable(false);
        this.add(textAreaScrollPane);
    }
    
    /**
     * This is a constructor method to construct a new instance of TextAreaPanel when called with eventText of type String
     * It adds the eventText String to the textAreaPanel to display the relevant text
     * It sets a BorderLayout, font type, and makes the textAreaPanel not editable for the TextAreaPanel
     * It adds the created textAreaPanel instance to the panel
     * It does not return any values
     * @param eventText This is the value of the textAreaPanel text to be set of type String
     */
    public TextAreaPanel(String eventText) {
        this.setLayout(new BorderLayout());
        this.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        this.textAreaPanel.setEditable(false);
        this.textAreaPanel.setText(eventText);
        this.add(textAreaScrollPane);
    }
}
