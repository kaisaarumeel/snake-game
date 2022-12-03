package group13;


import group13.frontend.HowToPlayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class SnakeGameMain extends Application {
    public static Stage stage;
    public static Scene menuScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FileInputStream inputstream = new FileInputStream("snakegame/src/main/resources/SnakeGameIcon - Copy.png");
        Image icon = new Image(inputstream);
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Snake Game");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));

        stage = primaryStage;
        Parent root = FXMLLoader.load(SnakeGameMain.class.getResource("/Menu.fxml"));
        menuScene = new Scene(root);

        menuScene.getStylesheets().add("MenuStylesheet.css");
        primaryStage.setTitle("SnakeGame Menu");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));


        primaryStage.setScene(menuScene);
        primaryStage.show();

    }
    public static void showMenu(){
        stage.setScene(menuScene);
    }


    public static void main(String[] args) {
        launch();
    }
}