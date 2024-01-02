package com.blanchisserie.blanchisseriemoderne;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add( getClass().getResource( "application.css" ).toExternalForm() );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}