package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.blanchisserie.blanchisseriemoderne.configuration.ComboBoxDataLoader;
import com.blanchisserie.modele.Vetement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static com.blanchisserie.blanchisseriemoderne.SendMessage.sendMessage;

public class GestionCommandeController {
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
    private Button btnNewClient;

    @FXML
    private Button btnEtatCommande;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnRetour;

    @FXML
    private Button btnAjouterCommande;

    @FXML
    private TextField listViewIDClient;

    @FXML
    private Label lblRechercher1;

    @FXML
    private TextArea textfileldDescription;

    @FXML
    private Label lblRechercher11;

    @FXML
    private Label lblRechercher1211;

    @FXML
    private TextField textfileldTotal;

    @FXML
    private ImageView ajouterArticle;

    @FXML
    private Label lblRechercher111;

    @FXML
    private Label lblInfo1;

    private List<Vetement> listeVetement = new ArrayList<>();

    public ResultSet result;

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
    private Button btnAjouter;

    //update nombre article
    public void initLabel(String valeur) {
        lblInfo1.setText(valeur);
    }

    //update prixTotal
    public void initPrix(String valeur){
        textfileldTotal.setText(valeur);
    }

    //id de l'article
    int idArticle = 0;
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



        //recuperation de l'id qui es rélié a l'article selectionner
        String sql = "select idArticle, prixLaver, prixRepasser from article where libelleArticle = ?";

        try {

            PreparedStatement pstmt = cnx.prepareStatement(sql);
            pstmt.setString(1, choixArticle); // Remplacement du paramètre avec la valeur spécifique

            // Exécution de la requête
            ResultSet rs = pstmt.executeQuery();

            // Récupération de l'ID si un résultat est trouvé
            if (rs.next()) {
                idArticle = rs.getInt("idArticle");

                if (choixL && !choixR) {
                    service = rs.getInt("prixLaver");
                } else if (!choixL && choixR) {
                    service = rs.getInt("prixRepasser");
                } else if (choixL && choixR) {
                    service = rs.getInt("prixLaver") + rs.getInt("prixRepasser");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez choisir un service", ButtonType.OK);
                    alert.showAndWait();
                }
            }



            System.out.println(idArticle);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(choixArticle);

        if (idArticle == 0 && couleurArticle.isEmpty() && marqueArticle.isEmpty() && qualiteArticle.isEmpty() && choixArticle.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez renseigner tout les champs", ButtonType.OK);
            alert.showAndWait();
        } else {
            //objet pour les elements de l'article
            Vetement vetement = new Vetement(couleurArticle, marqueArticle, qualiteArticle, service);
            listeVetement.add(vetement);

            //le nombre de donné enregistrer dans une liste
            int nombre = listeVetement.size();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vêtement enregistrer, vous pouvez enregistrer d'autres", ButtonType.OK);
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

            //on parse le nombre en string pour l'affichage
            String nombreNbr = String.valueOf(nombre);

            //appel de la fonction pour modifier le nombre d'article enregistrer
            initLabel(nombreNbr);

        }

        //la somme des vêtements enrégistrer
        int prixTotal = 0;
        for (Vetement donnees : listeVetement) {
            prixTotal += donnees.getServiceVetement();
        }

        //après l'obtention de la somme totale on met a jour la vue
        String prixTotalString = String.valueOf(prixTotal);
        initPrix(prixTotalString);
    }


