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
        renderText(gc);
    }

    private static void renderText(GraphicsContext gc) {
        //Game over text
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 37));
        gc.setFill(Color.BLUE);
        gc.fillText("GAME OVER", 220, 300);

        //Under that, press enter to play again text
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gc.setFill(Color.NAVY);
        gc.fillText("PRESS ENTER TO PLAY AGAIN", 180, 350);
    }


}
