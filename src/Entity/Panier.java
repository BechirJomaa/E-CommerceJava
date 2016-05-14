/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gafsi
 */
public class Panier {
    private int id;

    public Panier() {
    }

    public Panier(int id) {
        this.id = id;
      
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }






    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Panier other = (Panier) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + '}';
    }
    
    
}
