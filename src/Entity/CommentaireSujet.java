/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author jomaa
 */
public class CommentaireSujet {
    private int id;
    private String commentaire;
    private User user;
    private Sujet sujet;
    private Date dateComm;

    public CommentaireSujet(int id, String commentaire, User user, Sujet sujet) {
        this.id = id;
        this.commentaire = commentaire;
        this.user = user;
        this.sujet = sujet;
        this.dateComm=Date.valueOf(LocalDate.now());
        
    }

    public CommentaireSujet() {
         this.dateComm=Date.valueOf(LocalDate.now());
    }

    public CommentaireSujet(String commentaire, User user, Sujet sujet) {
        this.commentaire = commentaire;
        this.user = user;
        this.sujet = sujet;
    }
    
    

    public int getId() {
        return id;
    }

public void setId(int id){
    this.id=id;
}

    public Date getDateComm() {
        return dateComm;
    }

    public void setDateComm(Date dateComm) {
        this.dateComm = dateComm;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    @Override
    public String toString() {
        return "CommentaireSujet{" + "id=" + id + ", commentaire=" + commentaire + ", user=" + user + ", sujet=" + sujet + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommentaireSujet other = (CommentaireSujet) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}