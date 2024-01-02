package com.blanchisserie.modele;

public class Employe {
    String idEmploye;
    String nomEmploye;
    String prenomEmploye;
    String telEmploye;
    String fonctionEmploye;

    public Employe(String idEmploye, String nomEmploye, String prenomEmploye, String telEmploye, String fonctionEmploye) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.telEmploye = telEmploye;
        this.fonctionEmploye = fonctionEmploye;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public String getTelEmploye() {
        return telEmploye;
    }

    public void setTelEmploye(String telEmploye) {
        this.telEmploye = telEmploye;
    }

    public String getFonctionEmploye() {
        return fonctionEmploye;
    }

    public void setFonctionEmploye(String fonctionEmploye) {
        this.fonctionEmploye = fonctionEmploye;
    }
}
