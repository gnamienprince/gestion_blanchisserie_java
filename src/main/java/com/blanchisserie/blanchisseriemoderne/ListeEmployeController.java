package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.blanchisserie.modele.Client;
import com.blanchisserie.modele.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListeEmployeController {
    private Parent fxml;
    Connection cnx;
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
    private Button btnRetour;

    @FXML
    private TableView<Employe> tableauListe;

    @FXML
    private TableColumn<Employe, String> cellId;

    @FXML
    private TableColumn<Employe, String> cellNom;

    @FXML
    private TableColumn<Employe, String> cellPrenom;

    @FXML
    private TableColumn<Employe, String> cellTel;

    @FXML
    private TableColumn<Employe, String> cellFoncton;


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
    void btnListeEmploye(MouseEvent event) {

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

    public ObservableList<Employe> data = FXCollections.observableArrayList();
    public void tableauEmploye(){
        String sql = "select * from employe";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()){
                data.add(new Employe(result.getString("idEmploye"),result.getString("nomEmploye"),result.getString("prenomEmploye"),result.getString("telEmploye"), result.getString("FonctionEmploye")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        cellId.setCellValueFactory(new PropertyValueFactory<Employe, String>("idEmploye"));
        cellNom.setCellValueFactory(new PropertyValueFactory<Employe, String>("nomEmploye"));
        cellPrenom.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenomEmploye"));
        cellTel.setCellValueFactory(new PropertyValueFactory<Employe, String>("telEmploye"));
        cellFoncton.setCellValueFactory(new PropertyValueFactory<Employe, String>("fonctionEmploye"));

        tableauListe.setItems(data);
    }

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();
        tableauEmploye();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert btnNewEmploye != null : "fx:id=\"btnNewEmploye\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert btnListeEmploye != null : "fx:id=\"btnListeEmploye\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert btnAttribTache != null : "fx:id=\"btnAttribTache\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert tableauListe != null : "fx:id=\"tableauListe\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert cellId != null : "fx:id=\"cellId\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert cellNom != null : "fx:id=\"cellNom\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert cellPrenom != null : "fx:id=\"cellPrenom\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert cellTel != null : "fx:id=\"cellTel\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
        assert cellFoncton != null : "fx:id=\"cellFoncton\" was not injected: check your FXML file 'ListeEmploye.fxml'.";
    }
}
