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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionCommandeController {
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
    private Button btnAjouterCommande;

    @FXML
    private ListView<?> listViewIDClient;

    @FXML
    private Label lblRechercher1;

    @FXML
    private TextArea textfileldDescription;

    @FXML
    private Label lblRechercher11;

    @FXML
    private Label lblRechercher1211;

    @FXML
    private TextField textfileldTotal;


    @FXML
    private Label valChemise;


    @FXML
    private Label prixChemise;


    @FXML
    private Label valPantalon;

    @FXML
    private Label valRobe;




    @FXML
    private Label valjupe;



    @FXML
    private Label prixPantalon;

    @FXML
    private Label prixRobe;

    @FXML
    private Label prixJupe;

    @FXML
    void ajouterChemise(MouseEvent event) {

    }

    @FXML
    void ajouterJupe(MouseEvent event) {

    }

    @FXML
    void ajouterPantalon(MouseEvent event) {

    }

    @FXML
    void ajouterRobe(MouseEvent event) {

    }

    @FXML
    void btnAjouterCommande(MouseEvent event) {

    }

    @FXML
    void btnEtatCommande(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("EtatCommande.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnNewCommande(MouseEvent event) {

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
    void reduireChemise(MouseEvent event) {

    }

    @FXML
    void reduireJupe(MouseEvent event) {

    }

    @FXML
    void reduirePantalon(MouseEvent event) {

    }

    @FXML
    void reduireRobe(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnEtatCommande != null : "fx:id=\"btnEtatCommande\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnAjouterCommande != null : "fx:id=\"btnAjouterCommande\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert listViewIDClient != null : "fx:id=\"listViewIDClient\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblRechercher1 != null : "fx:id=\"lblRechercher1\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert textfileldDescription != null : "fx:id=\"textfileldDescription\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblRechercher11 != null : "fx:id=\"lblRechercher11\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblRechercher1211 != null : "fx:id=\"lblRechercher1211\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert textfileldTotal != null : "fx:id=\"textfileldTotal\" was not injected: check your FXML file 'GestionCommande.fxml'.";

        assert valChemise != null : "fx:id=\"valChemise\" was not injected: check your FXML file 'GestionCommande.fxml'.";

        assert prixChemise != null : "fx:id=\"prixChemise\" was not injected: check your FXML file 'GestionCommande.fxml'.";

        assert valPantalon != null : "fx:id=\"valPantalon\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert valRobe != null : "fx:id=\"valRobe\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert valjupe != null : "fx:id=\"valjupe\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert prixPantalon != null : "fx:id=\"prixPantalon\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert prixRobe != null : "fx:id=\"prixRobe\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert prixJupe != null : "fx:id=\"prixJupe\" was not injected: check your FXML file 'GestionCommande.fxml'.";

    }
}
