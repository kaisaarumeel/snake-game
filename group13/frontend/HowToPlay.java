package group13.frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;

public class HowToPlay {
    private static GraphicsContext context;
    public static Image keyboard;
    public static Image wasdKeys;


    private static Canvas canvas;

    // Creates and returns a new scene
    public static Scene getScene() throws Exception {
        Group root = new Group();
        canvas = new Canvas(700, 700);
        context = canvas.getGraphicsContext2D();
        setContext(context);
        root.getChildren().add(canvas);
        return new Scene(root);
    }

    public static void setContext(GraphicsContext context) throws Exception {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, 700, 700);

        context.setFont(Font.font("Impact", FontWeight.BOLD, 30));
        context.setFill(Color.MAROON);
        context.fillText("HOW TO PLAY:", 250, 30);

        renderKeyboardImages(context);
    }

    private static void renderKeyboardImages (GraphicsContext gc) throws Exception {
        // First checks if the image for the mouse has been loaded or not
        if (keyboard == null) {
            // If not, loads the image
            FileInputStream inputstream = new FileInputStream("group13/frontend/assets/arrowKeyboard.png");
            keyboard = new Image(inputstream, 150, 100, false, false);
            inputstream.close();
        }
        // Renders the image
        gc.drawImage(keyboard, 300, 300);

        if (wasdKeys == null) {
            // If not, loads the image
            FileInputStream inputstream = new FileInputStream("group13/frontend/assets/wasdKeyboard.png");
            wasdKeys = new Image(inputstream, 150, 100, false, false);
            inputstream.close();
        }
        // Renders the image
        gc.drawImage(wasdKeys, 100, 100);
    }
}
