package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.guiController;
import model.characters.Hero;
import org.hibernate.validator.*;

import javax.swing.border.Border;


public class HeroPanel extends JPanel  {

    final JTextField Name = new JTextField(10);
    final JTextField Role = new JTextField(10);
    final JTextField Level = new JTextField(10);
    final JTextField Exp = new JTextField(10);
    final JTextField Attack = new JTextField(10);
    final JTextField Defence = new JTextField(10);
    final JTextField HP = new JTextField(10);
    final JTextField Armor = new JTextField(10);
    final JTextField Weapon = new JTextField(10);
    final JTextField Helm = new JTextField(10);

    JLabel NameLabel = new JLabel("Name");
    JLabel RoleLabel = new JLabel("Role");
    JLabel LevelLabel = new JLabel("Level");
    final JLabel ExpLabel = new JLabel("Exp");
    final JLabel AttackLabel = new JLabel("Attack");
    final JLabel DefenceLabel = new JLabel("Defence");
    final JLabel HPLabel = new JLabel("HP");
    final JLabel ArmorLabel = new JLabel("Armor");
    final JLabel WeaponLabel = new JLabel("Weapon");
    final JLabel HelmLabel = new JLabel("Helm");
    boolean isBuilt = false;
    Hero hero;
    guiController Con;
    JComboBox SavedHeroes ;

    JButton Submit = new JButton("submit");

    public HeroPanel(guiController con) {
        super();
        this.Con = con;
        String title = "Hero Details";
        SavedHeroes = new JComboBox(this.Con.readFileintoVector());
        //Add Swing Components
        Border b = BorderFactory.createTitledBorder(title);
        this.setBorder(b);
        GridBagLayout c = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        this.setLayout(c);
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
        Submit.addActionListener(new SubmitListener(con));
        SavedHeroes.addActionListener(new SavedListener(con));
    }


    public void repaintTheHeroPanel(){
        JPanel p = this;
        p.removeAll();
        p.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        p.add(NameLabel);
        p.add(Name);

        p.add(RoleLabel,gc);
        p.add(Role,gc);
        gc.gridy =1;
        p.add(LevelLabel,gc);
        p.add(Level,gc);

        p.add(ExpLabel,gc);
        p.add(Exp,gc);

        gc.gridy =2;
        p.add(HPLabel,gc);
        p.add(HP,gc);
        p.add(AttackLabel,gc);
        p.add(Attack,gc);
        gc.gridy =3;
        p.add(DefenceLabel,gc);
        p.add(Defence,gc);
        p.add(ArmorLabel,gc);
        p.add(Armor,gc);
        gc.gridy =4;
        p.add(HelmLabel,gc);
        p.add(Helm,gc);
        this.getPreferredSize();
        p.repaint();
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

                con.Narrate("\nInvalid level : Level minimum is 1");
                return;
            }
            if (Hname.isBlank() || HRole.isBlank()) {
                con.Narrate("\nInvalid level : Neither Name nor Level Fields Should be Blank");
                return;
            } else {
                con.Narrate("\nThe Chosen one is : " + Hname + ", " + HRole + ", level " + i);
                hero = new Hero.HeroBuilder(Hname)
                        .setlevel(i)
                        .setrole(HRole)
                        .setattack(i + 30)
                        .setdefence(i + 20)
                        .setexperience(0)
                        .setHP(i * 2 + 100)
                        .Build();
                Con.getModel().setHero(hero);
                Con.ModelInitMap();
                con.Narrate("\nThe Challenger approaches the Dungeon Warily!!");
                con.Narrate(Con.getModel().getHero().getlevel() + Con.getModel().getHero().getName());
                repaintTheHeroPanel();
            }
        }
    }
    private class SavedListener implements  ActionListener{

        guiController con;
        SavedListener(guiController c){
            this.con = c;
        }
        public void actionPerformed(ActionEvent e) {


        }
    }


}
