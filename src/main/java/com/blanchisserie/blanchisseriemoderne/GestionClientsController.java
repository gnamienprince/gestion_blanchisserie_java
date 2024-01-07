package com.blanchisserie.blanchisseriemoderne;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static com.blanchisserie.blanchisseriemoderne.SendMessage.sendMessage;


public class GestionClientsController {

    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;
    private Parent fxml;
    @FXML
    private AnchorPane root;


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
    void btnEnregistrer(MouseEvent event) {
        String nom = txtFieldNom.getText();
        String prenom = txtFieldPrenom.getText();
        String tel = txtFieldNumero.getText();
        String email = txtFieldEmail.getText();
        String localisation = txtFieldLocal.getText();

        //verification du numero et du mail si cela n'existe pas dans la base de donnée

        //verifier aussi si tout les champs ont été saisie

        if (nom.isEmpty() || prenom.isEmpty() || tel.isEmpty() || email.isEmpty() || localisation.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Veuillez renseigner tous les champs", ButtonType.OK);
            alert.showAndWait();
        }else{

            //generation de l'identifiant
            String idClient = nom.substring(0,3) + prenom.substring(0,3) + tel.substring(6);

            String sql = "select telClient, emailClient from client";
            try {
                st = cnx.prepareStatement(sql);
                result = st.executeQuery();
                if(result.next()){
                    if(tel.equals(result.getString("telClient"))){
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Ce numero existe dejà dans la base de donnée", ButtonType.OK);
                        alert.showAndWait();
                    }
                    if(email.equals(result.getString("emailClient"))){
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Cette adresse email existe dejà dans la base de donnée", ButtonType.OK);
                        alert.showAndWait();
                    }else if(!tel.equals(result.getString("telClient")) && !email.equals(result.getString("emailClient"))){

                        // les verifications ok on insere la nouvelle personne

                        String sql2 ="INSERT INTO client (idClient, nomClient, prenomClient, adresseClient, telClient, emailClient) VALUES (?, ?, ?, ?, ?, ?)";
                        try {
                            PreparedStatement st = cnx.prepareStatement(sql2);
                            st.setString(1, idClient);
                            st.setString(2, nom);
                            st.setString(3, prenom);
                            st.setString(4, localisation);
                            st.setString(5, tel);
                            st.setString(6, email);
                            int rowsInserted = st.executeUpdate();

                            if (rowsInserted > 0) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Le client a bien été enregistré avec succès !", ButtonType.OK);
                                alert.showAndWait();

                                //le fait de vider les champs apres avoir enregistrer un client

                                txtFieldNom.clear();
                                txtFieldPrenom.clear();
                                txtFieldNumero.clear();
                                txtFieldEmail.clear();
                                txtFieldLocal.clear();

                                //le message
                                String message = "Bonjour chere " + nom +" " + prenom + " votre compte a bien été crée chez Blanchisserie Moderne, votre identifiant est le suivant : " + idClient;

                                sendMessage(tel,message);

                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Echec d'enregistrement du client", ButtonType.OK);
                                alert.showAndWait();
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblGestion;

    @FXML
    private Button btnNewClient;

    @FXML
    private Button btnInfoClient;

    @FXML
    private Label lblNewClient;

    @FXML
    private TextField txtFieldNom;

    @FXML
    private TextField txtFieldPrenom;

    @FXML
    private TextField txtFieldNumero;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFieldLocal;

    @FXML
    private Button btnEnregistrer;

    @FXML
    private Button btnRetour;

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();

        assert lblGestion != null : "fx:id=\"lblGestion\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert btnInfoClient != null : "fx:id=\"btnInfoClient\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert lblNewClient != null : "fx:id=\"lblNewClient\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert txtFieldNom != null : "fx:id=\"txtFieldNom\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert txtFieldPrenom != null : "fx:id=\"txtFieldPrenom\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert txtFieldNumero != null : "fx:id=\"txtFieldNumero\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert txtFieldEmail != null : "fx:id=\"txtFieldEmail\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert txtFieldLocal != null : "fx:id=\"txtFieldLocal\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert btnEnregistrer != null : "fx:id=\"btnEnregistrer\" was not injected: check your FXML file 'GestionClients.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'GestionClients.fxml'.";

    }
}

