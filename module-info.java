module group13.snakegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens group13.snakegame to javafx.fxml;

    exports group13.snakegame;
}