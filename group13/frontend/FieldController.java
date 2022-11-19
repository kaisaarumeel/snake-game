package group13.frontend;

import group13.Facade.Facade;
import group13.SnakeGameMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    final static Facade FACADE = new Facade();
    @FXML
    private AnchorPane window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //FACADE.newField();

       // startGame();
        //playgame
    }

  //  public void startGame(){

  //  }

}