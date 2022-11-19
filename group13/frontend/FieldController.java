package group13.frontend;

import group13.Facade.Facade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    final static Facade FACADE = new Facade();
    @FXML
    private Group window;
    @FXML
    private Rectangle mouse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        drawFood();
    }

    public void drawFood(){
        int X = FACADE.getMouseRow();
        int Y = FACADE.getMouseColumn();
        mouse.setX(X);
        mouse.setY(Y);
    }
    public void startGame(){

    }

}