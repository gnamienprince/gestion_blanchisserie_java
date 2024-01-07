package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LivraisonEmployeController {
    private Parent fxml;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnTacheExecute;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnLivraison;

    @FXML
    private TableView<?> tableauCommande;

    @FXML
    private TableColumn<?, ?> cellReference;

    @FXML
    private TableColumn<?, ?> cellDescription;

    @FXML
    private TableColumn<?, ?> cellDateCommande;

    @FXML
    private TableColumn<?, ?> cellMarquer;

    @FXML
    private Button btnRetour;

    @FXML
    private AnchorPane root;

    @FXML
    void btnDeconnexion(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnHistorique(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("HistoriqueTacheEmploye.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnLivraison(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("LivraisonEmploye.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnTacheExecute(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("TacheEmploye.fxml"));
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
            fxml = FXMLLoader.load(getClass().getResource("EspaceEmploye.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert btnTacheExecute != null : "fx:id=\"btnTacheExecute\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert btnHistorique != null : "fx:id=\"btnHistorique\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert btnLivraison != null : "fx:id=\"btnLivraison\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert tableauCommande != null : "fx:id=\"tableauCommande\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert cellReference != null : "fx:id=\"cellReference\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert cellDescription != null : "fx:id=\"cellDescription\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert cellDateCommande != null : "fx:id=\"cellDateCommande\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert cellMarquer != null : "fx:id=\"cellMarquer\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'LivraisonEmploye.fxml'.";

    }
}
