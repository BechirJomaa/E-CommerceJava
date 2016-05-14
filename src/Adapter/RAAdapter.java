/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapter;

import ClassesDao.AppeldoffreDao;
import Gui.RechercherA;
import entities.Appeldoffre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MBII
 */
public class RAAdapter extends AbstractTableModel {
        String[] headers = { "Nom", "Description", "Adresse", "Mail", "Telephone"};
List <Appeldoffre>  produits = new ArrayList<>();
AppeldoffreDao s;
public RAAdapter(String nom){
s= new AppeldoffreDao  ();
produits=s.findbynom(nom);

}
  @Override
    public int getRowCount() {
       return produits.size();
    }

    @Override
    public int getColumnCount() {
            return headers.length;
    }
    @Override
    public String getColumnName(int i) {
        return headers[i];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      
          switch  (columnIndex) {
          
            case 0:
                return produits.get(rowIndex).getNom();
            case 1:
                return produits.get(rowIndex).getDescription();
            case 2:
                return produits.get(rowIndex).getAdresse();
            case 3:
                return produits.get(rowIndex).getMail();
            case 4:
                return produits.get(rowIndex).getTelephone();
        
         
            default:
                return null;
        }
    }
}
