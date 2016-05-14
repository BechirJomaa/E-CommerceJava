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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;



/**
 *
 * @author jomaa
 */
public class CommentaireServiceDAO {
 private Connection connection;

    public CommentaireServiceDAO() {
        
        connection = DataSource.getInstance().getConnection();
    }

     //Ajout commentaire
       public void addCommentaireService(CommentaireService com) {
        try {
            String req = "insert into CommentaireService  (service_id, user_id, Commentaire,dateCom) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, com.getService().getId());
            ps.setInt(2, com.getUser().getId());
            ps.setString(3, com.getCommentaire()); 
            ps.setDate(4,com.getDateComm());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

       //Supprimer commentaire
       public void removeCommentaireById(int id ) {
            Commentaire com =new Commentaire();
              String requete = "DELETE FROM CommentaireService WHERE id=?";
            
        try {
           
           PreparedStatement ps = connection.prepareStatement(requete);
           ps.setInt(1,id);
         // ps.setString(id, com.getCorps());
           int p= ps.executeUpdate();
           if(p>0){
                System.out.println("Commentaire supprimé");
           }
           
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
       
       
         // Méthode Find_commentaire:
        
      public CommentaireService findCommentaireServiceById(int id){
          
            String requete = "select * from CommentaireService where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            CommentaireService com = new CommentaireService();
            
             User us=new User();
             UserDAO usdao=new UserDAO();
            while (resultat.next()) {
//               us=usdao.findUserById(resultat.getInt(2));
//                sjt.setUser(us);
                com.setCommentaire(resultat.getString(4));
                
            }
           return com; 
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
      }
      
       public void updateCommentaireService(CommentaireService com) {
        String requete = "update CommentaireService set service_id=? ,user_id=?, commentaire=?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           ps.setInt(1, com.getService().getId());
            ps.setInt(2, com.getUser().getId());
             ps.setString(3, com.getCommentaire());
             ps.setInt(4, com.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
       }
      //Affichage de la liste des commentaires
          public List<CommentaireService> findCommentaireByService(int id){
            List<CommentaireService> listComS=new ArrayList<>();
            String requete = "select * from CommentaireService where service_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            
             User us=new User();
             UserDAO usdao=new UserDAO();
             ServiceDao ser= new ServiceDao();
            while (resultat.next()) {   
                CommentaireService com = new CommentaireService();
                com.setCommentaire(resultat.getString(4));
                com.setUser(usdao.findUserById(resultat.getInt(3)));
                com.setId(resultat.getInt(1));
                com.setService(ser.findServiceById(id));
                listComS.add(com);
            }
             for(int i=0;i<listComS.size();i++){
                 System.out.println(listComS.get(i).getId());
             }
           return listComS; 
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
       
      }
         }
    
      
    
    
   
}
