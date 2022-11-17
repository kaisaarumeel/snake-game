package group13.backend;

import java.util.Random;

public class testingField {
    private static final Integer ROWS =  17;
    private static final Integer COLS = 17;
    private Mouse mouse;

    public testingField(){
        this.addFruit();
    }

    public void addFruit(){
        Random random = new Random();
        Mouse fruit = new Mouse(2, 3);
    }

}
