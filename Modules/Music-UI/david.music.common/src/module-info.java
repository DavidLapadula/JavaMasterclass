module david.music.common {
    requires javafx.base;

    opens david.music.common to javafx.base;
    exports david.music.common;
}