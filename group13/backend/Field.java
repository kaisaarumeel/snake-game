package group13.backend;

import java.util.Random;

public class Field {
    private static final int TILE_SIZE = 25;
    private static final Random random = new Random();

    private Mouse mouse;

    private Snake snake;
    private boolean gameOver;

    public Field(){
        Tile[] initialTiles = new Tile[]{new Tile(350, 350), new Tile(375, 350), new Tile(400, 350)};
        this.snake = new Snake(initialTiles);
        this.spawnMouse();
    }
    //The mechanism of moving the snake on the field is adding a new rectangle in front
    public void moveSnake(){
        if (snake.getDirection() != null){     //of the snake head, considering the snake direction. Lastly removing the last rectangle.
            grow();                 //Moving has the same principle as grow() method,
            snake.getSnakeBody().remove(snake.getSnakeBody().get(snake.getSnakeBody().size()-1));    //but we remove the last rectangle of the snake.
        }


    }


    public boolean gameOver(){
        if(snake.getSnakeBody().get(0).getX() >= 700  || snake.getSnakeBody().get(0).getX() < 0 || snake.getSnakeBody().get(0).getY() >= 700 || snake.getSnakeBody().get(0).getY() < 0){
             return true;
        }   // Check if the head of the snake collide with the border, if yes return true.

       for (int i = 1; i < snake.getSnakeBody().size(); i++){
            if(snake.getSnakeBody().get(0).equals(snake.getSnakeBody().get(i))){
                return true;
            }        // Check if the head of the snake collide with the snake body, if yes return true.
        }
        return false;
    }


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
        }
    }

    public void left(){
        if(snake.getDirection() != Direction.RIGHT){
            snake.setDirection(Direction.LEFT);
        }
    }

    public void grow() {
        Tile tile;
//Check where the snake is moving; to add the new rectangle to the right place.
        if (snake.getDirection().equals(Direction.UP)){
            tile = new Tile(snake.getSnakeBody().get(0).getX(), snake.getSnakeBody().get(0).getY() - TILE_SIZE);


        } else if (snake.getDirection().equals(Direction.DOWN)) {
            tile = new Tile(snake.getSnakeBody().get(0).getX(), snake.getSnakeBody().get(0).getY() + TILE_SIZE);


        } else if (snake.getDirection().equals(Direction.RIGHT)) {
            tile = new Tile(snake.getSnakeBody().get(0).getX() + TILE_SIZE, snake.getSnakeBody().get(0).getY());

        } else {
            tile = new Tile(snake.getSnakeBody().get(0).getX() - TILE_SIZE, snake.getSnakeBody().get(0).getY());

        }

        snake.getSnakeBody().add(0, tile);
    }



    //Spawns the mouse randomly
    public void spawnMouse() {

        //if mouse spawn position is at snake position then redo the process until you find a pos not on snake
        Tile tile;
        do {
            int x = (int) random.nextInt(700 / TILE_SIZE) * TILE_SIZE;
            int y = (int) random.nextInt(700 / TILE_SIZE) * TILE_SIZE;

            tile = new Tile(x, y);
        } while (this.snake.getSnakeBody().contains(tile));
        this.mouse = new Mouse(tile);
    }

    public Tile getMouseTile() {
        return this.mouse.getTile();
    }

    public Snake getSnake() {
        return this.snake;
    }

    public void update() {
        // Move the snake by one tile
        moveSnake();
        // Check if snake ate mouse
        eatMouse();
        // Check whether game is over
        gameOver();
    }

    public void eatMouse() {
    //if snake head position is at mouse position then spawn the mouse again
        if (snake.getSnakeBody().get(0).equals(mouse.getTile())) {
          this.grow();
          spawnMouse();
        }
    }


}

