package group13.frontend;

import group13.SnakeGameMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;

public class HowToPlayController {
    private static GraphicsContext context;
    public static Image keyboard;
    public static Image wasdKeys;


    private static Canvas canvas;

    // Creates and returns a new scene
    public static Scene getScene() throws Exception {
        Parent root = FXMLLoader.load(HowToPlayController.class.getResource("HowToPlay.fxml"));
        return new Scene(root);
    }

    public void backToMenuButtonClicked(ActionEvent click){
        SnakeGameMain.showMenu();
    }
}
