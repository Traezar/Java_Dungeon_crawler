package model.characters.badguys;

import model.characters.Hero;

import javax.swing.*;

public class Dragon extends Villain{

    public Dragon(int lvl){
        super(lvl, lvl * 2 ,lvl *4);

    }
    @Override
    public String toString() {
        return "Dragon\n" +
                "attack :" + getAttack() +
                ",\n HP : " + this.getHP()
                ;
    }
}
