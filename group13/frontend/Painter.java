package group13.frontend;

import group13.backend.Field;
import group13.backend.Snake;
import group13.backend.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Painter {
    public static void paint(Field field, GraphicsContext gc) {
        // paint the background black
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, 700, 700);

        // paint the food
        gc.setFill(Color.PINK);
        paintTile(field.getMouseTile(), gc);

        //paint the snake
        Snake snake = field.getSnake();
        gc.setFill(Color.WHITE);
        snake.getSnakeBody().forEach(tile -> paintTile(tile, gc));
    }

    private static void paintTile(Tile tile, GraphicsContext gc) {
        gc.fillRect(tile.getX(), tile.getY(), 25, 25);
    }
}
