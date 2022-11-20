package group13.backend;

public class Mouse {

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