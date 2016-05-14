/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapter;

import Entity.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author gafsi
 */
public class ProductsListAdapter extends AbstractListModel {

    private List<Produit> produits = new ArrayList<>();
    private  List<Integer> produittId=new ArrayList<Integer>();
    
    public ProductsListAdapter(List<Produit> l) {
        produits=l;
    }

    public  List<Integer> getProduitId() {
        return produittId;
    }

    
    @Override
    public int getSize() {
        return produits.size();
    }

    @Override
    public Object getElementAt(int index) {
        if(index!=-1)
        produittId.add(produits.get(index).getId());
        return produits.get(index).getNom();
    }
    
    
}
