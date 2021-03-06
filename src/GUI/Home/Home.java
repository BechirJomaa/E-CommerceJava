/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Home;

import DAO.LigneCommandeDAO;
import DAO.UserDAO;
import Entity.Favoris;
import Entity.LigneCommande;
import Entity.Panier;
import Entity.Produit;
import GUI.AboutUs.PanelAboutUs;
import GUI.Cantact.PanelCantact;
import GUI.Favoris.PanelFavoris;
import GUI.Forum.PanelForum;
import GUI.Panier.PanelPanier;
import GUI.Profile.PanelUserProfile;
import GUI.Services.PanelServices;
import java.awt.Color;
import java.awt.Cursor;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author gafsi
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private static int userId;
    
    public Home(int userId) {
        this.userId = userId;
        initComponents();
        setBounds(0, 0, 1366, 768);
        panier();
        Favoris f=new UserDAO().findUserById(userId).getFavoris();

        
        


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        btnDeconnect = new javax.swing.JLabel();
        btnCompte = new javax.swing.JLabel();
        btnAccueil = new javax.swing.JLabel();
        btnProducts = new javax.swing.JLabel();
        btnServices = new javax.swing.JLabel();
        btnForum = new javax.swing.JLabel();
        btnCantact = new javax.swing.JLabel();
        btnAboutUs = new javax.swing.JLabel();
        btnAppelDoffre = new javax.swing.JLabel();
        btnMinimise = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        lPanierCount = new javax.swing.JLabel();
        btnPanier = new javax.swing.JLabel();
        btnFavoris = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        container.setForeground(new java.awt.Color(51, 51, 51));
        container.setAlignmentX(0.0F);
        container.setAlignmentY(0.0F);
        container.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(container);
        container.setBounds(31, 216, 1311, 520);

        btnDeconnect.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDeconnect.setForeground(new java.awt.Color(255, 255, 255));
        btnDeconnect.setText("Se déconnecter");
        getContentPane().add(btnDeconnect);
        btnDeconnect.setBounds(1080, 10, 90, 30);

        btnCompte.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCompte.setForeground(new java.awt.Color(255, 255, 255));
        btnCompte.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dridi\\Desktop\\PI\\syrine\\AllForDeal\\images\\icon-admin.png")); // NOI18N
        btnCompte.setText("Compte");
        btnCompte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCompteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCompteMouseExited(evt);
            }
        });
        getContentPane().add(btnCompte);
        btnCompte.setBounds(1200, 10, 90, 30);

        btnAccueil.setBackground(new java.awt.Color(102, 153, 255));
        btnAccueil.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnAccueil.setForeground(new java.awt.Color(255, 255, 255));
        btnAccueil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAccueil.setText("Accueil");
        btnAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAccueilMouseClicked(evt);
            }
        });
        getContentPane().add(btnAccueil);
        btnAccueil.setBounds(40, 150, 80, 30);

        btnProducts.setBackground(new java.awt.Color(102, 153, 255));
        btnProducts.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProducts.setText("Produis");
        btnProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductsMouseClicked(evt);
            }
        });
        getContentPane().add(btnProducts);
        btnProducts.setBounds(160, 150, 80, 30);

        btnServices.setBackground(new java.awt.Color(102, 153, 255));
        btnServices.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnServices.setForeground(new java.awt.Color(255, 255, 255));
        btnServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnServices.setText("Services");
        btnServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServicesMouseClicked(evt);
            }
        });
        getContentPane().add(btnServices);
        btnServices.setBounds(290, 150, 80, 30);

        btnForum.setBackground(new java.awt.Color(102, 153, 255));
        btnForum.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnForum.setForeground(new java.awt.Color(255, 255, 255));
        btnForum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnForum.setText("Forum");
        btnForum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForumMouseClicked(evt);
            }
        });
        getContentPane().add(btnForum);
        btnForum.setBounds(600, 150, 80, 30);

        btnCantact.setBackground(new java.awt.Color(102, 153, 255));
        btnCantact.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnCantact.setForeground(new java.awt.Color(255, 255, 255));
        btnCantact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCantact.setText("Contact");
        btnCantact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCantactMouseClicked(evt);
            }
        });
        getContentPane().add(btnCantact);
        btnCantact.setBounds(730, 150, 80, 30);

        btnAboutUs.setBackground(new java.awt.Color(102, 153, 255));
        btnAboutUs.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnAboutUs.setForeground(new java.awt.Color(255, 255, 255));
        btnAboutUs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAboutUs.setText("About us");
        btnAboutUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAboutUsMouseClicked(evt);
            }
        });
        getContentPane().add(btnAboutUs);
        btnAboutUs.setBounds(830, 150, 80, 30);

        btnAppelDoffre.setBackground(new java.awt.Color(102, 153, 255));
        btnAppelDoffre.setFont(new java.awt.Font("MingLiU_HKSCS", 1, 14)); // NOI18N
        btnAppelDoffre.setForeground(new java.awt.Color(255, 255, 255));
        btnAppelDoffre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAppelDoffre.setText("Appel d'offre");
        btnAppelDoffre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAppelDoffreMouseClicked(evt);
            }
        });
        getContentPane().add(btnAppelDoffre);
        btnAppelDoffre.setBounds(420, 150, 120, 30);

        btnMinimise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimiseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimiseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimiseMouseExited(evt);
            }
        });
        getContentPane().add(btnMinimise);
        btnMinimise.setBounds(1300, 10, 30, 20);
        btnMinimise.getAccessibleContext().setAccessibleName("btnMinimise");

        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnClose.setAlignmentY(0.0F);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnClose.setIconTextGap(10);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(1330, 10, 30, 20);

        lPanierCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lPanierCount.setForeground(new java.awt.Color(255, 0, 0));
        lPanierCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPanierCount.setText("0");
        getContentPane().add(lPanierCount);
        lPanierCount.setBounds(1230, 60, 30, 20);

        btnPanier.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dridi\\Desktop\\PI\\syrine\\AllForDeal\\images\\icon-panier.png")); // NOI18N
        btnPanier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPanierMouseClicked(evt);
            }
        });
        getContentPane().add(btnPanier);
        btnPanier.setBounds(1240, 60, 80, 70);

        btnFavoris.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dridi\\Desktop\\PI\\syrine\\AllForDeal\\images\\icon-favoris.png")); // NOI18N
        btnFavoris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFavorisMouseClicked(evt);
            }
        });
        getContentPane().add(btnFavoris);
        btnFavoris.setBounds(1130, 60, 80, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dridi\\Desktop\\PI\\syrine\\AllForDeal\\images\\AllForDeal.jpg")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        // TODO add your handling code here:
        btnClose.setIcon(new ImageIcon("images\\closeEntred.png"));
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setIcon(new ImageIcon("images\\close.png"));

    }//GEN-LAST:event_btnCloseMouseExited

    private void btnMinimiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimiseMouseClicked
        // TODO add your handling code here:
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimiseMouseClicked

    private void btnMinimiseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimiseMouseEntered
        // TODO add your handling code here:
        btnMinimise.setIcon(new ImageIcon("images\\minimiseEntred.png"));

    }//GEN-LAST:event_btnMinimiseMouseEntered

    private void btnMinimiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimiseMouseExited
        // TODO add your handling code here
        btnMinimise.setIcon(new ImageIcon("images\\minimise.png"));

    }//GEN-LAST:event_btnMinimiseMouseExited

    private void btnAccueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccueilMouseClicked
        // TODO add your handling code here:
        //  btnAccueil.setBackground(new Color(67, 149, 198));
        btnAccueil.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        btnProducts.setBorder(null);
        btnServices.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnForum.setBorder(null);
        btnCantact.setBorder(null);
        btnAboutUs.setBorder(null);
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelAcceuil());
    }//GEN-LAST:event_btnAccueilMouseClicked

    private void btnProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelProduits(userId,lPanierCount));
        btnAccueil.setBorder(null);
        btnServices.setBorder(null);
        btnForum.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnCantact.setBorder(null);
        btnAboutUs.setBorder(null);
        btnProducts.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));

    }//GEN-LAST:event_btnProductsMouseClicked

    private void btnServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicesMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelServices(userId));
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnForum.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnServices.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));

    }//GEN-LAST:event_btnServicesMouseClicked

    private void btnForumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForumMouseClicked
        // TODO add your handling code here:
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnServices.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnCantact.setBorder(null);
        btnAboutUs.setBorder(null);
        btnForum.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelForum(userId));

    }//GEN-LAST:event_btnForumMouseClicked

    private void btnCompteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompteMouseClicked
        // TODO add your handling code here:
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnServices.setBorder(null);
        btnForum.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnCantact.setBorder(null);
        btnAboutUs.setBorder(null);
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelUserProfile(userId));

    }//GEN-LAST:event_btnCompteMouseClicked

    private void btnCompteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompteMouseEntered
        // TODO add your handling code here:
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCompte.setForeground(Color.blue);

    }//GEN-LAST:event_btnCompteMouseEntered

    private void btnCompteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompteMouseExited
        // TODO add your handling code here:
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        btnCompte.setForeground(Color.white);
    }//GEN-LAST:event_btnCompteMouseExited

    private void btnAppelDoffreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAppelDoffreMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        //container.add(new PanelServices(userId));     
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnForum.setBorder(null);
        btnServices.setBorder(null);
        btnCantact.setBorder(null);
        btnAboutUs.setBorder(null);
        btnAppelDoffre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
    }//GEN-LAST:event_btnAppelDoffreMouseClicked

    private void btnPanierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanierMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelPanier(userId,lPanierCount));     
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnForum.setBorder(null);
        btnServices.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnCantact.setBorder(null);
        
    }//GEN-LAST:event_btnPanierMouseClicked

    private void btnFavorisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFavorisMouseClicked
