package group13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class SnakeGameMain extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameMain.class.getResource("frontend/field-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        primaryStage.setTitle("SnakeGame");
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}