import javafx.scene.shape.Rectangle;
import java.util.ArrayList;


public class Snake{

    //The game window has 20 squares (dimension = 20), each square dimension is width*height (30*30).
    //those are temporarily that are here just to help me understand, Ideally these value will be imported from the mainGame class

    private final static int height = 30;
    private final static int width = 30;
    private final int dimension = 20;
    private Direction direction;    //Will store the direction which the snake is moving.

    private final int startPositionX = (width * height) / 2 - width;    //Snake spawn at the middle of the window when the game begins.
    private final int startPositionY = (height * height) /2 - height;   //Snake spawn at the middle of the window when the game begins.

    private ArrayList <Rectangle> snakeBody;

    Snake(){
        snakeBody = new ArrayList<>();                      //The snake starts with 3 rectangles.
        Rectangle rectangle = new Rectangle(width,height);  //The rectangle has the same dimension as the square of the window
        rectangle.setX(startPositionX);                     //Specify x-coordinate to spawn the rectangle at.
        rectangle.setY(startPositionY);                     //Specify y-coordinate to spawn the rectangle at.
        snakeBody.add(rectangle);                           //Then the rectangle is added to the arraylist.

        rectangle = new Rectangle();
        rectangle.setX(startPositionX + width);             // +width: to spawn after the first rectangle,
        rectangle.setY(startPositionY);                     // but at the same y-coordinate.
        snakeBody.add(rectangle);

        rectangle = new Rectangle();
        rectangle.setX(startPositionX + (2*width));
        rectangle.setY(startPositionY);
        snakeBody.add(rectangle);

    }
    public void grow(){                                             //When the snake eat food
        Rectangle rectangle = new Rectangle(width,height);          //First create the new rectangle that will be added.

        if (direction.equals(Direction.UP)){                        //Check where the snake is moving; to add the new rectangle to the right place.
            rectangle.setX(snakeBody.get(0).getX());                //If snake is moving up the new rectangle will have the same x-coordinate as the head of the snake,
            rectangle.setY(snakeBody.get(0).getY() - height);       //but the y-coordinate will be one square above the head of the snake.


        } else if (direction.equals(Direction.DOWN)) {
            rectangle.setX(snakeBody.get(0).getX());
            rectangle.setY(snakeBody.get(0).getY() + height);


        } else if (direction.equals(Direction.RIGHT)) {
            rectangle.setX(snakeBody.get(0).getX() + width);
            rectangle.setY(snakeBody.get(0).getY());

        } else {
            rectangle.setX(snakeBody.get(0).getX() - width);
            rectangle.setY(snakeBody.get(0).getY());

        }

        snakeBody.add(0, rectangle);           //After figuring out the right coordinate for the new rectangle, it will be added to the arraylist.
    }


    //The attributes with no getters/setters, means the snake class won't have, but it will get them from other classes.

    public ArrayList<Rectangle> getSnakeBody() {
        return snakeBody;
    }
    public void setSnakeBody(ArrayList<Rectangle> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public Direction getDirection() {
        return direction;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getDimension(){return dimension;}
}
