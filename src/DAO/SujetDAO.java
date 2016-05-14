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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import technique.DataSource;


public class SujetDAO  {

    private Connection connection;
    JTable jTableSujet;
   

    public SujetDAO() {
        
        connection = DataSource.getInstance().getConnection();
        
        
    }

    
    //Mérhode d'ajout_Sujet:
 
     public void addSujet(Sujet sj) {
        try {
            String req = "insert into Sujet (titre , sujet, user_id) values (? , ?, ? )";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, sj.getTitre());
             ps.setString(2, sj.getSujet());
              ps.setInt(3, sj.getUser().getId());
            ps.executeUpdate();
            System.out.println("Sujet ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
     
     
 // Méthode de supression_Sujet :
     
        public void removeSujetById(int id) {

            List<CommentaireSujet> lcs=new CommentaireSujetDAO().findCommentaireBySujet(id);
            for(CommentaireSujet c:lcs){
                new CommentaireSujetDAO().removeCommentaireById(c.getId());
            }
            String requete = "DELETE FROM Sujet WHERE id=?";
           
        try { 
           PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Sujet supprimé");
        }catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
        
        
     // Méthode Find_Sujet:
        
      public Sujet findSujetById(int id){
          
            String requete = "select * from Sujet where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            Sujet sjt = new Sujet();
            
             User us=new User();
             UserDAO usdao=new UserDAO();
            while (resultat.next()) {
                us=usdao.findUserById(resultat.getInt(2));
                sjt.setUser(us);
                sjt.setId(resultat.getInt(1));
                sjt.setTitre(resultat.getString(3));
                sjt.setSujet(resultat.getString(4));
            }
            return sjt;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
      }       
   
// Methode d'affichage_des sujets:
      
           public  List<Sujet> AfficherSujet() {

        List<Sujet> listesujets = new ArrayList<>();
        String requete = "select * from Sujet";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            SujetDAO sujetD = new SujetDAO();
            User us=new User();
            UserDAO usdao=new UserDAO();
            while (resultat.next()) {
                
              
                Sujet sjt = new Sujet();
                sjt.setId(resultat.getInt("id"));
                us=usdao.findUserById(resultat.getInt("user_id"));
                sjt.setUser(us);
                sjt.setTitre(resultat.getString("titre"));
                sjt.setSujet(resultat.getString("sujet"));
               // sjt.setSujet(sujetD.findSujetById(resultat.getInt(4)));
                listesujets.add(sjt);
            }
            return listesujets;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
           
           
        //Méthode Modifier_Sujet:
           
         public void updateSujet(Sujet sujet) {
        String requete = "update Sujet set sujet=? , titre=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, sujet.getSujet());
             ps.setString(2, sujet.getTitre());
            ps.setInt(3, sujet.getId());
             
           // AbstractTableModel model = (AbstractTableModel) jTableSujet.getModel();
            
          // jTableSujet.setValueAt(sujet, jTableSujet.getSelectedRow(), 3);
           
            
            ps.executeUpdate();
           
                    //model.fireTableCellUpdated(jTableSujet.getSelectedRow(), jTableSujet.getSelectedColumn());
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
           
         public List<Sujet> findSujetByUser(int id){
            List<Sujet> listesujets = new ArrayList<>();
            String requete = "select * from Sujet where user_id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Sujet sjt = new Sujet();
                sjt.setId(resultat.getInt(1));
                sjt.setTitre(resultat.getString(3));
                sjt.setSujet(resultat.getString(4));
                sjt.setUser(new UserDAO().findUserById(resultat.getInt("user_id")));
                listesujets.add(sjt);
            }
            return listesujets;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
      }      
        
}
