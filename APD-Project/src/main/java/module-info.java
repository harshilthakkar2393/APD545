module com.example.apdproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.apdproject to javafx.fxml;
    exports com.example.apdproject;
}