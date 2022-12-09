package group13.backend;

import group13.backend.Direction;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class Snake{

    private ArrayList <Tile> snakeBody;

    //Will store the direction which the snake is moving.
    private Direction direction;

    public Snake(Tile[] initialTiles) {
        this.snakeBody = new ArrayList<>();
        this.snakeBody.addAll(Arrays.asList(initialTiles));
        this.direction = Direction.LEFT;
    }
    //When the snake grows, one tile is added to the body.
    public void grow(int x, int y){
        this.snakeBody.add(new Tile(x, y));
    }

    public ArrayList<Tile> getSnakeBody() {
        return snakeBody;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
