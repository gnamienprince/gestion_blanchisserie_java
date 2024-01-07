package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import com.blanchisserie.modele.Commande;
import com.blanchisserie.modele.TacheEmploye;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TacheEmployeController {
    Connection cnx;

    public PreparedStatement st;
    public ResultSet result;
    private Parent fxml;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnTacheExecute;

    @FXML
    private Button btnHistorique;

    @FXML
    private Button btnLivraison;

    @FXML
    private TableView<Commande> tableauTache;

    @FXML
    private TableColumn<Commande, String> cellReference;

    @FXML
    private TableColumn<Commande, String> cellDescription;

    @FXML
    private TableColumn<Commande, Date> cellDateCommande;


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
        root.getScene().getWindow().hide();
        Stage gestionClient = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("EspaceEmploye.fxml"));
            Scene scene = new Scene(fxml);
            gestionClient.setScene(scene);
            gestionClient.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*private String getEtatCommande(String statut) {
        // Convertir le statut numérique en texte descriptif
        switch (statut) {
            case "1":
                return "En attente";
            case "2":
                return "En cours";
            // Ajoutez d'autres cas pour les autres états de commande si nécessaire
            default:
                return "Statut inconnu";
        }
    }*/

        public ObservableList<Commande> data = FXCollections.observableArrayList();
    // Création de la colonne de boutons
    TableColumn<Commande, Void> cellButton = new TableColumn<>("Actions");

    public void tableauTache(){
        String sql = "SELECT * FROM commande JOIN tacheEmploye ON tacheEmploye.commande = commande.idCommande JOIN employe ON tacheEmploye.employe = employe.idEmploye where statutCommande between 1 and 2";
        try {

            //PreparedStatement pstmt = cnx.prepareStatement(sql);
            //pstmt.setString(1, ); // Remplacement du paramètre avec la valeur spécifique

            // Exécution de la requête
            //ResultSet rs = pstmt.executeQuery();

            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()){
                data.add(new Commande(result.getString("idCommande"),result.getString("descriptionCommande"), result.getString("dateCommande")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        cellReference.setCellValueFactory(new PropertyValueFactory<Commande, String>("idCommande"));
        cellDescription.setCellValueFactory(new PropertyValueFactory<Commande, String>("descriptionCommande"));
        cellDateCommande.setCellValueFactory(new PropertyValueFactory<Commande, Date>("dateCommande"));
        // Création de la colonne des boutons
        TableColumn<Commande, Void> cellButton = new TableColumn<>("En cours/Terminer");

        cellButton.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Action");

            {
                btn.setOnAction(event -> {
                    Commande commande = getTableView().getItems().get(getIndex());

                    //System.out.println("Action sur la commande : " + commande.getIdCommande());

                    String sql = "select * from commande where idCommande = ?";

                    PreparedStatement pstmt = null;
                    try {
                        pstmt = cnx.prepareStatement(sql);
                        pstmt.setString(1, commande.getIdCommande());

                        ResultSet rs = pstmt.executeQuery();

                        if(rs.next()) {

                            //le statut de la commande

                            int statuCommande = Integer.parseInt(rs.getString("statutCommande"));


                            //la condition maintennant pour pouvoir mettre la tâche en cours ou terminer

                            if(statuCommande == 1){
                                System.out.println("on met en cours");


                                String sql2 = "UPDATE commande SET statutCommande = ? WHERE idCommande = ?";
                                try {
                                    PreparedStatement st2 = cnx.prepareStatement(sql2);
                                    int newStatut = 2;

                                    // Définir les paramètres dans la requête UPDATE
                                    st2.setInt(1, newStatut);
                                    st2.setString(2, commande.getIdCommande());

                                    // Exécuter la requête UPDATE
                                    int lignesModifiees = st2.executeUpdate();

                                    if (lignesModifiees > 0) {
                                        //System.out.println("cool");

                                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Vous avez mis cette commande en cours de traitement", ButtonType.OK);
                                        alert.showAndWait();
                                    } else {
                                        System.out.println("nooon");
                                    }
                                }
                                catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if(statuCommande == 2){
                                System.out.println("on met terminer");
                                String sql2 = "UPDATE commande SET statutCommande = ? WHERE idCommande = ?";
                                try {
                                    PreparedStatement st2 = cnx.prepareStatement(sql2);
                                    int newStatut = 3;

                                    // Définir les paramètres dans la requête UPDATE
                                    st2.setInt(1, newStatut);
                                    st2.setString(2, commande.getIdCommande());

                                    // Exécuter la requête UPDATE
                                    int lignesModifiees = st2.executeUpdate();

                                    if (lignesModifiees > 0) {
                                        //System.out.println("cool");
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Vous avez terminer cette commande", ButtonType.OK);
                                        alert.showAndWait();

                                        //reload la fenetre
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


                                    } else {
                                        System.out.println("nooon");
                                    }
                                }
                                catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }


                        }else{
                            //Alert alert = new Alert(Alert.AlertType.ERROR,"Cet identifiant n'existe pas dans la base de donnée", ButtonType.OK);
                            //alert.showAndWait();
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }


                });
            }



            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        /*cellMarquer.setCellValueFactory(cellData -> new SimpleStringProperty(getEtatCommande(cellData.getValue().getStatutCommande())));*/

        tableauTache.getColumns().add(cellButton);

        tableauTache.setItems(data);
    }



    @FXML
    void initialize() {
        cnx = ConnexionMySQL.ConnexionDB();
        tableauTache();
        assert btnTacheExecute != null : "fx:id=\"btnTacheExecute\" was not injected: check your FXML file 'TacheEmploye.fxml'.";
        assert btnHistorique != null : "fx:id=\"btnHistorique\" was not injected: check your FXML file 'TacheEmploye.fxml'.";
        assert btnLivraison != null : "fx:id=\"btnLivraison\" was not injected: check your FXML file 'TacheEmploye.fxml'.";
        assert tableauTache != null : "fx:id=\"tableauCommande\" was not injected: check your FXML file 'TacheEmploye.fxml'.";
        assert cellReference != null : "fx:id=\"cellReference\" was not injected: check your FXML file 'TacheEmploye.fxml'.";
        assert cellDescription != null : "fx:id=\"cellDescription\" was not injected: check your FXML file 'TacheEmploye.fxml'.";
        assert cellDateCommande != null : "fx:id=\"cellDateCommande\" was not injected: check your FXML file 'TacheEmploye.fxml'.";

        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'TacheEmploye.fxml'.";

    }
}
