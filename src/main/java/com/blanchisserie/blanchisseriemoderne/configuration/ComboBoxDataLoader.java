package com.blanchisserie.blanchisseriemoderne.configuration;
import java.sql.*;
import javafx.scene.control.ComboBox;
public class ComboBoxDataLoader {

    //comboBox des articles
    public void loadDataToComboBox(ComboBox<String> comboBox) {
        // Connexion à la base de données
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionBlanchisserie","root","root");) {

            // Requête pour récupérer les données de la colonne libelleArticle de article
            String query = "SELECT libelleArticle FROM article";

            // Création d'une déclaration SQL
            Statement stmt = conn.createStatement();

            // Exécution de la requête SQL
            ResultSet rs = stmt.executeQuery(query);

            // Ajout des données à la ComboBox
            while (rs.next()) {
                String libelleArticle = rs.getString("libelleArticle");
                comboBox.getItems().add(libelleArticle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //comboBox des commandes
    public void loadDataToComboBoxCommande(ComboBox<String> comboBox) {
        // Connexion à la base de données
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionBlanchisserie","root","root");) {

            // Requête pour récupérer les données de la colonne libelleArticle de article
            String query = "SELECT idCommande FROM commande where statutCommande = 0";

            // Création d'une déclaration SQL
            Statement stmt = conn.createStatement();

            // Exécution de la requête SQL
            ResultSet rs = stmt.executeQuery(query);

            // Ajout des données à la ComboBox
            while (rs.next()) {
                String idCommande = rs.getString("idCommande");
                comboBox.getItems().add(idCommande);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
