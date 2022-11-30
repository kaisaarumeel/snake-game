package group13.backend;

public class Tile {
    private final int x;
    private final int y;
    //A tile has two coordinates.
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //Two tiles are equal when they have the same coordinates.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tile)) return false;
        Tile tile = (Tile) obj;
        return this.x == tile.getX() && this.y == tile.getY();
    }
}
