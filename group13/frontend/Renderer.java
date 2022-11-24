package group13.frontend;

import group13.backend.Field;
import group13.backend.Snake;
import group13.backend.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;

public class Renderer {
    public static Image mouseImage;
    public static void render(Field field, GraphicsContext gc) throws Exception {
        // paint the background black
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, 700, 700);

       /* // render the food
        gc.setFill(Color.PINK);
        paintTile(field.getMouseTile(), gc);*/

        //setting the image for the mouse
        renderMouseImageTile(field, field.getMouseTile(), gc);

        //render the snake
        Snake snake = field.getSnake();
        gc.setFill(Color.WHITE);
        snake.getSnakeBody().forEach(tile -> renderTile(tile, gc));
    }

    private static void renderTile(Tile tile, GraphicsContext gc) {
        gc.fillRect(tile.getX(), tile.getY(), 25, 25);
    }

    private static void renderMouseImageTile(Field field, Tile tile, GraphicsContext gc) throws Exception {
        // First checks if the image for the mouse has been loaded or not
        if (mouseImage == null) {
            // If not, loads the image
            FileInputStream inputstream = new FileInputStream("group13/frontend/assets/mouse.png");
            mouseImage = new Image(inputstream, 30, 30, false, false);
            inputstream.close();
        }
        // Renders the image
        gc.drawImage(mouseImage, field.getMouseTile().getX(), field.getMouseTile().getY());
    }
}
