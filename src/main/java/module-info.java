module com.polytechnique.finaltppoo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.polytechnique.finaltppoo2 to javafx.fxml;
    exports com.polytechnique.finaltppoo2;
}