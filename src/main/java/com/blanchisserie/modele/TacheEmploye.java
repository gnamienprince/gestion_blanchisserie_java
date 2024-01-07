package com.blanchisserie.modele;

public class TacheEmploye {
    int idTacheEmploye;
    String descriptionTache;
    String employe;
    String commande;

    public TacheEmploye(int idTacheEmploye, String descriptionTache, String employe, String commande, String statutCommande) {
        this.idTacheEmploye = idTacheEmploye;
        this.descriptionTache = descriptionTache;
        this.employe = employe;
        this.commande = commande;
    }



    public int getIdTacheEmploye() {
        return idTacheEmploye;
    }

    public void setIdTacheEmploye(int idTacheEmploye) {
        this.idTacheEmploye = idTacheEmploye;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public String getEmploye() {
        return employe;
    }

    public void setEmploye(String employe) {
        this.employe = employe;
    }

    public String getCommande() {
        return commande;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }


}
