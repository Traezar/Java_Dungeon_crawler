package model.characters.badguys;


public abstract class Villain {

   protected int level;
    private int attack;
    private int defence;
    private int hp;

   Villain(int level, int attack, int defence, int HP){
       this.level = level;
       this.attack = attack;
       this.defence = defence;
       this.hp = HP;
   }
    public int getAttack(){
        return this.attack;
    }
    public int getDefence(){
        return this.defence;
    }
    public int getHP(){
        return this.hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}
