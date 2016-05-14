/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import technique.DataSource;

/**
 *
 * @author gafsi
 */
public class PanierDAO {
    private Connection connection;

    public PanierDAO() {
        connection=DataSource.getInstance().getConnection();
    }
      
    
    
    public void addPanier(int id) {
        try {
            String req = "insert into Panier (id) values (?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }
    
     public void removePanierById(int id) {
        String requete = "delete from panier where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("panier supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    public Panier findPanierById(int id) {
        Panier panier =new Panier();
        ProduitDAO produit =new ProduitDAO();
        String req="SELECT * FROM panier where  panier.id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                panier.setId(resultat.getInt(1));
            }
            return panier;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du panier " + ex.getMessage());
            return null;
        }
    }

   

    
}
