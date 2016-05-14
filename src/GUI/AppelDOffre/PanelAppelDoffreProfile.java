/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AppelDOffre;

import Adapter.ApAdapter;
import Adapter.ServiceAdapter;
import DAO.AppeldoffreDao;
import DAO.ServiceDao;
import DAO.UserDAO;
import Entity.Appeldoffre;
import Entity.Service;
import Entity.User;
import GUI.Services.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gafsi
 */
public class PanelAppelDoffreProfile extends javax.swing.JPanel {

    /**
     * Creates new form PanelServicesProfile
     */
    private User user;
    private List<Appeldoffre> listAppelDofre=new ArrayList<Appeldoffre>();
    public PanelAppelDoffreProfile(int userId) {
        user = new UserDAO().findUserById(userId);
        initComponents();
        loadServices();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabAppelDoffre = new javax.swing.JTable();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tabAppelDoffre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabAppelDoffre.setRowHeight(50);
        tabAppelDoffre.setRowMargin(10);
        jScrollPane1.setViewportView(tabAppelDoffre);

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAjouter)
                        .addGap(18, 18, 18)
                        .addComponent(btnModifier)
                        .addGap(18, 18, 18)
                        .addComponent(btnSupprimer)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter)
                    .addComponent(btnModifier)
                    .addComponent(btnSupprimer))
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
        new DialogueAjouterService(null, true, user.getId()).setVisible(true);
        tabAppelDoffre.setModel(new ApAdapter(listAppelDofre)); 

    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // TODO add your handling code here:
        if (tabAppelDoffre.getSelectedRow() != -1) {
            Service s = new ServiceDao().findServiceById(listAppelDofre.get(tabAppelDoffre.getSelectedRow()).getId());
            new DialogueModifierService(null, true, s.getId()).setVisible(true);
            tabAppelDoffre.setModel(new ApAdapter(listAppelDofre)); 
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        // TODO add your handling code here:
        if (tabAppelDoffre.getSelectedRow() != -1) {
            Service s = new ServiceDao().findServiceById(listAppelDofre.get(tabAppelDoffre.getSelectedRow()).getId());
            new ServiceDao().removeServiceById(s.getId());
            tabAppelDoffre.setModel(new ApAdapter(listAppelDofre)); 
    }
    }//GEN-LAST:event_btnSupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabAppelDoffre;
    // End of variables declaration//GEN-END:variables
private void loadServices() {
    listAppelDofre=new AppeldoffreDao().findbyUser(user.getId());
        tabAppelDoffre.setModel(new ApAdapter(listAppelDofre));
    }
}