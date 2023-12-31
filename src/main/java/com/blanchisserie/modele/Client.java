package com.blanchisserie.modele;

public class Client {

    String nomClient;
    String prenomClient;
    String telClient;
    String emailClient;

    public  Client(String nomClient, String prenomClient, String telClient, String emailClient){

        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.telClient = telClient;
        this.emailClient = emailClient;
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


    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }
}
