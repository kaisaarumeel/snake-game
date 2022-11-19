package group13.frontend;

import group13.Facade.Facade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
        startGame();
    }

    public void drawFood(){
        int X = FACADE.getMouseRow();
        int Y = FACADE.getMouseColumn();
        mouse.setX(X);
        mouse.setY(Y);
    }

    public void drawSnake() {
        for (int i = FACADE.getSnakeLength() - 1; i >= 0; i--) {
            Integer[] snakeBodyPart = FACADE.getSnakeBodyPart(i);
            drawSnakeBodyPart(snakeBodyPart[0], snakeBodyPart[1]);
        }
    }

    public void drawSnakeBodyPart(int X, int Y) {
        System.out.println(X + Y);
        Rectangle snakeBodyPart = new Rectangle();
        snakeBodyPart.setFill(Color.GREEN);
        snakeBodyPart.setWidth(25);
        snakeBodyPart.setHeight(25);
        snakeBodyPart.setX(X * 25);
        snakeBodyPart.setY(Y * 25);
        window.getChildren().add(snakeBodyPart);
    }
    public void startGame(){
        while(true) {
            drawSnake();
            FACADE.moveSnake();
            try {
                Thread.sleep(500);
            } catch (Exception e ) {
                e.printStackTrace();
            }

        }

    }

}