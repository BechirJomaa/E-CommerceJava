
package DAO;

import Entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;



public class CommentaireSujetDAO  {
    
    

      private Connection connection;

    public CommentaireSujetDAO() {
        
        connection = DataSource.getInstance().getConnection();
    }

         
       //Ajout commentaire
       public void addCommentaire(CommentaireSujet com) {
        try {
            String req = "insert into CommentaireSujet (sujet_id,user_id,commentaire,dateCom ) values (? , ? ,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, com.getSujet().getId());
            ps.setInt(2, com.getUser().getId());
            ps.setString(3, com.getCommentaire());
            ps.setDate(4, com.getDateComm());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
      
      
       
       
         public void updateCommentaire(CommentaireSujet com) {
        String requete = "update CommentaireSujet set sujet_id=? ,user_id=?, commentaire=?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           ps.setInt(1, com.getSujet().getId());
            ps.setInt(2, com.getUser().getId());
             ps.setString(3, com.getCommentaire());
             ps.setInt(4, com.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
       }
       
       //Supprimer commentaire
       public void removeCommentaireById(int id ) {
            Commentaire com =new Commentaire();
              String requete = "DELETE FROM CommentaireSujet WHERE id=?";
            
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
        
      public CommentaireSujet findCommentaireById(int id){
          
            String requete = "select * from CommentaireSujet where id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            CommentaireSujet com = new CommentaireSujet();
            
             User us=new User();
             UserDAO usdao=new UserDAO();
            while (resultat.next()) {
//               us=usdao.findUserById(resultat.getInt(2));
//                sjt.setUser(us);
                com.setCommentaire(resultat.getString(4));
                com.setUser(usdao.findUserById(resultat.getInt(3)));
                com.setSujet(new SujetDAO().findSujetById(resultat.getInt(2)));
                com.setId(resultat.getInt(1));
                
                
            }
           return com; 
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
      }
         public List<CommentaireSujet> findCommentaireBySujet(int id){
            List<CommentaireSujet> listCom=new ArrayList<>();
            String requete = "select * from CommentaireSujet where sujet_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            
             User us=new User();
             UserDAO usdao=new UserDAO();
            while (resultat.next()) {
                CommentaireSujet com = new CommentaireSujet();
                com.setCommentaire(resultat.getString(4));
                com.setUser(usdao.findUserById(resultat.getInt(3)));
                com.setSujet(new SujetDAO().findSujetById(resultat.getInt(2)));
                com.setId(resultat.getInt(1));
                listCom.add(com);
            }
             for(int i=0;i<listCom.size();i++){
                 System.out.println(listCom.get(i).getId());
             }
           return listCom; 
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
       
      }
         }
    
      
    
}
