package model.characters.badguys;

import java.util.Random;

public class VillainFactory {

    public Villain spawn(){
            Random rand = new Random();
            int randomNum = rand.nextInt(100) + 1;
            if (randomNum == 80)
                return new Dragon(randomNum);
            else if (randomNum >= 40)
                return new Troll(randomNum);
            else
                return new Goblin(randomNum);
        }

    }
