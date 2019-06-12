package model.characters.badguys;


public class Troll extends Villain{

    Troll (int lvl) {
        super(lvl, lvl + 3, lvl + 7 , lvl*2);
    }

    @Override
    public String toString() {
        return "Troll\n" +
                "attack :" + getAttack() +
                ",\n defence :" + getDefence() +
                ",\n HP : " + this.getHP()
                ;
    }


}
