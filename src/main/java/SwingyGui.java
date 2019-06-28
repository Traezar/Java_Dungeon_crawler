import controller.*;
import view.gui.DungeonPanel;
import view.gui.HeroPanel;
import view.gui.NarratorPanel;


import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class SwingyGui {

    public static void main (String[] args) {

        guiController controller = new guiController();
        JFrame main = new JFrame("Dungeon Crawler");
        JPanel Left = new JPanel();
        JPanel heroPanel = new HeroPanel( controller);
        JPanel DungeonPanel = new DungeonPanel(controller);
        JTextArea Narrator = new NarratorPanel(controller);


        //Change the Layout to Gridbaglayout;
        main.setLayout(new BorderLayout());
        Left.setLayout(new BoxLayout(Left, BoxLayout.PAGE_AXIS));
        //Add Panels to the layout, set size and closing;

        main.add(Left, BorderLayout.LINE_START);
        Left.add(heroPanel);
        Left.add(DungeonPanel);
        main.add(Narrator, BorderLayout.CENTER);
        main.setSize(2000,1000);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.setVisible(true);




    }
}
