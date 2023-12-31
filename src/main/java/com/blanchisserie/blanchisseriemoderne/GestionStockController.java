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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionStockController {

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
    private Button btnNiveauStock;

    @FXML
    private Button btnSaveArticle;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnRetour;

    @FXML
    private Button btnRetour1;

    @FXML
    private Button btnRetour11;

    @FXML
    private Button btnRetour111;

    @FXML
    void btnNiveauStock(MouseEvent event) {

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
    void btnSaveArticle(MouseEvent event) {
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
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert btnNiveauStock != null : "fx:id=\"btnNiveauStock\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert btnSaveArticle != null : "fx:id=\"btnSaveArticle\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert btnRetour1 != null : "fx:id=\"btnRetour1\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert btnRetour11 != null : "fx:id=\"btnRetour11\" was not injected: check your FXML file 'GestionStock.fxml'.";
        assert btnRetour111 != null : "fx:id=\"btnRetour111\" was not injected: check your FXML file 'GestionStock.fxml'.";

    }
}
