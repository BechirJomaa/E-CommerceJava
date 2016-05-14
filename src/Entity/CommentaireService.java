/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDate;
import java.sql.Date;



/**
 *
 * @author jomaa
 */
public class CommentaireService {
    private int id;
    private String commentaire;
    private  Date dateComm;
    private User user;
    private Service service;

    public CommentaireService() {
        this.dateComm=java.sql.Date.valueOf(LocalDate.now());
    }

    public CommentaireService(int id, String commentaire, User user, Service service) {
        this.id = id;
        this.commentaire = commentaire;
        this.user = user;
        this.service = service;
    }

    public CommentaireService(String commentaire, User user, Service service) {
        this.commentaire = commentaire;
        this.user = user;
        this.service = service;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateComm(Date dateComm) {
        this.dateComm = dateComm;
    }
    

    public Date getDateComm() {
        return this.dateComm;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final CommentaireService other = (CommentaireService) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommentaireService{" + "id=" + id + ", commentaire=" + commentaire + ", user=" + user + ", service=" + service + '}';
    }
    
    
    
    
    
    
}
