package view.gui;

import controller.guiController;
import model.characters.Hero;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DungeonPanel extends JPanel {
    final JTextField Villain = new JTextField(10);
    final JTextField Attack = new JTextField(10);
    final JTextField HP = new JTextField(10);
    JLabel VillainLabel = new JLabel("Name");
    JLabel AttackLabel = new JLabel("Attack");
    JLabel HPLabel = new JLabel("HP");
    JButton fightButton = new JButton("Fight!");
    JButton runButton = new JButton("RUN!!");

    private guiController con;

    public DungeonPanel(guiController c){
        super();
        this.con = c;
        String title = "Dungeon Info";
        Border b = BorderFactory.createTitledBorder(title);
        this.setLayout(new FlowLayout());
        this.setBorder(b);
        this.add(VillainLabel);
        this.add(Villain);
        this.add(AttackLabel);
        this.add(Attack);
        this.add(HPLabel);
        this.add(HP);
        this.add(fightButton);
        this.add(runButton);
        fightButton.addActionListener(new FightListener(c));
        runButton.addActionListener(new RunListener(c));
    }

    public guiController getCon() {
        return con;
    }

    public void DisplayVillainAttack(String t) {
        this.Attack.setText(t);
    }

    public void DisplayVillainHP(String t) {
        this.HP.setText(t);
    }
    public void DisplayVillainName(String t) {
        this.Villain.setText(t);
    }

    private class FightListener implements ActionListener {
        private guiController con;
        FightListener(guiController c){
            this.con = c;
        }


        public void actionPerformed(ActionEvent e) {

        }

    }
    private class RunListener implements ActionListener {
        private guiController con;
        RunListener(guiController c){
            this.con = c;
        }

        public void actionPerformed(ActionEvent e) {

        }
    }
}
