package group13.frontend;

import group13.SnakeGameMain;
import group13.backend.Field;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {
    @FXML
    private Button replay;
    @FXML
    private Label enterName;
    @FXML
    private Label score;
    @FXML
    private TextField playerNameField;
    public static String lastPlayer;
    public static int scoreInt;
    public static SnakeGame game;
    public static GameLoop loop;

    public static Scene getScene(Field field, SnakeGame g) throws Exception {
        scoreInt = field.getTotalScore();
        game = g;
        loop = g.getLoop();
        lastPlayer = g.getScoreHandler().getLastPlayer();
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
        playerNameField.setText(lastPlayer);
        Platform.runLater(() -> playerNameField.requestFocus());
    }

    public void handleOnKeyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case ESCAPE -> SnakeGameMain.showMenu();
        }
    }

    @FXML
    private void handleMenuButtonPress() {
        SnakeGameMain.showMenu();
    }

    @FXML
    private void handleReplayButtonPress() {
        try {
            SnakeGameMain.stage.setScene(game.getScene());
            game.reset();
            game.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onTextFieldEnter(ActionEvent e){
        // Saves current player score
        game.getScoreHandler().addNewScore(playerNameField.getText(), scoreInt);
        enterName.setText("SAVED! PLAY AGAIN?");
        replay.requestFocus();
    }
}
