package model.characters.badguys;

public class Goblin extends Villain {


     Goblin (int lvl){
        super(lvl, lvl/2 + 2, lvl/2 + 2, lvl + 10);
    }

    @Override
    public String toString() {
        return "Goblin\n" +
                "attack : " + this.getAttack() +
                ",\n defence : " + this.getDefence() +
                ",\n HP : " + this.getHP()
                ;
    }
}

