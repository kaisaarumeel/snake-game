package group13.backend;

public class Mouse {
    //The mouse is the food the snake eats, it fills one tile in the field
    private Tile tile;

    public Mouse(Tile tile){
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}