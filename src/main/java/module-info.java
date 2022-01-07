module net.scriptsource.bmicalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens net.scriptsource.bmicalculator to javafx.fxml;
    exports net.scriptsource.bmicalculator;
    exports support_class;
    opens support_class to javafx.fxml;
}