package group13.frontend;

import group13.backend.Field;
import group13.backend.Snake;
import group13.backend.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Painter {
    public static void paint(Field field, GraphicsContext gc) throws FileNotFoundException {
        // paint the background black
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, 700, 700);

       /* // paint the food
        gc.setFill(Color.PINK);
        paintTile(field.getMouseTile(), gc);*/

        //setting the image for the mouse
        mouseImageTile(field, field.getMouseTile(), gc);

        //paint the snake
        Snake snake = field.getSnake();
        gc.setFill(Color.WHITE);
        snake.getSnakeBody().forEach(tile -> paintTile(tile, gc));
    }

    private static void paintTile(Tile tile, GraphicsContext gc) {
        gc.fillRect(tile.getX(), tile.getY(), 25, 25);
    }

    private static void mouseImageTile(Field field, Tile tile, GraphicsContext gc) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("group13/frontend/assets/mouse.png");
        Image mouseImage = new Image(inputstream, 30, 30, false, false);
        gc.drawImage(mouseImage, field.getMouseTile().getX(), field.getMouseTile().getY());
    }
}
