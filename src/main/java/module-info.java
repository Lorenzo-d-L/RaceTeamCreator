module com.lorenzo.raceteamcreator_bp02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.lorenzo.raceteamcreator_bp02 to javafx.fxml;
    exports com.lorenzo.raceteamcreator_bp02;
}