package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;

import com.blanchisserie.modele.Client;
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

public class InformationClientController {
    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;
    private Parent fxml;
    @FXML
    private AnchorPane root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblGestionClients;

    @FXML
    private Button btnNewClient;

    @FXML
    private Button btnInfoClient;

    @FXML
    private Label lblInfo;

    @FXML
    private Label lblRechercher;

    @FXML
    private Button btnRetour;

    @FXML
    private TableView<Client> tableInfoClient;

    @FXML
    private TableColumn<Client, String> celNom;

    @FXML
    private TableColumn<Client, String> celPrenom;

    @FXML
    private TableColumn<Client, String> celEmail;

    @FXML
    private TableColumn<Client, String> celNumero;

    @FXML
    private TableColumn<Client, String> celAdresse;


    @FXML
    private TextField textfileldRechercher;

    @FXML
    private Button btnRechercher;

    @FXML
    void btnInfoClient(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("InformationClient.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnNewClient(MouseEvent event) {
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

    //btn de recherche de client
    @FXML
    void btnRechercher(MouseEvent event){
        //System.out.println("test");
        String nom = textfileldRechercher.getText();
        String sql = "select * from client where nomClient = ?";

        try {
            PreparedStatement st = cnx.prepareStatement(sql);

            // Définir la valeur pour le paramètre de la requête
            st.setString(1, nom);

            // Exécuter la requête de sélection
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                //afficher la liste des noms maintenant

                while (result.next()){
                    data.add(new Client(result.getString("nomClient"),result.getString("prenomClient"),result.getString("telClient"),result.getString("emailClient"), result.getString("adresseClient")));
                }
            }else {
                //si le nom mentionner n'existe pas dans la base de donnée
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ce nom d'existe pas dans la base de donnée", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        celNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nomClient"));
        celPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenomClient"));
        celEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("emailClient"));
        celNumero.setCellValueFactory(new PropertyValueFactory<Client, String>("telClient"));
        celAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresseClient"));

        tableInfoClient.setItems(data);
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


    public ObservableList<Client> data = FXCollections.observableArrayList();

    public void tableauClient(){
        String sql = "select * from client";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()){
                data.add(new Client(result.getString("nomClient"),result.getString("prenomClient"),result.getString("telClient"),result.getString("emailClient"), result.getString("adresseClient")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        celNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nomClient"));
        celPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenomClient"));
        celEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("emailClient"));
        celNumero.setCellValueFactory(new PropertyValueFactory<Client, String>("telClient"));
        celAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresseClient"));

        tableInfoClient.setItems(data);
    }

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();
        tableauClient();

        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert btnInfoClient != null : "fx:id=\"btnInfoClient\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert lblRechercher != null : "fx:id=\"lblRechercher\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert tableInfoClient != null : "fx:id=\"tableInfoClient\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert textfileldRechercher != null : "fx:id=\"textfileldRechercher\" was not injected: check your FXML file 'InformationClient.fxml'.";
        assert btnRechercher != null : "fx:id=\"btnRechercher\" was not injected: check your FXML file 'InformationClient.fxml'.";

    }
}
