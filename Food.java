
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Food {


    static int width = 30;
    static int height = 30;
    static int dimension = 20;
    int mouseX;
    int mouseY;

    static final int panelsize = (width * height) / (dimension * dimension);
    int positionX;
    int positionY;
    ArrayList<Rectangle> snakeBody;



    public void spawnMouse() { //Spawns the mouse randomly

        boolean onSnake = false;

        //if mouse spawn position is at snake position then redo the process until you find a pos not on snake
        while (onSnake == false) {
            mouseX = (int) (Math.random() * (width*dimension));
            mouseY = (int) (Math.random() * (height*dimension));
            for (Rectangle rectangle : snakeBody) {
                if (rectangle.getX() == mouseX && rectangle.getY() == mouseY) {
                    onSnake = false;
                } else {
                    onSnake = true;
                }
            }
        }
    }


    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
}