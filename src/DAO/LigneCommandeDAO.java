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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import technique.DataSource;

/**
 *
 * @author gafsi
 */
public class LigneCommandeDAO {

    private Connection connection;

    public LigneCommandeDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addLigneCommande(LigneCommande ligneCommand) {
        try {
            String req = "insert into ligneCommande (qte,produit_id,panier_id) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, ligneCommand.getQte());
            ps.setInt(2, ligneCommand.getProduit().getId());
            ps.setInt(3, ligneCommand.getPanier().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }

    public void updateLigneCommande(LigneCommande lignecommande) {
        String requete = "update LigneCommande set qte=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, lignecommande.getQte());

            ps.setInt(5, lignecommande.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void removeLigneCommandeById(int id) {
        String requete = "delete from LigneCommande where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Ligne Commande supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public LigneCommande findLigneCommandeById(int id) {
        LigneCommande lignecommande = new LigneCommande();
        //      UserDAO userDAO=new UserDAO();
        PanierDAO panierDAO = new PanierDAO();
        ProduitDAO produitDAO = new ProduitDAO();
        String requete = "select * from LigneCommande where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                lignecommande.setId(resultat.getInt(1));
                lignecommande.setQte(resultat.getInt("Qte"));
                lignecommande.setPanier(panierDAO.findPanierById(resultat.getInt("panier_id")));
                lignecommande.setProduit(produitDAO.findProduitById(resultat.getInt("produit_id")));
                //   lignecommande.setUser(userDAO.findUserById(resultat.getInt("user")));
            }
            return lignecommande;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'adresse " + ex.getMessage());
            return null;
        }
    }

    public List<LigneCommande> findLigneCommandByPanier(int id) {
        List<LigneCommande> listecommand = new ArrayList<>();
        PanierDAO panierDAO = new PanierDAO();
        ProduitDAO produitDAO = new ProduitDAO();
        String requete = "select * from ligneCommande where panier_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            //ps.setString(1, proprtie);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                LigneCommande lignecommande = new LigneCommande();
                lignecommande.setId(resultat.getInt(1));
                lignecommande.setQte(resultat.getInt("Qte"));
                lignecommande.setPanier(panierDAO.findPanierById(resultat.getInt("panier_id")));
                lignecommande.setProduit(produitDAO.findProduitById(resultat.getInt("produit_id")));
                listecommand.add(lignecommande);
            }
            return listecommand;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des adresses " + ex.getMessage());
            return null;
        }
    }

    public List<LigneCommande> findAll() {
        List<LigneCommande> listecommand = new ArrayList<>();
        PanierDAO panierDAO = new PanierDAO();
        ProduitDAO produitDAO = new ProduitDAO();
        String requete = "select * from ligneCommande";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                LigneCommande lignecommande = new LigneCommande();
                lignecommande.setId(resultat.getInt(1));
                lignecommande.setQte(resultat.getInt("Qte"));
                lignecommande.setPanier(panierDAO.findPanierById(resultat.getInt("panier_id")));
                lignecommande.setProduit(produitDAO.findProduitById(resultat.getInt("produit_id")));
                listecommand.add(lignecommande);
            }
            return listecommand;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des adresses " + ex.getMessage());
            return null;
        }
    }

    public boolean exist(int produitId, int panierId) {
        String requete = "select count(id) from LigneCommande where panier_id=? and produit_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, panierId);
            ps.setInt(2, produitId);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                 System.out.println(resultat.getInt(1));
                  System.out.println(panierId);
                   System.out.println(produitId);
                if(resultat.getInt(1)>0){
                    System.out.println(resultat.getInt(1));
                    return true;
                }
                
                
            }
            System.err.println("flase");
            return false;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du produit dans la ligne de commande " + ex.getMessage());
            return false;
        }
    }
}
