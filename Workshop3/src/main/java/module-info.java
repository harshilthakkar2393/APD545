module com.example.workshop3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workshop3 to javafx.fxml;
    exports com.example.workshop3;
}