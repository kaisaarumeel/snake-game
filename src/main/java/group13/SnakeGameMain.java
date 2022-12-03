package group13;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class SnakeGameMain extends Application {
    public static Stage stage;
    public static Scene menuScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        File iconPath = new File("snakegame/src/main/resources/SnakeGameIcon - Copy.png");
        Image icon = new Image(String.valueOf(iconPath.toURL()));
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Snake Game");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));

        stage = primaryStage;
        File menu = new File("snakegame/src/main/resources/Menu.fxml");
        Parent root = FXMLLoader.load(menu.toURL());
        menuScene = new Scene(root);
        File menuStyle = new File("snakegame/src/main/resources/MenuStylesheet.css");

        menuScene.getStylesheets().add(String.valueOf(menuStyle.toURL()));
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