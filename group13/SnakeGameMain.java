package group13;

import group13.snakegame.SnakeGame;
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeGameMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create new SnakeGame object (can be somewhere else when we have the menu already)
        SnakeGame game = new SnakeGame();

        primaryStage.setTitle("SnakeGame");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        // Set the scene to the SnakeGame scene (can be somewhere else when we have the menu already)
        primaryStage.setScene(game.getScene());
        primaryStage.show();

        // Starts the game (can be somewhere else when we have the menu already)
        game.startGame();
    }

    public static void main(String[] args) {
        launch();
    }
}