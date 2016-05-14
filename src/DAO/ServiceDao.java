/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Service;
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
public class ServiceDao {

    private Connection connection;

    public ServiceDao() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addService(Service s) {
        String requete = "insert into service (nom,description,mail,telephone,adresse,estimation,Proprietaire_id,categorie_id) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, s.getNom());
            ps.setString(2, s.getDescription());
            ps.setString(3, s.getMail());
            ps.setInt(4, s.getTelephone());
            ps.setString(5, s.getAdresse());
            ps.setInt(6, s.getEstimation());
            ps.setInt(7, s.getProprietaire().getId());
            ps.setString(8, s.getCategorie().getId());

            ps.executeUpdate();
            System.out.println("Ajout effectué avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }

    }

    public void updateService(Service ap) {
        String requete = "update service set nom =?, description=?,mail =? , telephone =?, adresse =?,estimation=?,categorie_id=?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, ap.getNom());
            ps.setString(2, ap.getDescription());
            ps.setString(3, ap.getMail());
            ps.setInt(4, ap.getTelephone());
            ps.setString(5, ap.getAdresse());
            ps.setInt(6, ap.getEstimation());
            ps.setString(7, ap.getCategorie().getId());
            ps.setInt(8, ap.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeServiceById(int id) {
        String requete = "delete from service where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public void validerService(int id) {
        String requete = "update service set valider= 1 where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Validation effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la validation " + ex.getMessage());
        }
    }

    public List<Service> findAllServicesValid() {
        List<Service> listeServices = new ArrayList<>();
        String requete = "select * from service where valider =1 ";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            UserDAO UserDao = new UserDAO();
            CategorieServiceDao CategorieServiceDao = new CategorieServiceDao();
            while (resultat.next()) {
                Service service = new Service();
                service.setId(resultat.getInt(1));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setValider(resultat.getInt(5));
                service.setEstimation(resultat.getInt(6));
                service.setMail(resultat.getString(7));
                service.setTelephone(resultat.getInt(8));
                service.setAdresse(resultat.getString(9));
                service.setCategorie(CategorieServiceDao.findbyid(resultat.getString(10)));
                listeServices.add(service);
            }
            return listeServices;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des services " + ex.getMessage());
            return null;
        }
    }

    public List<Service> findbyCategorie(String categorie) {
        List<Service> listeServices = new ArrayList<>(); 
        UserDAO UserDao = new UserDAO();
        CategorieServiceDao CategorieServiceDao = new CategorieServiceDao();

        String requete = "select  * from service where categorie_id=? and valider=1";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, categorie);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Service service = new Service();
                service.setId(resultat.getInt(1));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setValider(resultat.getInt(5));
                service.setEstimation(resultat.getInt(6));
                service.setMail(resultat.getString(7));
                service.setTelephone(resultat.getInt(8));
                service.setAdresse(resultat.getString(9));
                service.setCategorie(CategorieServiceDao.findbyid(resultat.getString(10)));
                listeServices.add(service);
            }
            return listeServices;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du service " + ex.getMessage());
            return null;
        }
    }

    public List<Service> findAllServicesInvalid() {
        List<Service> listeServices = new ArrayList<>();
        String requete = "select * from service where valider =0 ";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            UserDAO UserDao = new UserDAO();
            CategorieServiceDao CategorieServiceDao = new CategorieServiceDao();
            while (resultat.next()) {
                Service service = new Service();
                service.setId(resultat.getInt(1));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setValider(resultat.getInt(5));
                service.setEstimation(resultat.getInt(6));
                service.setMail(resultat.getString(7));
                service.setTelephone(resultat.getInt(8));
                service.setAdresse(resultat.getString(9));
                service.setCategorie(CategorieServiceDao.findbyid(resultat.getString(10)));
                listeServices.add(service);
            }
            return listeServices;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des services" + ex.getMessage());
            return null;
        }
    }

    public List<Service> findByNom(String nom) {
        List<Service> listeServices = new ArrayList<>();
        UserDAO UserDao = new UserDAO();
        CategorieServiceDao CategorieServiceDao = new CategorieServiceDao();

        String requete = "select * from service where nom =?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Service service = new Service();
                service.setId(resultat.getInt(1));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setValider(resultat.getInt(5));
                service.setEstimation(resultat.getInt(6));
                service.setMail(resultat.getString(7));
                service.setTelephone(resultat.getInt(8));
                service.setAdresse(resultat.getString(9));
                service.setCategorie(CategorieServiceDao.findbyid(resultat.getString(10)));
                listeServices.add(service);
            }
            return listeServices;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du service " + ex.getMessage());
            return null;
        }

    }
     public List<Service> findByUser(int  id) {
        List<Service> listeServices = new ArrayList<>();
        UserDAO UserDao = new UserDAO();
        CategorieServiceDao CategorieServiceDao = new CategorieServiceDao();

        String requete = "select * from service where Proprietaire_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Service service = new Service();
                service.setId(resultat.getInt(1));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setValider(resultat.getInt(5));
                service.setEstimation(resultat.getInt(6));
                service.setMail(resultat.getString(7));
                service.setTelephone(resultat.getInt(8));
                service.setAdresse(resultat.getString(9));
                service.setCategorie(CategorieServiceDao.findbyid(resultat.getString(10)));
                listeServices.add(service);
            }
            return listeServices;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du service " + ex.getMessage());
            return null;
        }

    }

    public Service findServiceById(int id) {
        Service service = new Service();
        UserDAO UserDao = new UserDAO();
        CategorieServiceDao CategorieServiceDao = new CategorieServiceDao();

        String requete = "select * from service where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                service.setId(resultat.getInt(1));
                service.setProprietaire(UserDao.findUserById(resultat.getInt(2)));
                service.setNom(resultat.getString(3));
                service.setDescription(resultat.getString(4));
                service.setValider(resultat.getInt(5));
                service.setEstimation(resultat.getInt(6));
                service.setMail(resultat.getString(7));
                service.setTelephone(resultat.getInt(8));
                service.setAdresse(resultat.getString(9));
                service.setCategorie(CategorieServiceDao.findbyid(resultat.getString(10)));
                
            }
            return service;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }

    }
    

 
}
