package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AttribTacheController {
    Connection cnx;
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
    private Button btnNewEmploye;

    @FXML
    private Button btnListeEmploye;

    @FXML
    private Button btnAttribTache;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnRetour;

    @FXML
    private TextField textfileldRechercheEmp;

    @FXML
    private Button btnARechercher;

    @FXML
    private TextField textfileldNomEmp;

    @FXML
    private Label lblRechercher;

    @FXML
    private TextField textfileldPrenomEmp;

    @FXML
    private Label lblRechercher1;

    @FXML
    private TextField textfileldFonctionEmp;

    @FXML
    private Label lblRechercher12;

    @FXML
    private Pane paneTache;

    @FXML
    private TextField textFieldRef;

    @FXML
    private TextField textFielDateCommande;

    @FXML
    private TextField textFieldStatut;

    @FXML
    private Label lblRechercher21;

    @FXML
    private Label lblRechercher211;

    @FXML
    private TextArea TextAreaDescription;

    @FXML
    private Button btnAttribuerTache;

    @FXML
    private ListView<?> textFieldRefCommande;

    //fonction de renseignement du nom et prenom de l'employé
    public void initInfo(String nom, String prenom, String fonction) {
        textfileldNomEmp.setText(nom);
        textfileldPrenomEmp.setText(prenom);
        textfileldFonctionEmp.setText(fonction);
    }

    @FXML
    void btnAttribuerTache(MouseEvent event) {

    }

    @FXML
    void btnRechercherEmp(MouseEvent event) {
        String idEmploye = textfileldRechercheEmp.getText();
        if(idEmploye.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Veuillez renseigner l'identifiant de l'employé", ButtonType.OK);
            alert.showAndWait();
        }else{
            String sql = "select * from employe where idEmploye = ?";

            PreparedStatement pstmt = null;
            try {
                pstmt = cnx.prepareStatement(sql);
                pstmt.setString(1, idEmploye);

                ResultSet rs = pstmt.executeQuery();

                if(rs.next()) {

                    //ici on recupère les données de l'employé pour l'afficher dans un textfield

                    String nom = rs.getString("nomEmploye");
                    String prenom = rs.getString("prenomEmploye");
                    String fonction = rs.getString("fonctionEmploye");

                    //on affiche dans la console pour voir un peu

                    System.out.println("Nom : " + nom);
                    System.out.println("Prénom : " + prenom);
                    System.out.println("Fonction : " + fonction);

                    //appel de la fonction renseignement
                    initInfo(nom,prenom,fonction);


                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Cet identifiant n'existe pas dans la base de donnée", ButtonType.OK);
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnEtatCommande(MouseEvent event) {

    }

    @FXML
    void btnListeEmploye(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("ListeEmploye.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnNewEmploye(MouseEvent event) {
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
                cnx = ConnexionMySQL.ConnexionDB();
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert btnNewEmploye != null : "fx:id=\"btnNewEmploye\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert btnListeEmploye != null : "fx:id=\"btnListeEmploye\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert btnAttribTache != null : "fx:id=\"btnAttribTache\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textfileldRechercheEmp != null : "fx:id=\"textfileldRechercheEmp\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert btnARechercher != null : "fx:id=\"btnARechercher\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textfileldNomEmp != null : "fx:id=\"textfileldNomEmp\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblRechercher != null : "fx:id=\"lblRechercher\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textfileldPrenomEmp != null : "fx:id=\"textfileldPrenomEmp\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblRechercher1 != null : "fx:id=\"lblRechercher1\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textfileldFonctionEmp != null : "fx:id=\"textfileldFonctionEmp\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblRechercher12 != null : "fx:id=\"lblRechercher12\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert paneTache != null : "fx:id=\"paneTache\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textFieldRef != null : "fx:id=\"textFieldRef\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textFielDateCommande != null : "fx:id=\"textFielDateCommande\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textFieldStatut != null : "fx:id=\"textFieldStatut\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblRechercher21 != null : "fx:id=\"lblRechercher21\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert lblRechercher211 != null : "fx:id=\"lblRechercher211\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert TextAreaDescription != null : "fx:id=\"TextAreaDescription\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert btnAttribuerTache != null : "fx:id=\"btnAttribuerTache\" was not injected: check your FXML file 'AttribTache.fxml'.";
        assert textFieldRefCommande != null : "fx:id=\"textFieldRefCommande\" was not injected: check your FXML file 'AttribTache.fxml'.";

    }
}
