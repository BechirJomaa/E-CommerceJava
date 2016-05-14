/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapter;

import ClassesDao.ServiceDao;
import Gui.Ch;
import Gui.ConsulterS;
import entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MBII
 */
public class ChAdapter  extends AbstractTableModel {
    String[] headers = {"Categorie", "Nom", "Description", "Adresse", "Mail", "Telephone", "Estimation",  "Modfier", "Supprimer"};
    List<Service> produits = new ArrayList<>();
    ServiceDao s;
    public ChAdapter (String q)
    {
        
     
    s= new ServiceDao();
     produits = s.findbyCategorie(q);
    
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
                return produits.get(rowIndex).getCategorie().getId();
            case 1:
                return produits.get(rowIndex).getNom();
            case 2:
                return produits.get(rowIndex).getDescription();
            case 3:
                return produits.get(rowIndex).getAdresse();
            case 4:
                return produits.get(rowIndex).getMail();
            case 5:
                return produits.get(rowIndex).getTelephone();
            case 6:
                return produits.get(rowIndex).getEstimation();
             case 7:
                return "modifier";
            case 8:
                return "supprimer";
            default:
                return null;
        }
    }
    
}
