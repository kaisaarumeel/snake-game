package group13.backend;
    /*
     * The mouse is the food the snake eats.
     * A mouse fills one tile in the field.
     */
public class Mouse {
    private Tile tile;

    public Mouse(Tile tile){
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

}