module com.example.lab07 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab7 to javafx.fxml;
    exports lab7;
}