package group13.frontend;

import group13.SnakeGameMain;
import group13.backend.Field;
import group13.backend.Snake;
import group13.backend.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class Renderer {
    public static Image mouseImage;
    public static void render(Field field, GraphicsContext gc) throws Exception {
        // First render the field, paint the background black
        Color darkGray = Color.web("#1a1a1a");
        gc.setFill(darkGray);
        gc.fillRect(0,0, field.getWidth(), field.getHeight());

        // Render the border
        Color grey = Color.web("#524F4F");
        gc.setFill(grey);
        field.getBorder().forEach(tile -> renderBorderTile(tile, gc));

        // Render bottom bar
        gc.setFill(darkGray);
        gc.fillRect(0, field.getHeight(), field.getWidth(), 50);

        //setting the image for the mouse
        renderMouseImageTile(field, field.getMouseTile(), gc);

        Snake snake = field.getSnake();
        // Render snake head
        renderSnakeHead(field, snake.getSnakeBody().get(0), gc);
        //render the snake
        setFillGradient(gc);
        for (int i = 1; i < snake.getSnakeBody().size(); i++) {
            renderTile(snake.getSnakeBody().get(i), gc);
        }

        // Render the score
        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + field.getTotalScore(), 15, field.getHeight() + 33);
        gc.setFont(Font.font("Pixeboy", FontWeight.BOLD, 25));
    }

    private static void renderTile(Tile tile, GraphicsContext gc) {
        gc.fillRoundRect(tile.getX(), tile.getY(), 25, 25, 15, 25);
       // gc.fillRect(tile.getX(), tile.getY(), 25, 25);
    }

    private static void renderBorderTile(Tile tile, GraphicsContext gc) {
        gc.fillRect(tile.getX(), tile.getY(), 25, 25);
    }
    private static void renderMouseImageTile(Field field, Tile tile, GraphicsContext gc) throws Exception {
        // First checks if the image for the mouse has been loaded or not
        if (mouseImage == null) {
            // If not, loads the image
            // FileInputStream inputstream = new FileInputStream("src/main/resources/mouse.png");
            mouseImage = new Image(Objects.requireNonNull(SnakeGameMain.class.getResource("/Images/mouse.png")).openStream(), 30, 30, false, false);
            // inputstream.close();
        }
        // Renders the image
        gc.drawImage(mouseImage, field.getMouseTile().getX(), field.getMouseTile().getY());
    }

    //Renders the snake head to have eyes, changes the fill depending on the direction of the snake
    private static void renderSnakeHead(Field field, Tile tile, GraphicsContext gc) throws Exception {
        setFillGradient(gc);
        gc.fillRoundRect(tile.getX(), tile.getY(), 25, 25, 15, 25);
        gc.setFill(Color.WHITE);
        switch (field.getSnake().getDirection()) {
            case LEFT -> {
                gc.fillRect(tile.getX() + 6, tile.getY() + 7, 3, 3);
                gc.fillRect(tile.getX() + 6, tile.getY() + 15, 3, 3);
            }
            case RIGHT -> {
                gc.fillRect(tile.getX() + 19, tile.getY() + 7, 3, 3);
                gc.fillRect(tile.getX() + 19, tile.getY() + 15, 3, 3);
            }
            case DOWN -> {
                gc.fillRect(tile.getX() + 7, tile.getY() + 19, 3, 3);
                gc.fillRect(tile.getX() + 15, tile.getY() + 19, 3, 3);
            }
            case UP -> {
                gc.fillRect(tile.getX() + 7, tile.getY() + 6, 3, 3);
                gc.fillRect(tile.getX() + 15, tile.getY() + 6, 3, 3);
            }
        }
    }

    public static void setFillGradient(GraphicsContext gc) {
        Stop[] stops1 = new Stop[] { new Stop(0, Color.web("#B5FBD2")),
                new Stop(1, Color.web("#242926"))};

        RadialGradient lg1 = new RadialGradient(0, 0, 0.5, 0.5, 0.8, true,
                CycleMethod.NO_CYCLE, stops1);

        gc.setFill(lg1);
    }
}
