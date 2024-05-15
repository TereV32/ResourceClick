module com.example.resourceclick {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.resourceclick to javafx.fxml;
    exports com.example.resourceclick;
}