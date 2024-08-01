module com.example.usuariosappmvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.usuariosappmvc to javafx.fxml;
    exports com.example.usuariosappmvc;
}