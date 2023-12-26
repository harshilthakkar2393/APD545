module com.example.workshop5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workshop5 to javafx.fxml;
    exports com.example.workshop5;
}