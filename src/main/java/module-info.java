module com.polytechnique.finaltppoo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;

    opens com.polytechnique.finaltppoo2 to javafx.fxml;
    exports com.polytechnique.finaltppoo2;
}