/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import DAO.AppeldoffreDao;
import Entity.Appeldoffre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MBII
 */
public class ApAdapter extends AbstractTableModel {

    String[] headers = {"Nom", "Description", "Adresse", "Mail", "Telephone"};
    List<Appeldoffre> appelDoffre = new ArrayList<>();
    AppeldoffreDao s;

    public ApAdapter(List<Appeldoffre> l) {
        s = new AppeldoffreDao();
        appelDoffre = l;

    }

    @Override
    public int getRowCount() {
        return appelDoffre.size();
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
                return appelDoffre.get(rowIndex).getNom();
            case 1:
                return appelDoffre.get(rowIndex).getDescription();
            case 2:
                return appelDoffre.get(rowIndex).getAdresse();
            case 3:
                return appelDoffre.get(rowIndex).getMail();
            case 4:
                return appelDoffre.get(rowIndex).getTelephone();

            default:
                return null;
        }
    }
}
