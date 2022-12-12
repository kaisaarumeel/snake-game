package group13.frontend;

import group13.SnakeGameMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;


public class HowToPlayController {
    // Creates and returns a new scene
    public static Scene getScene() throws Exception {
        //Loading the fxml file that has the design of the scene
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HowToPlayController.class.getResource("/HowToPlay.fxml"));
        Parent root = loader.load();
        return new Scene(root);
    }

    //If the back to menu button is clicked, goes back to the menu
    public void backToMenuButtonClicked(ActionEvent click){
        SnakeGameMain.showMenu();
    }
}
