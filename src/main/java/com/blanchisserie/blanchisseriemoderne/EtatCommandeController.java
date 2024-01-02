package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.blanchisserie.modele.Client;
import com.blanchisserie.modele.Commande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EtatCommandeController {
    Connection cnx;

    public PreparedStatement st;
    public ResultSet result;

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
    private TableView<Commande> tableauCommande;

    @FXML
    private TableColumn<Commande, String> cellReference;

    @FXML
    private TableColumn<Commande, String> cellNom;

    @FXML
    private TableColumn<Commande, String> cellPrenom;

    @FXML
    private TableColumn<Commande, String> cellDate;

    @FXML
    private TableColumn<Commande, String> cellStatuts;

    @FXML
    void btnEtatCommande(MouseEvent event) {

    }

    @FXML
    void btnNewCommande(MouseEvent event) {
        //root.getScene().getWindow().hide();
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

    public ObservableList<Commande> data = FXCollections.observableArrayList();

    public void tableauCommande(){
        String sql = "select * from commande, client where client = idClient";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()){
                data.add(new Commande(result.getString("idCommande"),result.getString("nomClient"),result.getString("prenomClient"),result.getString("dateCommande"), result.getString("statutCommande")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        cellReference.setCellValueFactory(new PropertyValueFactory<Commande, String>("idCommande"));
        cellNom.setCellValueFactory(new PropertyValueFactory<Commande, String>("nomClient"));
        cellPrenom.setCellValueFactory(new PropertyValueFactory<Commande, String>("prenomClient"));
        cellDate.setCellValueFactory(new PropertyValueFactory<Commande, String>("dateCommande"));
        cellStatuts.setCellValueFactory(new PropertyValueFactory<Commande, String>("statutCommande"));
        tableauCommande.setItems(data);
    }

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();
        tableauCommande();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert tableauCommande != null : "fx:id=\"tableauCommande\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnEtatCommande != null : "fx:id=\"btnEtatCommande\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert cellReference != null : "fx:id=\"cellReference\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert cellNom != null : "fx:id=\"cellNom\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert cellPrenom != null : "fx:id=\"cellPrenom\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert cellDate != null : "fx:id=\"cellDate\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert cellStatuts != null : "fx:id=\"cellStatuts\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert textfileldRechercher != null : "fx:id=\"textfileldRechercher\" was not injected: check your FXML file 'EtatCommande.fxml'.";
        assert btnRechercher != null : "fx:id=\"btnRechercher\" was not injected: check your FXML file 'EtatCommande.fxml'.";
    }
}
