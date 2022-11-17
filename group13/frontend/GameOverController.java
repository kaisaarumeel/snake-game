package group13.frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameOverController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
