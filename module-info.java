module group13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens group13 to javafx.fxml;

    exports group13;
    exports group13.frontend;
    opens group13.frontend to javafx.fxml;
}