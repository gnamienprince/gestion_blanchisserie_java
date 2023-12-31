package com.blanchisserie.blanchisseriemoderne;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

public class InformationClient2Controller {


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
    private Label lblInfo;

    @FXML
    private Button btnRetour;

    @FXML
    private Label lblHistorique;

    @FXML
    private TableColumn<?, ?> tabNom;

    @FXML
    private TableColumn<?, ?> tabPrenom;

    @FXML
    private TableColumn<?, ?> tabEmail;

    @FXML
    private TableColumn<?, ?> tabNumero;

    @FXML
    private TableColumn<?, ?> tabInfo;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnEnregistrer;

    @FXML
    private TextField textFieldNom;

    @FXML
    private TextField textFieldPrenom;

    @FXML
    private TextField textFieldTel;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldLocalisation;

    @FXML
    void btnEnregistrer(MouseEvent event) {

    }

    @FXML
    void btnInfoClient(MouseEvent event) {

    }

    @FXML
    void btnModifier(MouseEvent event) {

    }

    @FXML
    void btnNewClient(MouseEvent event) {

    }

    @FXML
    void btnRetour(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert lblGestion != null : "fx:id=\"lblGestion\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert btnInfoClient != null : "fx:id=\"btnInfoClient\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert lblHistorique != null : "fx:id=\"lblHistorique\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert tabNom != null : "fx:id=\"tabNom\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert tabPrenom != null : "fx:id=\"tabPrenom\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert tabEmail != null : "fx:id=\"tabEmail\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert tabNumero != null : "fx:id=\"tabNumero\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert tabInfo != null : "fx:id=\"tabInfo\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert btnModifier != null : "fx:id=\"btnModifier\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert btnEnregistrer != null : "fx:id=\"btnEnregistrer\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert textFieldNom != null : "fx:id=\"textFieldNom\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert textFieldPrenom != null : "fx:id=\"textFieldPrenom\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert textFieldTel != null : "fx:id=\"textFieldTel\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert textFieldEmail != null : "fx:id=\"textFieldEmail\" was not injected: check your FXML file 'InformationClient2.fxml'.";
        assert textFieldLocalisation != null : "fx:id=\"textFieldLocalisation\" was not injected: check your FXML file 'InformationClient2.fxml'.";

    }
}