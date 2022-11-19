package group13.backend;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private static final int HEIGHT = 28;
    private static final int WIDTH = 28;
    private static final int TILE_SIZE = 25;
    private static final Random random = new Random();

    private Mouse mouse;

    private Snake snake;

    public Field(){
        this.snake = new Snake();
        this.spawnMouse();
    }
    //The mechanism of moving the snake on the field is adding a new rectangle in front
    public void move(){

    }


    /*public boolean die(){
        if(snake.getSnakeBody().get(0).getX() >= width* snake.getDimension() || snake.getSnakeBody().get(0).getX() <= 0 || snake.getSnakeBody().get(0).getY() >= height* snake.getDimension() || snake.getSnakeBody().get(0).getY() <= 0){
            return true;
        }   // Check if the head of the snake collide with the border, if yes return true.

        for (int i = 1; i < snake.getSnakeBody().size(); i++){
            if(snake.getSnakeBody().get(0).getX() == snake.getSnakeBody().get(i).getX() && snake.getSnakeBody().get(0).getY() == snake.getSnakeBody().get(i).getY()){
                return true;
            }        // Check if the head of the snake collide with the snake body, if yes return true.
        }
        return false;
    }*/


    public void up(){                           //Changes the direction of the snake.
        if(snake.getDirection() != Direction.DOWN){        //Make it not possible to change in the opposite direction.
            snake.setDirection(Direction.UP);
        }
    }

    public void down(){
        if(snake.getDirection() != Direction.UP){
            snake.setDirection(Direction.DOWN);
        }
    }

    public void right(){
        if(snake.getDirection() != Direction.LEFT){
            snake.setDirection(Direction.RIGHT);
        }    }

    public void left(){
        if(snake.getDirection() != Direction.RIGHT){
            snake.setDirection(Direction.LEFT);
        }
    }

    public void moveSnake() {
        //of the snake head, considering the snake direction. Lastly removing the last rectangle.
        if (snake.getDirection() != null){
            for (int i = snake.getBodyLength(); i > 0; i--) {
                Integer[] bodyPart = snake.getBodyPart(i);
                bodyPart[0] = snake.getBodyPart(i - 1)[0];
                bodyPart[1] = snake.getBodyPart(i - 1)[1];
                snake.setBodyPart(i, bodyPart[0], bodyPart[1]);
            }
        }

        if (snake.getDirection().equals(Direction.UP)){
            //Check where the snake is moving; to add the new rectangle to the right place.
            Integer[] head = snake.getBodyPart(0);
            int X = head[0];
            int Y = head[1] - TILE_SIZE;
            snake.setBodyPart(0, X, Y);



        } else if (snake.getDirection().equals(Direction.DOWN)) {
            Integer[] head = snake.getBodyPart(0);
            int X = head[0];
            int Y = head[1] + TILE_SIZE;
            snake.setBodyPart(0, X, Y);


        } else if (snake.getDirection().equals(Direction.RIGHT)) {
            Integer[] head = snake.getBodyPart(0);
            int X = head[0] - TILE_SIZE;
            int Y = head[1];
            snake.setBodyPart(0, X, Y);

        } else {
            Integer[] head = snake.getBodyPart(0);
            int X = head[0] + TILE_SIZE;
            int Y = head[1];
            snake.setBodyPart(0, X, Y);

        }

    }



    public void spawnMouse() { //Spawns the mouse randomly

        boolean onSnake = false;

        //if mouse spawn position is at snake position then redo the process until you find a pos not on snake
        while (onSnake == false) {

            int row = (int) random.nextInt(700 / TILE_SIZE) * TILE_SIZE;
            int column = (int) random.nextInt(700 / TILE_SIZE) * TILE_SIZE;
            this.mouse = new Mouse(row, column);
            for (int i = 0; i < snake.getBodyLength(); i++) {
                ArrayList<Integer[]> snakeBody = snake.getSnakeBody();
                if (snakeBody.get(i)[0] == mouse.getRow() && snakeBody.get(i)[1]  == mouse.getColumn()) {
                    onSnake = false;
                } else {
                    onSnake = true;
                }
            }
        }
    }

    public int getMouseRow() {
        return this.mouse.getRow();
    }

    public int getMouseColumn() {
        return this.mouse.getColumn();
    }

    /*public void eatMouse() { //if snakes position is at mouse position then spawn the mouse again

        if ((snake.getSnakeBody().get(0).getX() == mouse.getRow()) && (snake.getSnakeBody().get(0).getY() == mouse.getColumn())) {
            spawnMouse();
        }
    }*/


}

