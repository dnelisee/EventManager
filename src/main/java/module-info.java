module com.polytechnique.finaltppoo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;
    requires com.fasterxml.jackson.databind;

    opens com.polytechnique.finaltppoo2 to javafx.fxml;
    exports com.polytechnique.finaltppoo2;

    opens com.polytechnique.finaltppoo2.model to com.fasterxml.jackson.databind; 
    exports com.polytechnique.finaltppoo2.model;
}