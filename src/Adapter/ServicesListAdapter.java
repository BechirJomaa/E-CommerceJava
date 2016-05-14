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
import javax.swing.AbstractListModel;

/**
 *
 * @author gafsi
 */
public class ServicesListAdapter extends AbstractListModel {

    private List<Service> services = new ArrayList<>();
    private  List<Integer> sujetId=new ArrayList<Integer>();
    
    public ServicesListAdapter(List<Service> l) {
        services=l;
    }

    public  List<Integer> getSujetId() {
        return sujetId;
    }

    
    @Override
    public int getSize() {
        return services.size();
    }

    @Override
    public Object getElementAt(int index) {
        if(index!=-1)
        sujetId.add(services.get(index).getId());
        return services.get(index).getNom();
    }
    
    
}
