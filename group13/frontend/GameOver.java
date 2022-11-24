package group13.frontend;

import group13.backend.Field;
import group13.backend.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameOver {

    public static void GameOver(Field field, GraphicsContext gc){
        renderText(field,gc);
    }

    private static void renderText(Field field, GraphicsContext gc) {
        //Backround
        gc.setFill(Color.POWDERBLUE);
        gc.fillRoundRect(150, 200,400,190, 110, 120);

        //Game over text
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 37));
        gc.setFill(Color.DARKBLUE);
        gc.fillText("GAME OVER!", 220, 300);

        //Score text
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        gc.setFill(Color.CADETBLUE);
        gc.fillText("SCORE: " + field.getTotalScore(), 280, 245);

        //Under that, press enter to play again text
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gc.setFill(Color.CADETBLUE);
        gc.fillText("PRESS ENTER TO PLAY AGAIN", 180, 350);
    }


}
