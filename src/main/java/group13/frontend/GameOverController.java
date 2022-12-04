package group13.frontend;

import group13.SnakeGameMain;
import group13.backend.Field;
import group13.backend.ScoreHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {
    @FXML
    private Label score;
    public static int scoreInt;
    public static SnakeGame game;
    public static GameLoop loop;

    public static Scene getScene(Field field, SnakeGame g) throws Exception {
        scoreInt = field.getTotalScore();
        game = g;
        loop = g.getLoop();
        //Loading the fxml file that has the design of the scene
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HowToPlayController.class.getResource("/GameOver.fxml"));
        Parent root = loader.load();
        root.setFocusTraversable(true);
        return new Scene(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        score.setText("SCORE: " + scoreInt);

    }

    public void handleOnKeyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case ENTER -> {
                if (loop.isPaused()) {
                    try {
                        SnakeGameMain.stage.setScene(game.getScene());
                        game.reset();
                        game.startGame();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            case ESCAPE -> SnakeGameMain.showMenu();
        }
    }

    @FXML
    private void handleButtonPress() {
        SnakeGameMain.showMenu();
    }
}
