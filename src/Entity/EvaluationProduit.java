/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author gafsi
 */
public class EvaluationProduit {
    private int id;
    private int rating;
    private User user;
    private Produit produit;

    public EvaluationProduit() {
    }

    public EvaluationProduit(int id, int note, User user, Produit produit) {
        this.id = id;
        this.rating = note;
        this.user = user;
        this.produit = produit;
    }

    public EvaluationProduit(int note, User user, Produit produit) {
        this.rating = note;
        this.user = user;
        this.produit = produit;
    }

    public int getId() {
        return id;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int note) {
        this.rating = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final EvaluationProduit other = (EvaluationProduit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluationprod{" + "id=" + id + ", note=" + rating + ", user=" + user + ", produit=" + produit + '}';
    }
    
    
    
}
