package model.characters.badguys;

import model.characters.Hero;

import javax.swing.*;

public class Dragon extends Villain{

    public Dragon(int lvl){
        super(lvl, lvl * 2 , (lvl * 3)/2,lvl *4);

    }

}
