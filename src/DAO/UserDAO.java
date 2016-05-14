/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.*;
import Utile.Password;
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
 * @author Dridi
 */
public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public User findUserById(int id) {
        User user = new User();
        String requete = "select * from user where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                user.setId(resultat.getInt(1));
                user.setUsername(resultat.getString(2));
                user.setEmail(resultat.getString(4));
                user.setEnabled(resultat.getBoolean("enabled"));
                user.setPanier(new PanierDAO().findPanierById(resultat.getInt("panier_id")));
//                if(new FavorisDAO().findProduitsByFavorisId(resultat.getInt("favoris_id"))==null)
                user.setFavoris(new FavorisDAO().findFavorisById(resultat.getInt("favoris_id")));
//                else
 //               user.setFavoris(new FavorisDAO().findProduitsByFavorisId(resultat.getInt("favoris_id")));

            }
            return user;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }

    }
     public User findUserByUserName(String userName) {
        User user = new User();
        String requete = "select * from user where username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, userName);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                user.setId(resultat.getInt(1));
                user.setUsername(resultat.getString(2));
                user.setEmail(resultat.getString(4));
                user.setEnabled(resultat.getBoolean("enabled"));
                user.setPanier(new PanierDAO().findPanierById(resultat.getInt("panier_id")));
//                if(new FavorisDAO().findProduitsByFavorisId(resultat.getInt("favoris_id"))==null)
                user.setFavoris(new FavorisDAO().findFavorisById(resultat.getInt("favoris_id")));
//                else
      //          user.setFavoris(new FavorisDAO().findProduitsByFavorisId(resultat.getInt("favoris_id")));

            }
            return user;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }

    }

    public boolean insert(User t) {
        String req
                = "insert into user (username,email,salt,password,username_canonical,email_canonical,"
                + "roles,enabled,locked) values( ?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getEmail());
            String password = t.getPassword();
            pst.setString(4, Password.hashPassword(password));
            pst.setString(3, Password.saltPass.substring(7));
            pst.setString(6, t.getEmail());
            pst.setString(7, "a:0:{}");
            pst.setString(5, t.getUsername());
            pst.setBoolean(8, true);
            pst.setBoolean(9, false);
            int executeUpdate = pst.executeUpdate();
            User user=new User();
            user=findUserByUserName(t.getUsername());
            new PanierDAO().addPanier(user.getId());
            new FavorisDAO().addFavoris(user.getId());  
            user.setPanier(new PanierDAO().findPanierById(user.getId()));
            user.setFavoris(new FavorisDAO().findFavorisById(user.getId()));
            user.setPassword(t.getPassword());
            updateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

    public boolean login(String login, String password, User user) {
        String codeCrypter = Password.hashPasswordWithSalt(password, "$2y$13$"+user.getSalt());
        return user.getPassword().equals(codeCrypter);
    }

    public User getUserByUserName(String userName) {
        User user =null;
        String req = "select * from user where username=?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, userName);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                user=new User();
                //   user.setDateNaiss( resultat.getDate("dateNaiss"));   Problem :/
                user.setEmail(resultat.getString("email"));
                user.setEnabled(resultat.getBoolean("enabled"));
                user.setId(resultat.getInt("id"));
                user.setPassword(resultat.getString("password"));
                user.setSalt(resultat.getString("salt"));
                user.setPanier(new PanierDAO().findPanierById(resultat.getInt("panier_id")));
               // if(new FavorisDAO().findProduitsByFavorisId(resultat.getInt("favoris_id"))==null)
                user.setFavoris(new FavorisDAO().findFavorisById(resultat.getInt("favoris_id")));
//                else
//                user.setFavoris(new FavorisDAO().findProduitsByFavorisId(resultat.getInt("favoris_id")));
                

            }
            return user;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
     public User getUserByEmail(String email) {
        User user =null;
        String req = "select * from user where username=?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, email);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {
                user=new User();
                //   user.setDateNaiss( resultat.getDate("dateNaiss"));   Problem :/
                user.setEmail(resultat.getString("email"));
                user.setEnabled(resultat.getBoolean("enabled"));
                user.setId(resultat.getInt("id"));
                user.setPassword(resultat.getString("password"));
                user.setSalt(resultat.getString("salt"));
                user.setPanier(new PanierDAO().findPanierById(resultat.getInt("panier_id")));
                user.setFavoris(new FavorisDAO().findFavorisById(resultat.getInt("favoris_id")));

            }
            return user;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    public void DEsactiver(User user){
         String requete = "update user set enabled=?  where id=?";
         String password = user.getPassword();
             try {
            PreparedStatement pst = connection.prepareStatement(requete);            pst.setBoolean(1, user.isEnabled());
            pst.setInt(2, user.getId());
            pst.executeUpdate();
                 System.out.println("activer");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    public void updateUser(User user){
         String requete = "update user set salt=? , password=?  ,panier_id=?, favoris_id=? where id=?";
         String password = user.getPassword();
             try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(2, Password.hashPassword(password));
            pst.setString(1, Password.saltPass.substring(7));
            pst.setInt(3, user.getId());
            pst.setInt(4, user.getId());
            pst.setInt(5, user.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
     public void removeUserById(int id){
             String requete = "delete from user where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("user supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        }
       public List<User> findAll() {
        List<User> listUser=new ArrayList<>();
        
        String requete = "select * from user order by username";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                User user = new User();
                user.setId(resultat.getInt(1));
                user.setUsername(resultat.getString(2));
                user.setEmail(resultat.getString(4));
                listUser.add(user);
                System.out.println(user.getId());

            }
            
            return listUser;
            

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }

    }

    
}
