package model.characters;
import model.map.*;

public class Hero {
    private Tile location;
    private int tLat;
    private int tLong;
    private String name;
    private String role;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hp;
    private Weapon weapon;
    private Armor armor;
    private Helm helm;

    private Hero(){};
    public int getlatitude() {
        return this.tLat;
    }
    public int getlongtitude() {
        return this.tLong;
    }




    public static class HeroBuilder{
        private String name;
        private String role;
        private int level;
        private int experience;
        private int attack;
        private int defence;
        private int hp;

        public HeroBuilder(String name) {
            this.name = name;
        }
        public HeroBuilder setrole(String role) {
            this.role = role;
            return this;
        }
        public HeroBuilder setlevel(int level) {
            this.level = level;
            return this;
        }
        public HeroBuilder setexperience(int exp) {
            this.experience = exp;
            return this;
        }
        public HeroBuilder setattack(int atk) {
            this.attack = atk;
            return this;
        }
        public HeroBuilder setdefence(int def) {
            this.defence = def;
            return this;
        }
        public HeroBuilder setHP(int HP) {
            this.hp = HP;
            return this;
        }
        public Hero Build(){
            Hero chosen = new Hero();
            chosen.name = this.name;
            chosen.role = this.role;
            chosen.level= this.level;
            chosen.experience = this.experience;
            chosen.attack = this.attack;
            chosen.defence = this.defence;
            chosen.hp= this.hp;
            chosen.equipArmor(new Armor("Basic", 1));
            chosen.equipWeapon(new Weapon("Basic", 1));
            chosen.equipHelm(new Helm("Basic", 1));
            chosen.tLat =0;
            chosen.tLong=0;
            return chosen;
        }
    }
    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void equipArmor(Armor armor) {
        this.armor = armor;
    }
    public void equipHelm(Helm helm) {
        this.helm = helm;
    }
    public String getrole(String role) {return this.role;}
    public int getlevel() {return this.level; }
    public int getexperience(){return this.experience;}
    public void setLevel(int level){this.level = level;}
    public int getattack() { return this.attack ;}
    public int getdefence() {return this.defence;}
    public int getHP() {return this.hp;}
    public void setHp(int hp){this.hp = hp;}
    public void setExperience(int experience){this.experience = experience;}
    public void setLocation(Tile i){this.location = i;}
    public String getName() {return this.name;}
    public Tile CurrentLocation(){return this.location;}
    public Armor getArmor() {
        return armor;
    }
    public Helm getHelm() {
        return helm;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setHelm(Helm helm) {
        this.helm = helm;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

