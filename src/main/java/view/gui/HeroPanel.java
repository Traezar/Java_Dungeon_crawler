package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.List;

import controller.guiController;
import model.characters.Hero;
import org.hibernate.validator.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.nio.file.Files.*;
import static java.nio.file.Files.readAllLines;

public class HeroPanel extends JPanel  {

    final JTextField Name = new JTextField(10);
    final JTextField Role = new JTextField(10);
    final JTextField Level = new JTextField(10);
    final JTextArea Log = new JTextArea(5, 40);
    JLabel NameLabel = new JLabel("Name");
    JLabel RoleLabel = new JLabel("Role");
    JLabel LevelLabel = new JLabel("Level");
    boolean isBuilt = false;
    Hero hero;
    guiController Con;

    JButton SavedHeroes = new JButton("Saved Heroes");
    JButton Submit = new JButton("submit");

    public HeroPanel(guiController con) {
        super();
        this.Con = con;
        String title = "Hero Details";
        //Add Swing Components
        Border b = BorderFactory.createTitledBorder(title);
        this.setBorder(b);
        GridLayout gc = new GridLayout(0,2);
        this.setLayout(gc);
        //First Column;

        this.add(RoleLabel);
        this.add(Role);

        this.add(NameLabel);
        this.add(Name);

        this.add(LevelLabel);
        this.add(Level);
        //Second Column

        this.add(Submit);
        this.add(SavedHeroes);
        this.add(Log);

        Submit.addActionListener(new SubmitListener(con));
        SavedHeroes.addActionListener(new SavedListener(con));
    }

    private class SubmitListener implements ActionListener{
        guiController con;
        public SubmitListener(guiController c){
            this.con = c;
        }
        public void actionPerformed(ActionEvent e) {

            String Hname = Name.getText();
            String HRole = Role.getText();
            String Slevel = Level.getText();
            int i;
            try {
                i = Integer.parseInt(Slevel);
                if (i == 0)
                    throw new NumberFormatException();
            } catch (NumberFormatException ex) {

                Log.append("\nInvalid level : Level minimum is 1");
                return;
            }
            if (Hname.isBlank() || HRole.isBlank()) {
                Log.append("\nInvalid level : Neither Name nor Level Fields Should be Blank");
                return;
            } else {
                Log.setText("The Chosen one is : " + Hname + ", " + HRole + ", level " + i);
                hero = new Hero.HeroBuilder(Hname)
                        .setlevel(i)
                        .setrole(HRole)
                        .setattack(i + 30)
                        .setdefence(i + 20)
                        .setexperience(0)
                        .setHP(i * 2 + 100)
                        .Build();
                Con.getModel().setHero(hero);

                System.out.println("Submitted!");
                System.out.println(Con.getModel().getHero().getlevel() + Con.getModel().getHero().getName());

            }
        }
    }
    private class SavedListener implements  ActionListener{

        guiController con;
        SavedListener(guiController c){
            this.con = c;
        }
        public void actionPerformed(ActionEvent e) {
            List<String> list = con.readFileIntoList("./SavedHeroes");
            if (list.isEmpty()){
                //NoHeroesFoundintheList;
            }
            else{
                //Display Heroes as a dropdownlist from the button
            }
        }
    }

    private class DropdownListener implements ActionListener{
        DropdownListener(String str){
            //Split this String then use the name and the levels to build the Hero;
            //return the hero to the model update the display
        }
        public void actionPerformed(ActionEvent e) {


        }
    }

}
