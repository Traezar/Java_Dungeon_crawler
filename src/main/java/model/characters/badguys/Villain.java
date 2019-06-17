package model.characters.badguys;


public abstract class Villain {

   protected int level;
    private int attack;

    private int hp;

   Villain(int level, int attack,int HP){
       this.level = level;
       this.attack = attack;
       this.hp = HP;
   }
    public int getAttack(){
        return this.attack;
    }
    public int getHP(){
        return this.hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}
