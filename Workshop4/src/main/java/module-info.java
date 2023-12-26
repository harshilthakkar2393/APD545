module com.example.workshop4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workshop4 to javafx.fxml;
    exports com.example.workshop4;
}