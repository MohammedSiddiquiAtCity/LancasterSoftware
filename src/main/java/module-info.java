/**
 * Required modules for LancasterSoftware to function.
 * */
module org.redsox.lancastersfx {
    requires java.sql;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;

    exports org.redsox.lancastersfx.GUI;
    opens org.redsox.lancastersfx.GUI to javafx.fxml;
}