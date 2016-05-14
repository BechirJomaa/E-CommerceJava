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
public class LigneCommande {
    private int id;
    private Panier panier;
    private Produit produit;
    private int qte;

    public LigneCommande() {
    }

    public LigneCommande(Panier panier, Produit produit, int qte) {
        this.panier = panier;
        this.produit = produit;
        this.qte = qte;
    }

    public LigneCommande(int id, Panier panier, Produit produit, int qte) {
        this.id = id;
        this.panier = panier;
        this.produit = produit;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    
    
    
}