    @FXML
    void btnAjouterCommande(MouseEvent event) {
       String description = textfileldDescription.getText();
       String idClient =listViewIDClient.getText();
       LocalDate dateActuelle = LocalDate.now();
       LocalTime heureActuelle = LocalTime.now();

       if(description.isEmpty() && idClient.isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez saisir tous les champs", ButtonType.OK);
           alert.showAndWait();
       }else{
           //verification si le client existe
           String sql = "SELECT * FROM client WHERE idClient = ?";

           PreparedStatement pstmt = null;
           try {
               pstmt = cnx.prepareStatement(sql);
               pstmt.setString(1, idClient);

               ResultSet rs = pstmt.executeQuery();

               if(rs.next()) {
                   //identifiant trouver
                   //generation de l'id commande la date l'id et l'heure
                   String idCommande = dateActuelle + idClient + heureActuelle;
                   System.out.println(idCommande);
                   int statut = 0;

                   //Insertion dans la base de donnée commande maintenant

                   String sql2 ="INSERT INTO commande (idCommande, dateCommande, statutCommande, descriptionCommande, client) VALUES (?, ?, ?, ?, ?)";
                   try {
                       PreparedStatement st = cnx.prepareStatement(sql2);
                       st.setString(1, idCommande);
                       st.setString(2, String.valueOf(dateActuelle));
                       st.setInt(3, statut);
                       st.setString(4, description);
                       st.setString(5, idClient);
                       int rowsInserted = st.executeUpdate();



                       if (rowsInserted > 0) {
                           Alert alert = new Alert(Alert.AlertType.INFORMATION,"La commande a bien été enregistré avec succès !", ButtonType.OK);
                           alert.showAndWait();

                           //le fait de vider les champs apres avoir enregistrer un client

                           textfileldDescription.clear();
                           listViewIDClient.clear();
                           textfileldTotal.clear();


                           //sendMessage();

                           //ensuite ici on enregistre les vêtements dans la table vêtement avec le code de la commande
                           //on boucle la dessus pour enregistrer les vêtements

                           for (Vetement donnees : listeVetement) {

                               String sql3 ="INSERT INTO vetement (couleurVetement, marqueVetement, qualiteVetement, serviceVetement, article, commande) VALUES (?, ?, ?, ?, ?, ?)";
                               try {
                                   PreparedStatement st1 = cnx.prepareStatement(sql3);
                                   st1.setString(1, donnees.getCouleurVetement());
                                   st1.setString(2, donnees.getMarqueVetement());
                                   st1.setString(3, donnees.getQualiteVetement());
                                   st1.setString(4, String.valueOf(donnees.getServiceVetement()));
                                   st1.setInt(5, idArticle);
                                   st1.setString(6, idCommande);
                                   int rowsInserted1 = st1.executeUpdate();



                                   if (rowsInserted1 == 0) {
                                       Alert alert1 = new Alert(Alert.AlertType.ERROR,"Enregistrement Article échoué", ButtonType.OK);
                                       alert1.showAndWait();
                                   }else{
                                        System.out.println("ok");
                                   }
                               }
                               catch (SQLException e) {
                                   throw new RuntimeException(e);
                               }
                           }


                       } else {
                           Alert alert = new Alert(Alert.AlertType.INFORMATION,"Echec d'enregistrement de la commande", ButtonType.OK);
                           alert.showAndWait();
                       }
                   } catch (SQLException e) {
                       throw new RuntimeException(e);
                   }
               }else{
                   //identifiant non trouver
                   Alert alert = new Alert(Alert.AlertType.ERROR, "Identifiant client introuvable", ButtonType.OK);
                   alert.showAndWait();
               }

           } catch (SQLException e) {
               throw new RuntimeException(e);
           }



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
    void btnNewCommande(MouseEvent event) {

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
        ComboBoxDataLoader dataLoader = new ComboBoxDataLoader();
        dataLoader.loadDataToComboBox(cmbChoix);

        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblGestionClients != null : "fx:id=\"lblGestionClients\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnNewClient != null : "fx:id=\"btnNewClient\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnEtatCommande != null : "fx:id=\"btnEtatCommande\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblInfo != null : "fx:id=\"lblInfo\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnRetour != null : "fx:id=\"btnRetour\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnAjouterCommande != null : "fx:id=\"btnAjouterCommande\" was not injected: check your FXML file 'GestionCommande.fxml'.";

        assert lblRechercher1 != null : "fx:id=\"lblRechercher1\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert textfileldDescription != null : "fx:id=\"textfileldDescription\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblRechercher11 != null : "fx:id=\"lblRechercher11\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblRechercher1211 != null : "fx:id=\"lblRechercher1211\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert textfileldTotal != null : "fx:id=\"textfileldTotal\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblRechercher111 != null : "fx:id=\"lblRechercher111\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert lblInfo1 != null : "fx:id=\"lblInfo1\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert cmbChoix != null : "fx:id=\"cmbChoix\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert couleur != null : "fx:id=\"couleur\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert marque != null : "fx:id=\"marque\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert qualite != null : "fx:id=\"qualite\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert choixLaver != null : "fx:id=\"choixLaver\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert choixRepasser != null : "fx:id=\"choixRepasser\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert btnAjouter != null : "fx:id=\"btnAjouter\" was not injected: check your FXML file 'GestionCommande.fxml'.";
        assert listViewIDClient != null : "fx:id=\"listViewIDClient\" was not injected: check your FXML file 'GestionCommande.fxml'.";

    }
}




