package model.characters;

public class Helm  extends Loot{

    private int HP;

    public Helm(String init_name,int init_dmg) {
        super(init_name);
        this.HP = init_dmg;
        return;
    }

    public int getHP() {
        return HP;
    }
}
