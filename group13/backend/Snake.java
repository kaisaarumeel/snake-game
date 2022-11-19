package group13.backend;

import group13.backend.Direction;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class Snake{

    private ArrayList <Integer[]> snakeBody;
    private Direction direction;    //Will store the direction which the snake is moving.


    public Snake(){
        Integer[][] initialCoordinates = new Integer[][]{{14, 14}, {14, 15}, {14, 16}};
        this.snakeBody = new ArrayList<>(Arrays.asList(initialCoordinates[0], initialCoordinates[1], initialCoordinates[2]));
    }

    //Getter method for the body length.
    public int getBodyLength(){return snakeBody.size();}

    public void grow(int row, int column){
        this.snakeBody.add(new Integer[]{row, column});
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
