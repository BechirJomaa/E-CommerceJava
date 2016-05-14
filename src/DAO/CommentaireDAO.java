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

public class CommentaireDAO {

    private Connection connection;

    public CommentaireDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addCommentaire(Commentaire com) {
        try {
            String req = "insert into Commentaire (corps,dateCom,user_id,produit_id) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, com.getCorps());
            ps.setDate(2, com.getDateComm());
            ps.setInt(3, com.getUser().getId());
            ps.setInt(4, com.getProduit().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeCommentaireById(int id) {
        Commentaire com = new Commentaire();
        String requete = "DELETE FROM Commentaire WHERE id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Commentaire supprimé");

        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public void updateCommentaire(Commentaire com) {
        String requete = "update Commentaire set corps=?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setString(1, com.getCorps());
            ps.setInt(2, com.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    //Affichage de la liste des commentaires
    public List<Commentaire> findCommentaireByProduit(int id) {
        List<Commentaire> listComS = new ArrayList<>();
        String requete = "select * from Commentaire where produit_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();

            ProduitDAO prod = new ProduitDAO();
            while (resultat.next()) {
                Commentaire com = new Commentaire();
                com.setCorps(resultat.getString(2));
                com.setUser(new UserDAO().findUserById(resultat.getInt(5)));
                com.setId(resultat.getInt(1));
                com.setProduit(prod.findProduitById(resultat.getInt(4)));
                com.setDateComm(resultat.getDate("dateCom"));
                listComS.add(com);
            }

            return listComS;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;

        }
    }

}
