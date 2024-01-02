package com.blanchisserie.blanchisseriemoderne;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ArticleClientController {
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
    private Label lblInfo;

    @FXML
    private Button btnAjouterArticleClient;

    @FXML
    private TextField textfileldLibelle;

    @FXML
    private Label lblRechercher1;

    @FXML
    private TextField txtfieldLaver;

    @FXML
    private TextField txtfieldRepasser;

    @FXML
    void btnAjouterArticleClient(MouseEvent event) {
        //enregistrement article des clients au prealable avec le prix du service
        String libelleArticle = textfileldLibelle.getText();
        String prixLaverStr = txtfieldLaver.getText();
        String prixRepasserStr = txtfieldRepasser.getText();

        //parser les prix en int
        int prixLaver = Integer.parseInt(prixLaverStr);
        int prixRepasser = Integer.parseInt(prixRepasserStr);

        //verifier si les contenus ne sont pas vident
        if (libelleArticle.isEmpty() || prixLaverStr.isEmpty() || prixRepasserStr.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Veuillez renseigner tous les champs", ButtonType.OK);
            alert.showAndWait();
        }else{
            String sql ="INSERT INTO article (libelleArticle , prixLaver, prixRepasser) VALUES (?, ?, ?)";
            try {
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setString(1, libelleArticle);
                st.setInt(2, prixLaver);
                st.setInt(3, prixRepasser);
                int rowsInserted = st.executeUpdate();

                if (rowsInserted > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"L'article a bien été enregistré avec succès !", ButtonType.OK);
                    alert.showAndWait();

                    //le fait de vider les champs apres avoir enregistrer un client

                    textfileldLibelle.clear();
                    txtfieldLaver.clear();
                    txtfieldRepasser.clear();

                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"Echec d'enregistrement de l'article", ButtonType.OK);
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert btnAjouterArticleClient != null : "fx:id=\"btnAjouterArticleClient\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert textfileldLibelle != null : "fx:id=\"textfileldLibelle\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert lblRechercher1 != null : "fx:id=\"lblRechercher1\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert txtfieldLaver != null : "fx:id=\"txtfieldLaver\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert txtfieldRepasser != null : "fx:id=\"txtfieldRepasser\" was not injected: check your FXML file 'ArticleClient.fxml'.";
    }
}
