package group13.frontend;

import group13.backend.Field;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    // value determining the number of updates per second (UPS)
    public static final int SPEED = 10;
    private final Field field;
    private final GraphicsContext context;
    // Time it should take to update and render if we want to have SPEED number of UPS
    private final double optimalUpdateTime;
    // The time it actually took for the loop to update and render
    private double updateTime;
    private boolean paused;
    private boolean keyDown;

    public GameLoop(Field field, GraphicsContext context) {
        this.field = field;
        this.context = context;
        this.optimalUpdateTime = 1000 / SPEED;
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
                GameOver.GameOver(field, context);
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
            updateTime = System.currentTimeMillis() - timeAtStart;
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
