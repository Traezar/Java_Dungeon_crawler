package model.characters;

public class Armor  extends Loot{
    private int defence;

    public Armor(String init_name,int init_dmg)
    {
        super(init_name);
        this.defence = init_dmg;
        return;
    }

    public int getDefence() {
        return defence;
    }
}
