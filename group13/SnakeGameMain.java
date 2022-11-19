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
        Random random = new Random();

        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameMain.class.getResource("frontend/field-view.fxml"));

        Group root = new Group();

        // Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        Scene scene = new Scene(root, 700, 700);
        primaryStage.setTitle("SnakeGame");
        primaryStage.setResizable(false);
        
        Rectangle food = new Rectangle();
        int x = random.nextInt(700/25)*25;
        int y = random.nextInt(700/25)*25;
        food.setX(x);
        food.setY(y);
        food.setWidth(25);
        food.setHeight(25);
        food.setFill(Color.RED);

        root.getChildren().add(food);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}