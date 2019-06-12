package controller;
import model.characters.Hero;
import model.characters.Loot;
import model.characters.badguys.Villain;
import model.map.*;
import view.console.consoleView;
import java.util.Scanner;
public class consoleController {
      private  consoleModel model;
      private  consoleView  view;

    public consoleController() {
        this.model = new consoleModel();
        this.view = new consoleView();
    }
    public Boolean getBinaryReply() {
        Scanner scan = new Scanner(System.in);
        String input = scan.next().toString();
        while(input != "y" || input != "n" )
        {
            this.view.printToScreen("Could you make your intentions clear?");
            input = scan.next().toString();
        }
        if(input == "y")
            return true;
        return false;
    }
    interface InputOptions{void option();}


    private void resolveEncounter(Hero h, Villain v) {

        Loot l = null;
        v.setHp( v.getHP() - (h.getattack() + h.getWeapon().getAttack()));
        while(h.getHP() != 0 && v.getHP() != 0){
            h.setHp( h.getHP() + v.getAttack());
            v.setHp( v.getHP() - (h.getattack() + h.getWeapon().getAttack()));
        }
        if (h.getHP() == 0){
            this.view.printToScreen("The Challenger succumbs to his wounds");
            this.model.setPlayerlose();
        }
        else {
            this.view.printToScreen("The triumphs over " + v.getClass());
            l = this.model.generateLoot(v,h);
            if (l != null){
                this.view.printToScreen("Should the Challenger Replace his " + l.getClass() + "? (y/n)");
                if(this.getBinaryReply()){
                    this.model.resolveLoot(l, h);
                }
            }
        }
    }







    private void goNorth(){
        Hero hero = this.model.getHero();
        Tile current = hero.CurrentLocation();
        Tile t = current.getNorth();

        this.view.printRoomChange("North");
        Villain villain = t.getVillain();
        if (villain != null){
           this.view.announceVillain(villain);
            resolveEncounter(hero,villain);
            if (hero.getHP() != 0){
                System.out.println("Hero Dieded!");
            }
            else{
                System.out.println("Hero won!");
            }
        }
    };

    private void goSouth(){}
    private void goEast(){}
    private void goWest(){}
    private void SaveHero(){}
    private void Quit(){}

    private InputOptions[] inputOptions = new InputOptions[]{
            new InputOptions() { public void option() { UpdateStats();}},
            new InputOptions() { public void option() { UpdateLocation();}},
            new InputOptions() { public void option() { goNorth();}},
            new InputOptions() { public void option() { goSouth();}},
            new InputOptions() { public void option() { goEast();}},
            new InputOptions() { public void option() { goWest();}},
            new InputOptions() { public void option() { SaveHero();}},
            new InputOptions() { public void option() { Quit();}}
    };



    public void ChooseHero(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the Name of the Chosen One ?\n Declare Yourself : ");
        String name = scan.nextLine();
        System.out.println("What is thy trade?\n Not a Ruby Developer i hope ?\n" +
                "Perhaps a Warrior or a Mage : ?");
        String role = scan.nextLine();
        System.out.println("What is your skill level attained ?\n What is your level : ");
        String lv = scan.nextLine();
        int level = Integer.parseInt(lv);
        Hero chosen = new Hero.HeroBuilder(name)
                .setlevel(level)
                .setrole(role)
                .setattack(level + 30)
                .setdefence(level + 20)
                .setexperience(0)
                .setHP(level * 5 + 20)
                .Build();
        this.model.setHero(chosen);
        this.view.printHero(this.model.getHero());
    }
    public void ModelInitMap(){
        this.model.setMap(this.model.getHero());
    }
    public void UpdateStats() {
        this.view.printHero(this.model.getHero());
    }
    public void UpdateLocation(){
        this.view.printLocationFromStart(this.model.getHero());
    }
    public boolean gameStillRunning() {
        return (!this.model.win && !this.model.lose);
    }
    public void getInputAndUpdateModel() {
        int input;
        Scanner scan = new Scanner(System.in);

        do {
            this.view.printToScreen("These are the choices limited as they maybe, What will our challenger do ?");
            this.view.printToScreenOption();
            input = Integer.parseInt(scan.nextLine());
        } while(input > 8 || input <= 0);
        inputOptions[input - 1].option();
    }

}