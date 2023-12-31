package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    private Parent fxml;
    @FXML
    private AnchorPane root;

    @FXML

    //ouverture de la fenetre de gestion des clients

    void gestionClient(MouseEvent event) {
       root.getScene().getWindow().hide();
       Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("GestionClients.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    //ouverture de la fenetre de gestion des commandes
    @FXML
    void gestionCommande(MouseEvent event) {
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
    void gestionEmploye(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("GestionEmploye.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void gestionFacturation(MouseEvent event) {

    }

    @FXML
    void gestionPlanification(MouseEvent event) {

    }

    @FXML
    void gestionStock(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("GestionStock.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void statistiques(MouseEvent event) {

    }

    @FXML
    void articlesClient(MouseEvent event) {
        //root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("ArticleClient.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private ImageView btnAricleClient;

    @FXML
    private ImageView btnStatisqtique;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView btnClient;

    @FXML
    private ImageView btnStock;

    @FXML
    private ImageView btnCommande;

    @FXML
    private ImageView btnfacture;

    @FXML
    private ImageView btnEmployes;

    @FXML
    private ImageView btnPlanification;


    @FXML
    void initialize() {
        assert btnClient != null : "fx:id=\"btnClient\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnStock != null : "fx:id=\"btnStock\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnCommande != null : "fx:id=\"btnCommande\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnfacture != null : "fx:id=\"btnfacture\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnEmployes != null : "fx:id=\"btnEmployes\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnPlanification != null : "fx:id=\"btnPlanification\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnAricleClient != null : "fx:id=\"btnAricleClient\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
        assert btnStatisqtique != null : "fx:id=\"btnStatisqtique\" was not injected: check your FXML file 'MenuGeneral.fxml'.";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
