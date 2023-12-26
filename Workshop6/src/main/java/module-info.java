module com.example.workshop6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workshop6 to javafx.fxml;
    exports com.example.workshop6;
}