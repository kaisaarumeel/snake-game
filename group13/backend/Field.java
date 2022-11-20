package group13.backend;

import java.util.Random;

public class Field {
    private static final int TILE_SIZE = 25;
    private static final Random random = new Random();

    private Mouse mouse;

    private Snake snake;

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
        }
    }

    public void left(){
        if(snake.getDirection() != Direction.RIGHT){
            snake.setDirection(Direction.LEFT);
        }
    }

    public void grow() {
        Tile tile;

        if (snake.getDirection().equals(Direction.UP)){                        //Check where the snake is moving; to add the new rectangle to the right place.
            tile = new Tile(snake.getSnakeBody().get(0).getX(), snake.getSnakeBody().get(0).getY() - TILE_SIZE);             //If snake is moving up the new rectangle will have the same x-coordinate as the head of the snake,


        } else if (snake.getDirection().equals(Direction.DOWN)) {
            tile = new Tile(snake.getSnakeBody().get(0).getX(), snake.getSnakeBody().get(0).getY() + TILE_SIZE);


        } else if (snake.getDirection().equals(Direction.RIGHT)) {
            tile = new Tile(snake.getSnakeBody().get(0).getX() + TILE_SIZE, snake.getSnakeBody().get(0).getY());

        } else {
            tile = new Tile(snake.getSnakeBody().get(0).getX() - TILE_SIZE, snake.getSnakeBody().get(0).getY());

        }

        snake.getSnakeBody().add(0, tile);           //After figuring out the right coordinate for the new rectangle, it will be added to the arraylist.
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
        moveSnake();
        eatMouse();
    }

    public void eatMouse() {
    //if snake head position is at mouse position then spawn the mouse again
        if (snake.getSnakeBody().get(0).equals(mouse.getTile())) {
          this.grow();
          spawnMouse();
        }
    }


}

