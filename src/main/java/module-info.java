module com.blanchisserie.blanchisseriemoderne {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires mysql.connector.j;
    requires java.sql;
    requires okhttp3;

    opens com.blanchisserie.blanchisseriemoderne to javafx.fxml;
    exports com.blanchisserie.blanchisseriemoderne;

    exports com.blanchisserie.modele;
    opens com.blanchisserie.modele;

}