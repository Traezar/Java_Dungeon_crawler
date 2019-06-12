package model.map;
import model.characters.Hero;
import model.characters.badguys.Villain;
import model.characters.badguys.VillainFactory;

public class Map {

    private Tile[][] map;
    private static VillainFactory lair = new VillainFactory();
    private int size;
    private Tile entrance;




    public Map(Hero v){
        int level = v.getlevel();
        this.size =  (((level - 1) * 5) + 10) - (level % 2);
        int i = this.size;
        this.map = new Tile[i][i];
        for (int j = 0; j < i ; j++) {
            for (int k = 0; k < i; k++) {
                this.map[j][k] = new Tile();
            }
        }
        for (int j = 0; j < i ; j++) {
            for (int k = 0; k < i; k++) {
                if (j == 0 || j == (i -1) || k == 0 || k == (i - 1))
                    this.map [j][k].setEdgetoTrue();
                if (j > 0 )
                    this.map[j][k].setNorth(this.map[j - 1][k]);
                if (j < i - 1)
                    this.map[j][k].setSouth(this.map[j + 1][k]);
                if (k > 0)
                    this.map[j][k].setWest(this.map[j][k - 1]);
                if (k < i - 1)
                    this.map[j][k].setEast(this.map[j][k + 1]);
                this.map[j][k].houseVillain(lair.spawn());
            }
        }
        this.entrance = map[i/2 + 1][i/2 + 1];
        System.out.println("Dungeon size of "+ i + " emerges from the Void!");
        v.setLocation(this.entrance);
    }
}
