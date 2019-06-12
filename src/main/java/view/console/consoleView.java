package view.console;
import model.*;
import model.characters.Hero;
import model.characters.badguys.Villain;

public class consoleView {

    public void printHero(Hero v){
        System.out.println(v.getName() +
                " is level " + v.getlevel() +
                ",\nExperience : " + v.getexperience() +
                ",\n HP : " + v.getHP()  +
                ",\n Attack : " + v.getattack() +
                ",\n Defence : " + v.getdefence());
    }
    public void printToScreenOption(){
        System.out.printf("Enter in the number of the option you would choose" +
                "1) Display Hero Status\n" +
                "2) Display Location\n" +
                "3) Go North\n" +
                "4) Go South\n" +
                "5) Go East\n" +
                "6) Go West\n" +
                "7) SaveAndQuit\n" +
                "Choice : ");
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
        this.printToScreen("In the room, there appears to be a " + v.toString());
    }
    public void printRoomChange(String dir) {
        System.out.println("After much deliberation the chosen on decides to head " + dir);
    }

    public void printToScreen(String s) {
        System.out.println(s);
    }
}

