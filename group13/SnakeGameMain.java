package group13;

import group13.snakegame.SnakeGame;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGameMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create new SnakeGame object (can be somewhere else when we have the menu already)
        //SnakeGame game = new SnakeGame();

        primaryStage.setTitle("SnakeGame Menu");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));

        VBox menuLayout = new VBox(25);
        Scene menuScene = new Scene(menuLayout, 700, 700, Color.BLACK);
        primaryStage.setScene(menuScene);
        menuLayout.setAlignment(Pos.CENTER);

        Button startGame = new Button("Play the SnakeGame");
        startGame.setAlignment(Pos.CENTER);

        Button manual = new Button("Manual");
        Button leaderBoard =  new Button("Leader Board");

        menuLayout.getChildren().addAll(startGame, manual, leaderBoard);

        startGame.setOnMousePressed(e -> {
            try{
                SnakeGame game = new SnakeGame();
                primaryStage.setScene(game.getScene());
                game.startGame();
            } catch(Exception e1){
                System.out.println("Please try again later");
            }
        });

        primaryStage.show();

    }


        // Set the scene to the SnakeGame scene (can be somewhere else when we have the menu already)
        //primaryStage.setScene(game.getScene());
        // Starts the game (can be somewhere else when we have the menu already)
        //game.startGame();

    public static void main(String[] args) {
        launch();
    }
}