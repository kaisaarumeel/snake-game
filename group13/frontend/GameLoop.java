package group13.frontend;

import group13.backend.Field;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    public static final int SPEED = 10;
    private Field field;
    private GraphicsContext context;
    private double interval;
    private boolean running;
    private boolean paused;

    public GameLoop(Field field, GraphicsContext context) {
        this.field = field;
        this.context = context;
        interval = 1000 / SPEED;
        running = true;
        paused = false;
    }

    @Override
    public void run() {
        while(running && !paused && this.field.gameOver() == false) {
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
        }
    }

}
