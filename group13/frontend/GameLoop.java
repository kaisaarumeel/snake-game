package group13.frontend;

import group13.backend.Field;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    public static final int SPEED = 10;
    private final Field field;
    private final GraphicsContext context;
    private final double interval;
    private boolean paused;
    private boolean keyDown;

    public GameLoop(Field field, GraphicsContext context) {
        this.field = field;
        this.context = context;
        this.interval = 1000 / SPEED;
        this.paused = false;
        this.keyDown = false;
    }

    @Override
    public void run() {
        while(!paused) {
            if (this.field.gameOver()) {
                paused = true;
            }
            double time = System.currentTimeMillis();

            field.update();
            Painter.paint(field, context);

            time = System.currentTimeMillis() - time;

            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) {
                }
            }
            keyDown = false;
        }
    }

    public boolean isPaused(){
        return this.paused;
    }

    public boolean isKeyDown() {
        return keyDown;
    }

    public void setKeyDown() {
        keyDown = true;
    }

}
