/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapter;

import ClassesDao.CategorieServiceDao;
import entities.CategorieService;
import entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MBII
 */
public class CategorieSAdapter extends AbstractTableModel {
    
    String[] headers = {"Categorie", "Description"};
     List<CategorieService> produits = new ArrayList<>();
            CategorieServiceDao s;
            public CategorieSAdapter(String id)
            {
             s= new CategorieServiceDao();
          produits=   s.findAll1(id);
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
                return produits.get(rowIndex).getId();
          
            case 1:
                return produits.get(rowIndex).getDescription();
          
            default:
                return null;
        }
    
    }}
