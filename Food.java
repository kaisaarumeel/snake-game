import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Food {


    static int width = 30;
    static int height = 30;
    static int dimension = 20;
    int mouseX;
    int mouseY;

    static final int panelsize = (width * height) / (dimension * dimension);
    int[] positionX = new int[panelsize];
    int[] positionY = new int[panelsize];
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


    public void eatMouse() { //if snakes position is at mouse position then spawn the mouse again

        if ((positionX[0] == mouseX) && (positionY[0] == mouseY)) {
            spawnMouse();
        }
    }
}