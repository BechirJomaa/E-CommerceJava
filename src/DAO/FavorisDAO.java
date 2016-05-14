/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Favoris;
import Entity.Produit;
import Entity.Sujet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author gafsi
 */
public class FavorisDAO {
    private Connection connection;
    public FavorisDAO() {
         connection = DataSource.getInstance().getConnection();
    }
    
     public void addFavoris(int id) {
        try {
            String req = "insert into Favoris (id) values (?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }
      public void addFavorisProduits(Favoris favoris,Produit produit) {
        try {
            String req = "INSERT INTO favoris_produit(favoris_id, produit_id) VALUES (?,?) ";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, favoris.getId());
            ps.setInt(2, produit.getId());
             favoris.addProduit(produit);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }
  
    public void removeProduitById(int id) {
        String requete = "DELETE FROM favoris_produit WHERE produit_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("produit supprimé du favoris");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Favoris findFavorisById(int id) {
        Favoris favoris=new Favoris();
        String requete = "SELECT * FROM favoris, favoris_produit where favoris.id = favoris_produit.favoris_id and favoris.id=?";
        String requete2 = "SELECT * FROM favoris where favoris.id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete2);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                favoris.setId(resultat.getInt(1));
            }
            
            return favoris;
            } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du favoris " + ex.getMessage());
            return null;
        }          
            

            
    }
     public List<Produit> findProduitsByFavorisId(int id) {
        List<Produit> produits=new ArrayList<>();
        String requete = "SELECT * FROM  favoris_produit where  favoris_id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                produits.add(new ProduitDAO().findProduitById(resultat.getInt(2)));
            }
            resultat.close();
            ps.close();
            return produits;
            } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du favoris " + ex.getMessage());
            return null;
        }
    }
    
        
        
    

  public boolean exist(Favoris favoris,Produit produit) {


        String requete = "SELECT count(produit_id) FROM favoris, favoris_produit where favoris.id = favoris_produit.favoris_id and favoris.id=? and favoris_produit.produit_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, favoris.getId());
            ps.setInt(2, produit.getId());
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                if(resultat.getInt(1)>0){
                    return true;
                }
            }
            return false;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du favoris " + ex.getMessage());
            return false;
        }
        
    }
   
 
  
}
