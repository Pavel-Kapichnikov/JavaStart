module com.example.javacalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javacalc to javafx.fxml;
    exports com.example.javacalc;
}