//        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelFavoris(userId,lPanierCount));     
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnForum.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnServices.setBorder(null);
        btnAboutUs.setBorder(null);
        btnCantact.setBorder(null);
    }//GEN-LAST:event_btnFavorisMouseClicked

    private void btnCantactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCantactMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelCantact(userId));     
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnForum.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnServices.setBorder(null);
        btnAboutUs.setBorder(null);
        btnCantact.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
    }//GEN-LAST:event_btnCantactMouseClicked

    private void btnAboutUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutUsMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(new PanelAboutUs(userId,this));     
        btnAccueil.setBorder(null);
        btnProducts.setBorder(null);
        btnForum.setBorder(null);
        btnAppelDoffre.setBorder(null);
        btnServices.setBorder(null);
        btnCantact.setBorder(null);
        btnAboutUs.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
    }//GEN-LAST:event_btnAboutUsMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAboutUs;
    private javax.swing.JLabel btnAccueil;
    private javax.swing.JLabel btnAppelDoffre;
    private javax.swing.JLabel btnCantact;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnCompte;
    private javax.swing.JLabel btnDeconnect;
    private javax.swing.JLabel btnFavoris;
    private javax.swing.JLabel btnForum;
    private javax.swing.JLabel btnMinimise;
    private javax.swing.JLabel btnPanier;
    private javax.swing.JLabel btnProducts;
    private javax.swing.JLabel btnServices;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lPanierCount;
    // End of variables declaration//GEN-END:variables
public  void panier(){
    Panier panier=new Panier();
    panier=new UserDAO().findUserById(userId).getPanier();
    List<LigneCommande> ligneCommands=new LigneCommandeDAO().findLigneCommandByPanier(panier.getId());
    lPanierCount.setText(""+ligneCommands.size());
}
}
