package com.blanchisserie.blanchisseriemoderne;

import java.sql.*;
public class ConnexionMySQL {
    public Connection cn = null;
    public static Connection ConnexionDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionBlanchisserie","root","root");
            //System.out.println("connexion reussi");
            return cn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
