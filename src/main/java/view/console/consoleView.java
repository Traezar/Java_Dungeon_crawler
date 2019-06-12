package view.console;
import model.*;
import model.characters.Hero;
import model.characters.badguys.Villain;

public class consoleView {

    public void printHero(Hero v){
        System.out.println(v.getName() +
                "is level " + v.getlevel() +
                ", with an experience of " + v.getexperience() +
                ", with  " + v.getHP() + " HP" +
                ", has an attack of " + v.getattack() +
                ", and defence of " + v.getdefence());
    }

    public void printLocationFromStart(Hero v){
        int l = v.getlatitude();
        int h = v.getlongtitude();
        if (l == 0 && h == 0){
            System.out.println("At the Entrance of the Cavern");
            return;
        }
        System.out.println("The hero wanders in the darkness ....");
        if(l > 0){
            System.out.printf("He reckons he is east of his starting position by " + l);}
        else
            System.out.printf("He reckons he is west of his starting position by " + (l * (-1)));
        if(h > 0){
            System.out.println("and North  by " + h);}
        else
            System.out.println("and South by " + (h * (-1)));

    }
    public void announceVillain(Villain v){
        System.out.println("There appears to be a " + this.getClass() + "in the room");
        System.out.println("attack : " + v.getAttack());
        System.out.println("defence : " + v.getDefence());
        System.out.println("The HP of the this.getClass() is " + v.getHP());
    }
    public void printRoomChange(String dir) {
        System.out.println("After much deliberation the chosen on decides to head " + dir);
    }

    public void printToScreen(String s) {
        System.out.println(s);
    }
}

