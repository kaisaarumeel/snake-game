package group13.frontend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import group13.SnakeGameMain;
import group13.backend.Field;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    // value determining the number of updates per second (UPS)
    public static final int SPEED = 10;
    private final SnakeGame game;
    private final Field field;
    private final GraphicsContext context;
    // Time it should take to update and render if we want to have SPEED number of UPS
    private final double optimalUpdateTime;
    private boolean paused;
    private boolean keyDown;

    public GameLoop(SnakeGame game, Field field, GraphicsContext context) {
        this.game = game;
        this.field = field;
        this.context = context;
        this.optimalUpdateTime = (double) 1000 / SPEED;
        this.paused = false;
        this.keyDown = false;
    }

    @Override
    public void run() {
        while(!paused) {
            // Check the current time when starting the loop
            double timeAtStart = System.currentTimeMillis();

            // Check if the loop should be interrupted because the player died
            if (this.field.gameOver()) {
                paused = true;
                //if the game is over, it will pop up game over text
                // GameOverController.GameOver(field, context);

                // Need this so we can change the scene -- Is there a better solution?
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SnakeGameMain.stage.setScene(GameOverController.getScene(field, game));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                // Saves current player score
                game.getScoreHandler().addNewScore("Janos", field.getTotalScore());


                // This is only for testing, prints top 5 scores in json format to console
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    System.out.println(objectMapper.writeValueAsString(game.getScoreHandler().getHighScoreList(5)));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            // Update field
            field.update();
            // Render changes
            try {
                Renderer.render(field, context);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // Check how long it took to update
            // The time it actually took for the loop to update and render
            double updateTime = System.currentTimeMillis() - timeAtStart;
            // If it took less time than the optimal update time, check the difference, and wait for that amount of time
            long waitTime = (long) (optimalUpdateTime - updateTime);
            if (updateTime < optimalUpdateTime) {
                try {
                    Thread.sleep(waitTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            keyDown = false;
        }
    }

    public boolean isPaused(){
        return this.paused;
    }
    public void setPaused(boolean value) {
        this.paused = value;
    }

    public boolean isKeyDown() {
        return keyDown;
    }

    public void setKeyDown() {
        if (!this.isPaused()) {
            keyDown = true;
        }
    }

}
