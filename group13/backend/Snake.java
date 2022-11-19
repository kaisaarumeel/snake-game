package group13.backend;

import group13.backend.Direction;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class Snake{

    private ArrayList <Integer[]> snakeBody;
    private Direction direction;    //Will store the direction which the snake is moving.


    public Snake(){
        Integer[][] initialCoordinates = new Integer[][]{{14, 14}, {15, 14}, {16, 14}};
        this.snakeBody = new ArrayList<>(Arrays.asList(initialCoordinates[0], initialCoordinates[1], initialCoordinates[2]));
        this.direction = Direction.LEFT;
    }

    //Getter method for the body length.
    public int getBodyLength(){return snakeBody.size();}
    public ArrayList<Integer[]> getSnakeBody() {
        return snakeBody;
    }

    public Integer[] getBodyPart(int bodyPartNum) {
        return snakeBody.get(bodyPartNum);
    }

    public void setBodyPart(int bodyPartNum, int newRow, int newColumn) {
        Integer[] newBodyPart = new Integer[]{newRow, newColumn};
        this.snakeBody.set(bodyPartNum, newBodyPart);
    }

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
