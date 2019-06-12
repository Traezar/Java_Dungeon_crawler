package model.characters.badguys;


public class Troll extends Villain{
    private int attack;
    private int defence;

    Troll (int lvl) {
        super(lvl, lvl + 3, lvl + 7 , lvl*2);
    }
}
