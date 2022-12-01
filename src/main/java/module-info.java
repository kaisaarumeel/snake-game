module group13 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens group13 to javafx.fxml;

    exports group13;
    exports group13.frontend;
}