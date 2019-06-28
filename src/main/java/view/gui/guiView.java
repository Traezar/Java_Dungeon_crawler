package view.gui;

import controller.guiController;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class guiView {
    JPanel heroPanel;
    JPanel DungeonPanel;
    JPanel Left;
    JTextArea Narrator;
    private JFrame Display;
   private guiController controller;

    public guiView(guiController con){
        controller = con;
        Display = new JFrame("Dungeon Crawler");
        Left = new JPanel();
        heroPanel = new HeroPanel( controller);
        DungeonPanel = new DungeonPanel(controller);
        Narrator = new NarratorPanel(controller);

        //Change the Layout to Gridbaglayout;
        Display.setLayout(new BorderLayout());
        Left.setLayout(new GridBagLayout());
        //Add Panels to the layout, set size and closing;
        GridBagConstraints fc = new GridBagConstraints();


        Display.add(Left, BorderLayout.LINE_START);
        Left.add(heroPanel,fc);
        fc.weighty = 0.5;
        fc.gridy= 1;
        Left.add(DungeonPanel,fc);
        Display.add(Narrator, BorderLayout.CENTER);
        Display.setSize(1000,500);
        Display.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Display.setLocationRelativeTo(null);
        Display.setVisible(true);
    }

    public JFrame getDisplay() {
        return Display;
    }

    public JPanel getDungeonPanel() {
        return DungeonPanel;
    }

    public void  Narrate(String str) {
        this.Narrator.append(str);
    }

    public JPanel getHeroPanel() {
        return heroPanel;
    }

}

