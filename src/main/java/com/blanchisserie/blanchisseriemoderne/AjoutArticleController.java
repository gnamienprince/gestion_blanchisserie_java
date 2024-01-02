package com.blanchisserie.blanchisseriemoderne;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.blanchisserie.blanchisseriemoderne.configuration.ComboBoxDataLoader;
import com.blanchisserie.modele.Vetement;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AjoutArticleController {
    Connection cnx;
    private List<Vetement> listeVetement = new ArrayList<>();

    public ResultSet result;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblInfo;

    @FXML
    private TextField couleur;

    @FXML
    private TextField marque;

    @FXML
    private TextField qualite;

    @FXML
    private CheckBox choixLaver;

    @FXML
    private CheckBox choixRepasser;

    @FXML
    private ComboBox<String> cmbChoix;


    @FXML
    void btnAjouter(MouseEvent event) {

        //recuperation des données saisie dans les formulaires (combobox)
        String choixArticle = cmbChoix.getValue();
        String couleurArticle = couleur.getText();
        String marqueArticle = marque.getText();
        String qualiteArticle = qualite.getText();
        // 1 pour laver 2 pour repasser et 3 pour les 2
        boolean choixL = choixLaver.isSelected();
        boolean choixR = choixRepasser.isSelected();
        int service = 0;
        if(choixL && !choixR){
            service = 1;
        } else if (!choixL && choixR) {
            service = 2;
        } else if (choixL && choixR) {
            service = 3;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Veuillez choisir un service", ButtonType.OK);
            alert.showAndWait();
        }



        //id de l'article
        int id = 0;

        //recuperation de l'id qui es rélié a l'article selectionner
        String sql ="select idArticle from article where libelleArticle = ?";

        try {

            PreparedStatement pstmt = cnx.prepareStatement(sql);
            pstmt.setString(1, choixArticle); // Remplacement du paramètre avec la valeur spécifique

            // Exécution de la requête
            ResultSet rs = pstmt.executeQuery();

            // Récupération de l'ID si un résultat est trouvé
            if (rs.next()) {
                id = rs.getInt("idArticle");
            }
            
            System.out.println(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(choixArticle);

        if(id == 0 && couleurArticle.isEmpty() && marqueArticle.isEmpty() && qualiteArticle.isEmpty() && choixArticle.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Veuillez renseigner tout les champs", ButtonType.OK);
            alert.showAndWait();
        }else{
            //objet pour les elements de l'article
            Vetement vetement = new Vetement(couleurArticle,marqueArticle,qualiteArticle,service);
            listeVetement.add(vetement);

            //le nombre de donné enregistrer dans une liste
            int nombre = listeVetement.size();

            Alert alert = new Alert(Alert.AlertType.ERROR,"Vêtement enregistrer, vous pouvez enregistrer d'autres", ButtonType.OK);
            alert.showAndWait();

            //effacer les champs
            couleur.clear();
            marque.clear();
            qualite.clear();

            //juste des tests pour voir apparaitre les données entrées

            for (Vetement donnees : listeVetement) {
                System.out.println(donnees.getCouleurVetement());
                System.out.println(donnees.getMarqueVetement());
                System.out.println(donnees.getQualiteVetement());
                System.out.println(donnees.getServiceVetement());

                System.out.println("---------------");
            }

            System.out.println(nombre);


        }

    }

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();
        ComboBoxDataLoader dataLoader = new ComboBoxDataLoader();
        dataLoader.loadDataToComboBox(cmbChoix);
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AjoutArticle.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'AjoutArticle.fxml'.";
        assert couleur != null : "fx:id=\"couleur\" was not injected: check your FXML file 'AjoutArticle.fxml'.";
        assert marque != null : "fx:id=\"marque\" was not injected: check your FXML file 'AjoutArticle.fxml'.";
        assert qualite != null : "fx:id=\"qualite\" was not injected: check your FXML file 'AjoutArticle.fxml'.";
        assert choixLaver != null : "fx:id=\"choixLaver\" was not injected: check your FXML file 'AjoutArticle.fxml'.";
        assert choixRepasser != null : "fx:id=\"choixRepasser\" was not injected: check your FXML file 'AjoutArticle.fxml'.";

    }
}
