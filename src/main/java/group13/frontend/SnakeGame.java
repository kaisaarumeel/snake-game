package group13.frontend;

import group13.Main;
import  group13.SnakeGameMain;
import group13.backend.Field;
import group13.backend.ScoreHandler;
import group13.frontend.GameLoop;
import group13.frontend.Renderer;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.FontWeight;


import javafx.scene.text.Font;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class SnakeGame {
    private GraphicsContext context;
    private  Font font;
    private GameLoop loop;
    private Field field;

    private Canvas canvas;
    private final ScoreHandler scoreHandler;

    public SnakeGame() throws IOException, FontFormatException {
        this.scoreHandler = new ScoreHandler();
        String fName = "/Pixeboy-z8XGD.ttf";
        InputStream is = Main.class.getResourceAsStream(fName);
        font = Font.loadFont(is,12);
    }

    // Creates and returns a new scene
    public Scene getScene() throws Exception {

        //Back to Menu button on the bottom of the screen
        Button backToMenu = new Button("Back to Menu");
        backToMenu.setTranslateX(550);
        backToMenu.setTranslateY(708);
        backToMenu.setFocusTraversable(false);
        backToMenu.setOnMousePressed(click -> {
            SnakeGameMain.showMenu();
        });

        Group root = new Group();

        canvas = new Canvas(700, 750);
        context = canvas.getGraphicsContext2D();
        context.setFont(font);
        root.getChildren().add(canvas);
        root.getChildren().add(backToMenu);

        Scene snakeGameScene = new Scene(root);

        // Set css file for the scene
        snakeGameScene.getStylesheets().add("SnakeGameStylesheet.css");

        return snakeGameScene;
    }

    // Resets the game, discards old Field and Loop, creates new ones, and renders changes
    public void reset() throws Exception {
        field = new Field();
        loop = new GameLoop(this, field, context);
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
            case ESCAPE -> {
                loop.setPaused(true);
                SnakeGameMain.showMenu();
            }
        }
        loop.setKeyDown();
    }

    public ScoreHandler getScoreHandler() {
        return this.scoreHandler;
    }

    public Field getField() {
        return field;
    }

    public GameLoop getLoop() {
        return loop;
    }


}
