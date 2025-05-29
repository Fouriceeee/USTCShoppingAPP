module org.example.ustcshoppingapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.ustcshoppingapp to javafx.fxml;
    exports org.example.ustcshoppingapp;
}