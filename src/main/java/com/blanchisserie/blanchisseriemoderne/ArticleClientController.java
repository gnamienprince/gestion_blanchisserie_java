package com.blanchisserie.blanchisseriemoderne;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ArticleClientController {

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
    private TextField textfileldTotal1;

    @FXML
    private Label lblRechercher1;

    @FXML
    private TextField txtfieldLaver;

    @FXML
    private TextField txtfieldRepasser;

    @FXML
    void btnAjouterArticleClient(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert btnAjouterArticleClient != null : "fx:id=\"btnAjouterArticleClient\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert textfileldTotal1 != null : "fx:id=\"textfileldTotal1\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert lblRechercher1 != null : "fx:id=\"lblRechercher1\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert txtfieldLaver != null : "fx:id=\"txtfieldLaver\" was not injected: check your FXML file 'ArticleClient.fxml'.";
        assert txtfieldRepasser != null : "fx:id=\"txtfieldRepasser\" was not injected: check your FXML file 'ArticleClient.fxml'.";
    }
}
