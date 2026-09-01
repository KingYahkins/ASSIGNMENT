module org.yltech.logindb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens org.yltech.logindb to javafx.fxml;
    opens org.yltech.logindb.models to javafx.base;

    exports org.yltech.logindb;
}