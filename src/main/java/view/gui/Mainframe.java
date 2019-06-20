package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.characters.Hero;
import org.hibernate.validator.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class Mainframe extends JFrame {

    public Mainframe(String name) {
        super(name);

        //Set Layout manager
        setLayout(new GridBagLayout());

        //Create Swing Components
        final JTextField Name = new JTextField(10);
        final JTextField Role = new JTextField(10);
        final JTextField Level = new JTextField(10);
        final JTextArea Log = new JTextArea(5, 40);
        JLabel NameLabel = new JLabel("Name");
        JLabel RoleLabel = new JLabel("Role");
        JLabel LevelLabel = new JLabel("Level");

        JButton SavedHeroes = new JButton("SavedHeroes");
        JButton Submit = new JButton("submit");

        //Add Swing Components
        Container c = getContentPane();
        GridBagConstraints gc = new GridBagConstraints();

      //  gc.anchor = GridBagConstraints.NORTHWEST;
        gc.gridx = 0;
        gc.gridy = 0;
        c.add(RoleLabel, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        c.add(NameLabel, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        c.add(LevelLabel, gc);
        gc.gridx = 1;
        gc.gridy = 0;
        c.add(Name, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        c.add(Role, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        c.add(Level, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        c.add(Submit, gc);
        gc.gridy = 4;
        c.add(Log, gc);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //Add Behaviour of Components
        Submit.addActionListener(new ActionListener() {
            @Override
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
                }
                else
                {
                    Log.setText("The Chosen one is : "+ Hname + ", " +  HRole + ", level " + i);
                    dispose();
                }
            }
        });
    }
}
