module org.example.cab302studymate {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.xml.crypto;

    opens org.example.cab302studymate to javafx.fxml;
    exports org.example.cab302studymate;
    exports org.example.cab302studymate.controller;
    opens org.example.cab302studymate.controller to javafx.fxml;
}