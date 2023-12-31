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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;
    private Parent fxml;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView root;

    @FXML
    private Label labelGestion;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtMotDePasse;

    @FXML
    private CheckBox checkChoix;

    @FXML
    private Button btnConnexion;

    @FXML
    private Label labelNomUser;

    @FXML
    private Label labelMdp;



    @FXML
    void btnConnexion(MouseEvent event) {

        String user = txtNom.getText();
        String pass = txtMotDePasse.getText();
        boolean choix = checkChoix.isSelected();
        //System.out.println(choix);
        if (!choix){
            // la connexion des admininstrateurs
            String sql = "select nomAdmin, motdepasseAdmin from admin";
            try {
                st = cnx.prepareStatement(sql);
                result = st.executeQuery();
                if(result.next()){
                    if(user.equals(result.getString("nomAdmin")) && pass.equals(result.getString("motdepasseAdmin"))){
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
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Nom d'utilisateur ou mot de passe incorect", ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            //la connexion des employés
            String sql = "select nomEmploye, motDePasseEmploye from employe";
            try {
                st = cnx.prepareStatement(sql);
                result = st.executeQuery();
                if(result.next()){
                    if(user.equals(result.getString("nomEmploye")) && pass.equals(result.getString("motDePasseEmploye"))){
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
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Nom d'utilisateur ou mot de passe incorect", ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'Login.fxml'.";
        assert labelGestion != null : "fx:id=\"labelGestion\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtNom != null : "fx:id=\"txtNom\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtMotDePasse != null : "fx:id=\"txtMotDePasse\" was not injected: check your FXML file 'Login.fxml'.";
        assert checkChoix != null : "fx:id=\"checkChoix\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnConnexion != null : "fx:id=\"btnConnexion\" was not injected: check your FXML file 'Login.fxml'.";
        assert labelNomUser != null : "fx:id=\"labelNomUser\" was not injected: check your FXML file 'Login.fxml'.";
        assert labelMdp != null : "fx:id=\"labelMdp\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
