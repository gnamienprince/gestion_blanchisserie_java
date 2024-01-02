package com.blanchisserie.modele;

public class Vetement {
    String couleurVetement;
    String marqueVetement;
    String qualiteVetement;
    Integer serviceVetement;

    public Vetement(String couleurVetement, String marqueVetement, String qualiteVetement, Integer serviceVetement) {
        this.couleurVetement = couleurVetement;
        this.marqueVetement = marqueVetement;
        this.qualiteVetement = qualiteVetement;
        this.serviceVetement = serviceVetement;
    }

    public String getCouleurVetement() {
        return couleurVetement;
    }

    public void setCouleurVetement(String couleurVetement) {
        this.couleurVetement = couleurVetement;
    }

    public String getMarqueVetement() {
        return marqueVetement;
    }

    public void setMarqueVetement(String marqueVetement) {
        this.marqueVetement = marqueVetement;
    }

    public String getQualiteVetement() {
        return qualiteVetement;
    }

    public void setQualiteVetement(String qualiteVetement) {
        this.qualiteVetement = qualiteVetement;
    }

    public int getServiceVetement() {
        return serviceVetement;
    }

    public void setServiceVetement(Integer serviceVetement) {
        this.serviceVetement = serviceVetement;
    }
}
