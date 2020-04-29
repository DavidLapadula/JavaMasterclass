module david.music.ui {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    requires david.music.db;

    exports david.music.ui to javafx.graphics;
    opens david.music.ui to javafx.fxml;
}