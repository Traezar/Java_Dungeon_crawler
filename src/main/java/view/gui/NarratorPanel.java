package view.gui;

import controller.guiController;

import javax.swing.*;
import javax.swing.border.Border;

public class NarratorPanel extends JTextArea{
    
    public NarratorPanel(guiController c){
        guiController con = c;
        String title = "Event Log";
        Border b = BorderFactory.createTitledBorder(title);
        this.setBorder(b);
        this.setSize(300,800);
    }

    public void addEvent(String event){
        this.append(event);
    }

    public void clearEvents(){
        this.clearEvents();
    }
}
