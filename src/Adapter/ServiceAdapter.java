/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import DAO.ServiceDao;
import Entity.Service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MBII
 */
public class ServiceAdapter extends AbstractTableModel {

    String[] headers = {"Categorie", "Nom", "Description", "Adresse", "Mail", "Telephone", "Estimation","Valider"};
    List<Service> produits = new ArrayList<>();
    ServiceDao s;
    private static List<Integer> sujetId=new ArrayList<Integer>();
    public ServiceAdapter(int userId) {

        s = new ServiceDao();
        produits = s.findByUser(userId);

    }

    public static void setSujetId(List<Integer> sujetId) {
        ServiceAdapter.sujetId = sujetId;
    }

    public static List<Integer> getSujetId() {
        return sujetId;
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

        switch (columnIndex) {
            case 0:
                sujetId.add(produits.get(rowIndex).getId());
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
                if(produits.get(rowIndex).getValider()==1)
                return "oui";
                return "non";
           
            default:
                return null;
        }
    }

}
