package controller;

import model.characters.Hero;
import model.characters.Loot;
import model.characters.badguys.Villain;
import model.map.Tile;
import model.Model;
import view.gui.guiView;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class guiController{
    private Model model;
    private guiView view;

    public guiController() {
        this.model = new Model();
    }
    public Model getModel() {
        return model;
    }
    private Boolean getBinaryReply() {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        System.out.println("Your reply is " + input);
        while(input.compareTo("y") != 0 &&  input.compareTo("n") != 0)
        {
            // view action     this.view.printToScreen("Could you make your intentions clear?");
            input = scan.next();
        }
        if(input == "y")
            return true;
        return false;
    }
    interface InputOptions{void option();}
    private void villainAttacks(Hero h, Villain v) {
        int totalDefence  = h.getdefence() + h.getArmor().getDefence()/10;
        int totalDamage = v.getAttack() - totalDefence;
        if (totalDamage < 0)
            totalDamage = 0;
        int currentHP = h.getHP() - totalDamage;
        int hpLost = h.getHP() - currentHP;
        h.setHp(currentHP);
        if (v.getHP() <= 0)
            v.setHp(0);
        // view action   this.view.printToScreen("[Villain Attack] The Hero of the Story loses " + hpLost
        // view action      + " HP, the current HP is " + currentHP);


    }
    private void heroAttacks(Hero h, Villain v) {
        int heroTotalattack = h.getattack() + h.getWeapon().getAttack();
        if (heroTotalattack < 0)
            heroTotalattack = 0;
        v.setHp( v.getHP() - heroTotalattack);
        if (v.getHP() <= 0)
            v.setHp(0);
        // view action this.view.printToScreen("[Hero Attack] The villain loses " + heroTotalattack
        // view action+ " HP, the current HP is " + v.getHP() );
    }
    private void resolveEncounter(Hero h, Villain v) {
        heroAttacks(h,v);
        while(h.getHP() > 0 && v.getHP() > 0){
            villainAttacks(h,v);
            heroAttacks(h,v);
        }
        if (h.getHP() == 0){
            // view action  this.view.printToScreen("The Challenger succumbs to his wounds");
            this.model.setPlayerlose();
        }
        else {
            // view action this.view.printToScreen("The triumphs over " + v.toString());
            this.model.gainExpAndLevels(v,h);
            Loot l = this.model.generateLoot(v,h);
            if (l != null){
                // view action    this.view.printToScreen("Should the Challenger Replace his " + l.toString() + "? (y/n)");
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

        if ( t == null){
            // view action this.view.printToScreen("The Hero has reached the edge of the map. Ending the Game.");
            System.exit(0);
        }
        // view action  this.view.printRoomChange(current, t,"North");
        Villain villain = t.getVillain();
        if (villain != null){
            // view action this.view.announceVillain(villain);

            resolveEncounter(hero,villain);
            if (hero.getHP() == 0){
                System.out.println("Hero Dieded!");
            }
            else{
                System.out.println("Hero won the battle ! current HP :" + hero.getHP());
                this.model.gainExpAndLevels(villain,hero);
            }
        }
        t.setVillain(null);
        hero.setLocation(t);
        hero.increaseTlat();
    }
    private void goSouth(){}
    private void goEast(){}
    private void goWest(){}
    private void SaveHeroandQuit(){}

    private consoleController.InputOptions[] inputOptions = new consoleController.InputOptions[]{
            new consoleController.InputOptions() { public void option() { UpdateStats();}},
            new consoleController.InputOptions() { public void option() { UpdateLocation();}},
            new consoleController.InputOptions() { public void option() { goNorth();}},
            new consoleController.InputOptions() { public void option() { goSouth();}},
            new consoleController.InputOptions() { public void option() { goEast();}},
            new consoleController.InputOptions() { public void option() { goWest();}},
            new consoleController.InputOptions() { public void option() { SaveHeroandQuit();}},
    };
    public void ModelInitMap(){
        this.model.setMap(this.model.getHero());
    }
    public void UpdateStats() {
        // view actionthis.view.printHero(this.model.getHero());
    }
    public void UpdateLocation(){
        // view actionthis.view.printLocationFromStart(this.model.getHero());
    }

    public void initView(){
        this.view = new guiView(this);
    }

    public guiView getView() {
        return view;
    }

    public void Narrate(String str){
        this.view.Narrate(str);
    }

    public Vector<String> readFileintoVector(){
        Vector <String> list = new Vector<String>();
        list.add("Saved Heroes");
        try {
            File file = new File("./Saved.txt");
            Scanner c = new Scanner(file);
            while(c.hasNextLine())
                list.add(c.nextLine());
        }
        catch(FileNotFoundException e){
            list.add("No Saved Heroes");
            return list;
        }
        return list;
    }
}

