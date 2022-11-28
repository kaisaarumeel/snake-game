package group13.snakegame;

import group13.SnakeGameMain;
import group13.backend.Field;
import group13.frontend.GameLoop;
import group13.frontend.Renderer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class SnakeGame {
    private GraphicsContext context;
    private GameLoop loop;
    private Field field;

    private Canvas canvas;

    // Creates and returns a new scene
    public Scene getScene() throws Exception {
        Group root = new Group();
        canvas = new Canvas(700, 750);
        context = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        return new Scene(root);
    }

    // Resets the game, discards old Field and Loop, creates new ones, and renders changes
    private void reset() throws Exception {
        field = new Field();
        loop = new GameLoop(field, context);
        Renderer.render(field, context);
    }

    // Resets the game, starts event listener and starts the GameLoop
    public void startGame() throws Exception {
        this.reset();
        this.startEventListener();
        (new Thread(loop)).start();
    }

    // Starts the event listener for keyboard control -- NEEDS MORE RESEARCH AND POSSIBLY REFACTORING
    public void startEventListener() throws Exception {
        this.canvas.setFocusTraversable(true);
        this.canvas.setOnKeyPressed(this::handleEvent);
    }
    public void handleEvent(KeyEvent e) {
        if (loop.isKeyDown()) {
            return;
        }
        switch (e.getCode()) {
            case UP, W -> field.up();
            case DOWN, S -> field.down();
            case LEFT, A -> field.left();
            case RIGHT, D -> field.right();
            case ENTER -> {
                if (loop.isPaused()) {
                    try {
                        reset();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        this.startGame();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            case ESCAPE -> SnakeGameMain.showMenu();
        }
        loop.setKeyDown();
    }
}
