package model.map;
import model.characters.*;
import model.characters.badguys.Villain;
import java.util.Random;


public class consoleModel {
   private Map Map;
   private Hero Hero;
   public boolean win = false;
   public boolean lose = false;
   private String end;

   public consoleModel(){
       this.Map = null;
       this.Hero = null;
   }
   public void setHero(Hero chosen){
       this.Hero = chosen;
   }
   public Hero getHero(){
        return this.Hero;
    }
   public void setMap(Hero V){
       this.Map = new Map(V);
    }
   public void setPlayerlose(){
        this.win = false;
        this.lose = true;
    }
   public Loot generateLoot(Villain v, Hero h) {
       Random ranb = new Random();
       Random rant = new Random();
       int nb= ranb.nextInt(h.getlevel() + 1) + 5;
        int nt = rant.nextInt(4);
        if ( nt == 1)
            return new Armor( "armor", nb);
        else if (nt == 2 )
            return new Helm("Helm", nb);
        else
            return new Weapon( "Weapon", nb);
    }
   public void resolveLoot(Loot l, Hero h) {
       if ( l.getClass() == Armor.class){
           h.setArmor((Armor) l);
       }
       else if (l.getClass() == Helm.class) {
           h.setHelm((Helm) l);}
        else {
           h.setWeapon((Weapon)l);
        }
    }

    public void gainExpAndLevels(Villain v,Hero h) {
       int earn = v.getHP()/2;
       int tlvl = h.getlevel()*1000 + ((h.getlevel() - 1) * (h.getlevel() - 1) * 450);
       int cexp = h.getexperience();
       int texp = earn + cexp;
       if (texp > tlvl){
           h.setExperience(tlvl - texp);
           h.setLevel(h.getlevel() + 1);
           return;
       }
       h.setExperience(texp);
   }

    public boolean checkForWin(Hero h) {
       if (h.CurrentLocation().getNorth() == null || h.CurrentLocation().getSouth() == null||
               h.CurrentLocation().getEast() == null|| h.CurrentLocation().getWest() == null){
           return true;
       }
       return false;
    }
}
