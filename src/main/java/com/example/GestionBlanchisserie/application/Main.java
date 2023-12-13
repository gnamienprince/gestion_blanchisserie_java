package com.example.GestionBlanchisserie.application;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml")); // Remplacez "votre_fichier.fxml" par le nom de votre fichier FXML

		primaryStage.setTitle("Application JavaFX");
		primaryStage.setScene(new Scene(root, 800, 600)); // Modifiez la taille de la fenêtre selon vos besoins
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

