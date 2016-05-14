/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Appeldoffre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import technique.DataSource;

/**
 *
 * @author MBII
 */
public class AppeldoffreDao {

    private Connection connection;

    public AppeldoffreDao() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addAppeldoffre(Appeldoffre ap) {

        String requete = "insert into appeldoffre (nom,description,proprietaire_id,mail,telephone,adresse) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, ap.getNom());
            ps.setString(2, ap.getDescription());
            ps.setInt(3, ap.getProprietaire().getId());
            ps.setString(4, ap.getMail());
            ps.setInt(5, ap.getTelephone());
            ps.setString(6, ap.getAdresse());
            ps.executeUpdate();
            System.out.println("Ajout effectué avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }

    }

    public void updateAppeldoffre(Appeldoffre ap) {
        String requete = "update appeldoffre set nom =?, description=?, mail =? , telephone =?, adresse =? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, ap.getNom());
            ps.setString(2, ap.getDescription());

            ps.setString(3, ap.getMail());
            ps.setInt(4, ap.getTelephone());
            ps.setString(5, ap.getAdresse());
            ps.setInt(6, ap.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la modification de l'appel d'offre" + ex.getMessage());
        }
    }

    public void removeAppeldoffreById(int id) {
        String requete = "delete  from appeldoffre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de l'appel d'offre" + ex.getMessage());
        }
    }

  
    public List<Appeldoffre> findAll() {
        List<Appeldoffre> listedepots = new ArrayList<>();
        String requete = "select * from appeldoffre";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             UserDAO UserDao = new UserDAO();
            while (resultat.next()) {
                Appeldoffre ap = new Appeldoffre();
                ap.setId(resultat.getInt(1));
                ap.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                ap.setNom(resultat.getString(3));
                ap.setDescription(resultat.getString(4));
                ap.setMail(resultat.getString(5));
                ap.setTelephone(resultat.getInt(6));
                ap.setAdresse(resultat.getString(7));

                listedepots.add(ap);
            }
            return listedepots;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des appels d'offres " + ex.getMessage());
            return null;
        }
    }

   
    public List<Appeldoffre> findbynom(String nom) {
        String requete = "select * from appeldoffre where nom=?";
        List<Appeldoffre> listedepots = new ArrayList<>();
        Appeldoffre stock = new Appeldoffre();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {

                stock.setNom(resultat.getString(3));
                stock.setDescription(resultat.getString(4));
                stock.setMail(resultat.getString(5));
                stock.setAdresse(resultat.getString(7));
                stock.setTelephone(resultat.getInt(6));
                stock.setId(resultat.getInt(1));
                stock.setProprietaire(new UserDAO().findUserById(resultat.getInt(2)));

                listedepots.add(stock);
            }
            return listedepots;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }

    
    

    public Appeldoffre findbyid(int id) {
        Appeldoffre service = new Appeldoffre();
        UserDAO UserDao = new UserDAO();

        String requete = "select * from appeldoffre where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                service.setId(resultat.getInt(1));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setMail(resultat.getString(3));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setAdresse(resultat.getString(7));
                service.setMail(resultat.getString(5));
                service.setTelephone(resultat.getInt(6));

            }
            return service;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'appel d'offre " + ex.getMessage());
            return null;
        }
    }
    public List<Appeldoffre> findbyUser(int id) {
        
        List<Appeldoffre> listeAP = new ArrayList<>();
        UserDAO UserDao = new UserDAO();

        String requete = "select * from appeldoffre where proporietaire_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Appeldoffre ap = new Appeldoffre();
                ap.setId(resultat.getInt(1));
                ap.setNom(resultat.getString(3));
                ap.setDescription(resultat.getString(4));
                ap.setMail(resultat.getString(3));
                ap.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                ap.setAdresse(resultat.getString(7));
                ap.setMail(resultat.getString(5));
                ap.setTelephone(resultat.getInt(6));
                listeAP.add(ap);

            }
            return listeAP;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'appel d'offre " + ex.getMessage());
            return null;
        }
    }
}
