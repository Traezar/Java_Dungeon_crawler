package model.characters;

public class Weapon extends Loot{

    private int attack;

    public Weapon(String init_name,int init_dmg)
    {
        super(init_name);
        this.attack= init_dmg;
        return;
    }

    public int getAttack() {
        return attack;
    }
}
