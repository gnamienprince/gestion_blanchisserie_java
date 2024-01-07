package com.blanchisserie.blanchisseriemoderne;

import com.blanchisserie.blanchisseriemoderne.configuration.SharedId;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EspaceEmployeController implements Initializable{
    private Parent fxml;
    @FXML
    private Button btnTacheExecute;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnLivraison;

    @FXML
    private Button btnDeconnexion;

    @FXML
    private Label nonEmploye;

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

    }

    String idEmp;
    public void setIdEmploye(String idEmploye, String nomEmploye, String prenomEmploye,String adresseEmploye, String telEmploye, String salaireEmploye, String fonctionEmploye) {
        // Utilisez cet ID comme nécessaire dans votre contrôleur
        System.out.println("ID de l'employé : " + idEmploye);
        System.out.println("ID de l'employé : " + nomEmploye);
        System.out.println("ID de l'employé : " + prenomEmploye);
        System.out.println("ID de l'employé : " + adresseEmploye);
        System.out.println("ID de l'employé : " + telEmploye);
        System.out.println("ID de l'employé : " + salaireEmploye);
        System.out.println("ID de l'employé : " + fonctionEmploye);

        idEmp = idEmploye;
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void initialize() {
        assert btnTacheExecute != null : "fx:id=\"btnTacheExecute\" was not injected: check your FXML file 'EspaceEmploye.fxml'.";
        assert btnHistorique != null : "fx:id=\"btnHistorique\" was not injected: check your FXML file 'EspaceEmploye.fxml'.";
        assert btnLivraison != null : "fx:id=\"btnLivraison\" was not injected: check your FXML file 'EspaceEmploye.fxml'.";
        assert btnDeconnexion != null : "fx:id=\"btnDeconnexion\" was not injected: check your FXML file 'EspaceEmploye.fxml'.";
        assert nonEmploye != null : "fx:id=\"nonEmploye\" was not injected: check your FXML file 'EspaceEmploye.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'EspaceEmploye.fxml'.";

    }
}
