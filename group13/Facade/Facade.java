package group13.Facade;

import group13.backend.Field;

public class Facade {
    private Field field;

    public Facade(){
        newField();
    }

    public void newField(){
        field = new Field();
    }

    public int getMouseRow() {
        return this.field.getMouseRow();
    }
    public int getMouseColumn() {
        return this.field.getMouseColumn();
    }
}

