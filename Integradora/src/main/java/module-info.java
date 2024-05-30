module com.integradora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.integradora to javafx.fxml;
    exports com.integradora;
}