package group13.Facade;

import group13.backend.testingField;

public class Facade {
    private testingField field;

    public Facade(){
        newField();
    }

    public void newField(){
        field= new testingField();
    }
}

