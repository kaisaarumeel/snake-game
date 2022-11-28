package group13.frontend;

import group13.backend.Field;
import group13.backend.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;

public class GameOver {

    public static void GameOver(Field field, GraphicsContext gc){
        renderText(field,gc);
    }

    private static void renderText(Field field, GraphicsContext gc) {
        //Backround
        gc.setFill(Color.CORNSILK);
        gc.fillRoundRect(150, 200,400,190, 40, 50);

        //Game over text
        gc.setFont(Font.font("Impact", FontWeight.BOLD, 37));
        gc.setFill(Color.BLACK);
        gc.fillText("GAME OVER!", 255, 300);

        //Score text
        gc.setFont(Font.font("Impact", FontWeight.BOLD, 25));
        gc.setFill(Color.BLACK);
        gc.fillText("SCORE: " + field.getTotalScore(), 300, 245);

        //Under that, press enter to play again text
        gc.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        gc.setFill(Color.BLACK);
        gc.fillText("PRESS ENTER TO PLAY AGAIN", 240, 350);
    }


}
