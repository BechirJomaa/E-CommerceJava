/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.CategorieService;
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
public class CategorieServiceDao {

    private Connection connection;

    public CategorieServiceDao() {
        connection = DataSource.getInstance().getConnection();

    }

    public void addCategorieService(CategorieService cat) {
        String requete = "insert into CategorieService (id,description) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cat.getId());
            ps.setString(2, cat.getDescription());
            ps.executeUpdate();
            System.out.println("Categorie Ajouter avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public void updateCategorieService(CategorieService cat) {
        String requete = "update CategorieService set description=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cat.getDescription());
            ps.setString(2, cat.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void removeCategorieServiceById(String id) {
        String requete = "delete from categorieservice where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public List<CategorieService> findAll() {

        List<CategorieService> listedepots = new ArrayList<>();
        String requete = "select * from categorieservice";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                CategorieService depot = new CategorieService();
                depot.setId(resultat.getString(1));
                depot.setDescription(resultat.getString(2));
                listedepots.add(depot);
            }
            return listedepots;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement  " + ex.getMessage());
            return null;
        }
    }

    public CategorieService findbyid(String id) {
        CategorieService depot = new CategorieService();
        String requete = "select * from categorieservice where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                depot.setId(resultat.getString(1));
                depot.setDescription(resultat.getString(2));
            }
            return depot;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche  " + ex.getMessage());
            return null;
        }
    }

   
}
