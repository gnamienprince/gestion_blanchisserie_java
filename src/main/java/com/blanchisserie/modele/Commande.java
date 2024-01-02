package com.blanchisserie.modele;

import java.util.Date;

public class Commande {
    String idCommande;
    String nomClient;
    String prenomClient;
    String dateCommande;
    String statutCommande;

    public Commande(String idCommande, String nomClient, String prenomClient, String dateCommande, String statutCommande) {
        this.idCommande = idCommande;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(String statutCommande) {
        this.statutCommande = statutCommande;
    }
}
