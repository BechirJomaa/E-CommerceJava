/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DAO.*;
import Entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gafsi
 */
public class PanierDisplay extends javax.swing.JFrame {

    /**
     * Creates new form PanierDisplay
     */
    private List<Integer> listId;
    private List<LigneCommande> llc;
    public PanierDisplay() {
        initComponents();
        loadProd();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbProduits = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnCommande = new javax.swing.JButton();
        cbQuantite = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAchat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbProduits.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProduitsItemStateChanged(evt);
            }
        });
        cbProduits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProduitsActionPerformed(evt);
            }
        });

        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCommande.setText("Passer la commande");
        btnCommande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommandeActionPerformed(evt);
            }
        });

        cbQuantite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Quantité");

        btnAchat.setText("continuer mes achats");
        btnAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAchatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(cbQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(cbProduits, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAchat)
                        .addGap(92, 92, 92)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCommande)
                    .addComponent(jButton1))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProduits, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(cbQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommande)
                    .addComponent(btnAchat))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PanierDAO panierDAO=new PanierDAO();
        LigneCommandeDAO lcDAO=new LigneCommandeDAO();
        lcDAO.removeLigneCommandeById(llc.get(cbProduits.getSelectedIndex()).getId());
        cbQuantite.setSelectedItem(llc.get(0).getQte());
        loadProd();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbProduitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProduitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProduitsActionPerformed

    private void cbProduitsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProduitsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProduitsItemStateChanged

    private void btnAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAchatActionPerformed
        // TODO add your handling code here:
        dispose();
        FavorisAdd f=new FavorisAdd();
        f.setVisible(true);
    }//GEN-LAST:event_btnAchatActionPerformed

    private void btnCommandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommandeActionPerformed
        // TODO add your handling code here:
        dispose();
        AdresseAdd a=new AdresseAdd();
        a.setVisible(true);
    }//GEN-LAST:event_btnCommandeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanierDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanierDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanierDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanierDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanierDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAchat;
    private javax.swing.JButton btnCommande;
    private javax.swing.JComboBox cbProduits;
    private javax.swing.JComboBox cbQuantite;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
private void loadProd(){
    cbProduits.removeAllItems();
    listId=new ArrayList<>();
    llc=new ArrayList<>();
        PanierDAO panierDAO=new PanierDAO();
        Panier panier=new Panier();
        panier=panierDAO.findPanierById(1);
        LigneCommandeDAO lcDAO=new LigneCommandeDAO();
        LigneCommande lc=new LigneCommande();
        llc=lcDAO.findLigneCommandByPanier( 1);
        for(LigneCommande produit : llc){
             cbProduits.addItem(produit.getProduit().getNom());
             listId.add(produit.getId());
             cbQuantite.setSelectedIndex(produit.getQte()-1);
             System.out.println(produit.toString());
        }
        if(llc.size()==0)
            cbQuantite.setSelectedIndex(0);

}
}
