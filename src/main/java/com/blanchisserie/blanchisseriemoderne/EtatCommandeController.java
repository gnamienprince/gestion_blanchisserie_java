package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EtatCommandeController {

    private Parent fxml;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblGestionClients;

    @FXML
    private Button btnNewClient;

    @FXML
    private Button btnEtatCommande;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnRetour;

    @FXML
    private TextField textfileldRechercher;

    @FXML
    private Button btnRechercher;

    @FXML
    void btnEtatCommande(MouseEvent event) {

    }

    @FXML
    void btnNewCommande(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("GestionCommande.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnRetour(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("MenuGeneral.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnEtatCommande != null : "fx:id=\"btnEtatCommande\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert textfileldRechercher != null : "fx:id=\"textfileldRechercher\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnRechercher != null : "fx:id=\"btnRechercher\" was not injected: check your FXML file 'EtatCommande.fxml'.";

    }
}
