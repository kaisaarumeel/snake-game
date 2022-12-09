module group13 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires javafx.media;


    opens group13 to javafx.fxml;
    opens group13.frontend to javafx.fxml;

    exports group13;
    exports group13.backend;
    exports group13.frontend;
}