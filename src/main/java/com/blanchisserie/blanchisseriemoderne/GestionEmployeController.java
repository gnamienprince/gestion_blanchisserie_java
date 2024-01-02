package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionEmployeController {
    Connection cnx;
    private Parent fxml;

    public PreparedStatement st;
    public ResultSet result;

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
    private Label lblRechercher;

    @FXML
    private Button btnRetour;

    @FXML
    private TextField textfileldNomEmp;

    @FXML
    private Button btnAjouterEmp;

    @FXML
    private Label lblRechercher1;

    @FXML
    private Label lblRechercher11;

    @FXML
    private TextField textfileldPrenomEmp;

    @FXML
    private Label lblRechercher2;

    @FXML
    private Label lblRechercher111;

    @FXML
    private Label lblRechercher21;

    @FXML
    private Label lblRechercher1111;

    @FXML
    private Label lblRechercher211;

    @FXML
    private TextField textfileldTelEmp;

    @FXML
    private TextField textfileldEmailEmp;

    @FXML
    private TextField textfileldFonctEmp;


    @FXML
    private DatePicker textfileldDateEmbEmp;


    @FXML
    private TextField textfileldSalaireEmp;

    @FXML
    private TextField textfileldAdresseEmp;

    @FXML
    void btnEnregistrerEmp(MouseEvent event) {
        //enregistrer un employé
        String nom = textfileldNomEmp.getText();
        String prenom = textfileldPrenomEmp.getText();
        String numero = textfileldTelEmp.getText();
        String email = textfileldEmailEmp.getText();
        String fonction = textfileldFonctEmp.getText();
        LocalDate dateEmbauche = textfileldDateEmbEmp.getValue();
        String salaire = textfileldSalaireEmp.getText();
        String adresse = textfileldAdresseEmp.getText();

        //System.out.println(dateEmbauche);

        if(nom.isEmpty() && prenom.isEmpty() && numero.isEmpty() && email.isEmpty() && fonction.isEmpty() && dateEmbauche == null && salaire.isEmpty() && adresse.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez renseigner tout les champs", ButtonType.OK);
            alert.showAndWait();
        }else {
            int salaireInt = Integer.parseInt(salaire);

            //generation de l'id
            String idEmploye = nom.substring(0,3) + prenom.substring(0,3) + numero.substring(6);

            //hasher un mot de passe
            //String motDePasse = BCrypt.hashpw(idEmploye, BCrypt.gensalt());
            // insertion dans la base de donnée

            //pour l'instant le mot de passe c'est l'id employé
            //a changé avec le code hasher

            String sql ="INSERT INTO employe (idEmploye, nomEmploye, prenomEmploye, adresseEmploye, telEmploye, dateEmbEmploye, salaireEmploye, motDePasseEmploye, fonctionEmploye) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setString(1, idEmploye);
                st.setString(2, nom);
                st.setString(3, prenom);
                st.setString(4, adresse);
                st.setString(5, numero);
                st.setDate(6, Date.valueOf(dateEmbauche));
                st.setInt(7, salaireInt);
                st.setString(8, idEmploye);
                st.setString(9, fonction);
                int rowsInserted = st.executeUpdate();

                if (rowsInserted > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"Enregistrement de l'employé effectué", ButtonType.OK);
                    alert.showAndWait();

                    textfileldNomEmp.clear();
                    textfileldPrenomEmp.clear();
                    textfileldTelEmp.clear();
                    textfileldEmailEmp.clear();
                    textfileldFonctEmp.clear();
                    textfileldSalaireEmp.clear();
                    textfileldAdresseEmp.clear();


                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Echec de l'enregistrement", ButtonType.OK);
                    alert.showAndWait();
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

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
    void btnNewEmploye(MouseEvent event) {

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
    void btnAttribTache(MouseEvent event) {
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("AttribTache.fxml"));
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

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert btnNewEmploye != null : "fx:id=\"btnNewEmploye\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert btnListeEmploye != null : "fx:id=\"btnListeEmploye\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert btnAttribTache != null : "fx:id=\"btnAttribTache\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher != null : "fx:id=\"lblRechercher\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldNomEmp != null : "fx:id=\"textfileldNomEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert btnAjouterEmp != null : "fx:id=\"btnAjouterEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher1 != null : "fx:id=\"lblRechercher1\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher11 != null : "fx:id=\"lblRechercher11\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldPrenomEmp != null : "fx:id=\"textfileldPrenomEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher2 != null : "fx:id=\"lblRechercher2\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher111 != null : "fx:id=\"lblRechercher111\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher21 != null : "fx:id=\"lblRechercher21\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher1111 != null : "fx:id=\"lblRechercher1111\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert lblRechercher211 != null : "fx:id=\"lblRechercher211\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldTelEmp != null : "fx:id=\"textfileldTelEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldEmailEmp != null : "fx:id=\"textfileldEmailEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldFonctEmp != null : "fx:id=\"textfileldFonctEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldDateEmbEmp != null : "fx:id=\"textfileldDateEmbEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldSalaireEmp != null : "fx:id=\"textfileldSalaireEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";
        assert textfileldAdresseEmp != null : "fx:id=\"textfileldAdresseEmp\" was not injected: check your FXML file 'GestionEmploye.fxml'.";

    }
}
