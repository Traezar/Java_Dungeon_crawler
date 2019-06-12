package model.map;

import model.characters.badguys.Villain;

public class Tile{
    private boolean Edge;
    private Villain villain;
    private Tile north;
    private Tile south;
    private Tile east;
    private Tile west;


    public Tile(){
        this.Edge= false;
        this.villain = null;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
    }

    protected void setEdgetoTrue(){
        this.Edge = true;
    }
    protected void setNorth(Tile north){
        this.north = north;
    }
    protected void setSouth(Tile south){
        this.south = south;
    }
    protected void setEast(Tile east){
        this.east = east;
    }
    protected void setWest(Tile west){
        this.west = west;
    }

    public Tile getNorth(){
        return this.north;
    }
    public Tile getSouth(){
        return this.south;
    }
    public Tile getEast(){
        return this.east;
    }
    public Tile getWest(){
        return this.west ;
    }
    public boolean isEdge(){
        return this.Edge;
    }
    public Villain getVillain() {
        return villain;
    }
    public void houseVillain(Villain v) {
        this.villain = v;
    }
}
