/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Home;

import DAO.CategorieDAO;
import DAO.ProduitDAO;
import DAO.UserDAO;
import Entity.Categorie;
import Entity.Produit;
import Entity.User;
import GUI.Produits.DialogueDetailProduit;
import GUI.Profile.DialogueDetailPublicite;
import Utile.AnimationThread;
import Utile.coucheMetier;
import com.alee.extended.image.WebImage;
import com.alee.extended.transition.ComponentTransition;
import com.alee.extended.transition.effects.Direction;
import com.alee.extended.transition.effects.blocks.BlockType;
import com.alee.extended.transition.effects.blocks.BlocksTransitionEffect;
import com.alee.laf.label.WebLabel;
import com.alee.utils.SwingUtils;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author gafsi
 */
public class PanelProduits extends javax.swing.JPanel {

    /**
     * Creates new form PanelProduits
     */
    private List<Produit> produits = new ProduitDAO().findProdValider();
    private List<JLabel> lImage = new ArrayList<>();
    private List<WebLabel> lDetails = new ArrayList<>();
    private List<JButton> btnPanier = new ArrayList<>();
    private User user;
    private List<Categorie> listCategorie = new CategorieDAO().findAll();
    private JLabel lPanierCount;
    AnimationThread thread;

    public PanelProduits(int userId,JLabel lPanierCount) {
        initComponents();
        this.lPanierCount=lPanierCount;
        user = new UserDAO().findUserById(userId); 
        loadProducts();
        loadAllCategories();
        loadTopCategories();
        publicite();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lCat5 = new javax.swing.JLabel();
        lCat1 = new javax.swing.JLabel();
        lCat2 = new javax.swing.JLabel();
        lCat3 = new javax.swing.JLabel();
        lCat4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelProduits = new javax.swing.JPanel();
        panelPublicité = new javax.swing.JPanel();
        lNom = new javax.swing.JLabel();
        lDate = new javax.swing.JLabel();
        lType = new javax.swing.JLabel();
        cbCatégories = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tfRechercher = new javax.swing.JTextField();
        btnRechercher = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        lCat5.setBackground(new java.awt.Color(255, 255, 255));
        lCat5.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        lCat5.setForeground(new java.awt.Color(102, 0, 0));
        lCat5.setText("       3otriya");
        lCat5.setOpaque(true);
        lCat5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCat5MouseClicked(evt);
            }
        });
        jPanel1.add(lCat5);
        lCat5.setBounds(0, 230, 150, 40);

        lCat1.setBackground(new java.awt.Color(255, 255, 255));
        lCat1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        lCat1.setForeground(new java.awt.Color(102, 0, 0));
        lCat1.setText("       Vetements");
        lCat1.setOpaque(true);
        lCat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCat1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lCat1MouseEntered(evt);
            }
        });
        jPanel1.add(lCat1);
        lCat1.setBounds(0, 70, 150, 40);

        lCat2.setBackground(new java.awt.Color(255, 255, 255));
        lCat2.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        lCat2.setForeground(new java.awt.Color(102, 0, 0));
        lCat2.setText("       Sport");
        lCat2.setOpaque(true);
        lCat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCat2MouseClicked(evt);
            }
        });
        jPanel1.add(lCat2);
        lCat2.setBounds(0, 110, 150, 40);

        lCat3.setBackground(new java.awt.Color(255, 255, 255));
        lCat3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        lCat3.setForeground(new java.awt.Color(102, 0, 0));
        lCat3.setText("       Electro-men");
        lCat3.setOpaque(true);
        lCat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCat3MouseClicked(evt);
            }
        });
        jPanel1.add(lCat3);
        lCat3.setBounds(0, 150, 150, 40);

        lCat4.setBackground(new java.awt.Color(255, 255, 255));
        lCat4.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        lCat4.setForeground(new java.awt.Color(102, 0, 0));
        lCat4.setText("       Informatique");
        lCat4.setOpaque(true);
        lCat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCat4MouseClicked(evt);
            }
        });
        jPanel1.add(lCat4);
        lCat4.setBounds(0, 190, 150, 40);

        jLabel6.setBackground(new java.awt.Color(255, 255, 230));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nos Top Catégories");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204)));
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 20, 140, 40);

        add(jPanel1);
        jPanel1.setBounds(10, 60, 150, 430);

        panelProduits.setBackground(new java.awt.Color(255, 255, 255));
        panelProduits.setLayout(null);
        add(panelProduits);
        panelProduits.setBounds(170, 60, 840, 430);

        panelPublicité.setBackground(new java.awt.Color(255, 255, 255));
        panelPublicité.setLayout(null);

        lNom.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        lNom.setForeground(new java.awt.Color(255, 51, 51));
        panelPublicité.add(lNom);
        lNom.setBounds(0, 0, 130, 30);

        lDate.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        lDate.setForeground(new java.awt.Color(255, 51, 51));
        panelPublicité.add(lDate);
        lDate.setBounds(0, 40, 130, 30);

        lType.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        lType.setForeground(new java.awt.Color(255, 51, 51));
        panelPublicité.add(lType);
        lType.setBounds(0, 80, 120, 30);

        add(panelPublicité);
        panelPublicité.setBounds(1030, 60, 270, 430);

        cbCatégories.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCatégoriesItemStateChanged(evt);
            }
        });
        add(cbCatégories);
        cbCatégories.setBounds(170, 20, 240, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Catégories");
        add(jLabel7);
        jLabel7.setBounds(20, 20, 140, 30);
        add(tfRechercher);
        tfRechercher.setBounds(730, 20, 240, 30);

        btnRechercher.setIcon(new javax.swing.ImageIcon("D:\\mes projets\\Java\\javaAllForDeal\\AllForDeal\\images\\icon-research.png")); // NOI18N
        btnRechercher.setPressedIcon(new javax.swing.ImageIcon("D:\\mes projets\\Java\\javaAllForDeal\\AllForDeal\\images\\icon-researchEntred.png")); // NOI18N
        btnRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherActionPerformed(evt);
            }
        });
        add(btnRechercher);
        btnRechercher.setBounds(970, 20, 30, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void lCat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCat1MouseClicked
        // TODO add your handling code here:
        if (lCat1.getText() != null) {
            inisializGrafic();
            lCat1.setBackground(new Color(204, 204, 204));
            produits = new coucheMetier().rechercherByCategorie(
                    new CategorieDAO().findcategorieByNom(lCat1.getText()).getId());
            panelProduits.removeAll();
            panelProduits.repaint();
            panelProduits.revalidate();
            cbCatégories.setSelectedItem(lCat1.getText());
            loadProducts();
        }
    }//GEN-LAST:event_lCat1MouseClicked

    private void lCat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCat2MouseClicked
        // TODO add your handling code here:
        if (lCat2.getText() != null) {
            inisializGrafic();
            lCat2.setBackground(new Color(204, 204, 204));
            produits = new coucheMetier().rechercherByCategorie(
                    new CategorieDAO().findcategorieByNom(lCat2.getText()).getId());
            panelProduits.removeAll();
            panelProduits.repaint();
            panelProduits.revalidate();
            cbCatégories.setSelectedItem(lCat2.getText());
            loadProducts();
        }
    }//GEN-LAST:event_lCat2MouseClicked

    private void lCat3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCat3MouseClicked
        // TODO add your handling code here:
        if (lCat3.getText() != null) {
            inisializGrafic();
            lCat3.setBackground(new Color(204, 204, 204));
            produits = new coucheMetier().rechercherByCategorie(
                    new CategorieDAO().findcategorieByNom(lCat3.getText()).getId());
            panelProduits.removeAll();
            panelProduits.repaint();
            panelProduits.revalidate();
            cbCatégories.setSelectedItem(lCat3.getText());
            loadProducts();
        }
    }//GEN-LAST:event_lCat3MouseClicked

    private void lCat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCat4MouseClicked
        // TODO add your handling code here:
        if (lCat4.getText() != null) {
            inisializGrafic();
            lCat4.setBackground(new Color(204, 204, 204));
            produits = new coucheMetier().rechercherByCategorie(
                    new CategorieDAO().findcategorieByNom(lCat4.getText()).getId());
            panelProduits.removeAll();
            panelProduits.repaint();
            panelProduits.revalidate();
            cbCatégories.setSelectedItem(lCat4.getText());
            loadProducts();
            
        }
    }//GEN-LAST:event_lCat4MouseClicked

    private void lCat5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCat5MouseClicked
        // TODO add your handling code here:
        if (lCat5.getText() != null) {
            inisializGrafic();
            panelProduits.removeAll();         
            panelProduits.repaint();        
            panelProduits.revalidate();
            lCat5.setBackground(new Color(204, 204, 204));
            produits = new coucheMetier().rechercherByCategorie(
                    new CategorieDAO().findcategorieByNom(lCat5.getText()).getId());
            cbCatégories.setSelectedItem(lCat5.getText());
            loadProducts();
        

        }
    }//GEN-LAST:event_lCat5MouseClicked

    private void lCat1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCat1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lCat1MouseEntered

    private void cbCatégoriesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCatégoriesItemStateChanged
        // TODO add your handling code here:
        if(cbCatégories.getSelectedIndex()!=0){
            inisializGrafic();
            panelProduits.removeAll();         
            panelProduits.repaint();        
            panelProduits.revalidate();
            produits = new coucheMetier().rechercherByCategorie(
                    new CategorieDAO().findcategorieByNom(cbCatégories.getSelectedItem().toString()).getId());
            loadProducts();
        }
        else{
            produits = new ProduitDAO().findProdValider();
            panelProduits.removeAll();         
            panelProduits.repaint();        
            panelProduits.revalidate();
            loadProducts();
            inisializGrafic();
        }
    }//GEN-LAST:event_cbCatégoriesItemStateChanged

    private void btnRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherActionPerformed
        // TODO add your handling code here:
         
            inisializGrafic();
           
            Produit p=new ProduitDAO().AffichagesProduitsbyNom(tfRechercher.getText());
            if(p!=null){
            produits=new ArrayList<>();
            produits.add(new ProduitDAO().AffichagesProduitsbyNom(tfRechercher.getText()));
            panelProduits.removeAll();
            panelProduits.repaint();
            panelProduits.revalidate();
           // cbCatégories.setSelectedItem(lCat1.getText());
            loadProducts();
            }
        
        
    }//GEN-LAST:event_btnRechercherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRechercher;
    private javax.swing.JComboBox cbCatégories;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lCat1;
    private javax.swing.JLabel lCat2;
    private javax.swing.JLabel lCat3;
    private javax.swing.JLabel lCat4;
    private javax.swing.JLabel lCat5;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lNom;
    private javax.swing.JLabel lType;
    private javax.swing.JPanel panelProduits;
    private javax.swing.JPanel panelPublicité;
    private javax.swing.JTextField tfRechercher;
    // End of variables declaration//GEN-END:variables
private void loadProducts() {
        int x = 20;
        int y = 20;
        lImage=new ArrayList<>();
        lDetails=new ArrayList<>();
        btnPanier=new ArrayList<>();
        for (int i = 0; i < produits.size(); i++) {
            if (i < 4) {
                String imagePath = "src\\com\\images\\" + produits.get(i).getNom() + ".png";
                ImageIcon icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
                        getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                lImage.add(new JLabel(icon1));
                //Ajout du details nom+prix
                lDetails.add(new WebLabel("" + produits.get(i).getNom() + "\t \t                " + produits.get(i).getPrix()));
                lDetails.get(i).setDrawShade(true);
                lDetails.get(i).setShadeColor(new Color(255, 128, 0));
                lDetails.get(i).setHorizontalAlignment(0);
                panelProduits.add(lDetails.get(i));
                lDetails.get(i).setBounds(x, y + 150, 150, 30);
//                //Ajout du boutton pour le panier
//                btnPanier.add(new JButton("Panier"));
//                panelProduits.add(btnPanier.get(i));
//                btnPanier.get(i).setBounds(x, y, 50, 30);
                //Ajout de l'image de produit
                panelProduits.add(lImage.get(i));
                lImage.get(i).setBounds(x, y, 150, 150);

                x += 200;
            } else {

                if (y == 20) {
                    y = 220;
                    x = 20;
                }
                String imagePath = "src\\com\\images\\" + produits.get(i).getNom() + ".png";
                ImageIcon icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
                        getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                lImage.add(new JLabel(icon1));
//                btnPanier.add(new JButton("Panier"));
//                panelProduits.add(btnPanier.get(i));
//                btnPanier.get(i).setBounds(x, y, 50, 30);
                panelProduits.add(lImage.get(i));
                lImage.get(i).setBounds(x, y, 150, 150);
                 //Ajout du details nom+prix
                lDetails.add(new WebLabel("" + produits.get(i).getNom() + "\t \t                " + produits.get(i).getPrix()));
                lDetails.get(i).setDrawShade(true);
                lDetails.get(i).setShadeColor(new Color(255, 128, 0));
                lDetails.get(i).setHorizontalAlignment(0);
                panelProduits.add(lDetails.get(i));
                lDetails.get(i).setBounds(x, y + 150, 150, 30);
                x += 200;
            }

        }
        imagesActions();
    }

//Ajout des action lors du clic sur les images
    private void imagesActions() {
        for (int i = 0; i < lImage.size(); i++) {
            int j = i;
            lImage.get(i).addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    imageMouseClicked(evt, j);
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    imageMouseEntered(evt, j);
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    imageMouseExited(evt, j);
                }

            });

        }
    }// end of function imagesActions
    // start of function imageMouseClicked

    private void imageMouseClicked(MouseEvent evt, int i) {

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        new DialogueDetailProduit(null, true, user.getId(), produits.get(i).getId(),lPanierCount).setVisible(true);

    }

    //end of function
    //start of function imageMouseEntred
    private void imageMouseEntered(MouseEvent evt, int i) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    //end of function
    //start of function imageMouseEntred
    private void imageMouseExited(MouseEvent evt, int i) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    private void loadTopCategories() {
        if (listCategorie.size() > 4) {
            lCat1.setText(listCategorie.get(0).getNom());
            lCat2.setText(listCategorie.get(1).getNom());
            lCat3.setText(listCategorie.get(2).getNom());
            lCat4.setText(listCategorie.get(3).getNom());
            lCat5.setText(listCategorie.get(4).getNom());
        } else {
            switch (listCategorie.size()) {
                case 1:
                    lCat1.setText(listCategorie.get(0).getNom());
                    break;
                case 2:
                    lCat1.setText(listCategorie.get(0).getNom());
                    lCat2.setText(listCategorie.get(1).getNom());
                    break;
                case 3:
                    lCat1.setText(listCategorie.get(0).getNom());
                    lCat2.setText(listCategorie.get(1).getNom());
                    lCat3.setText(listCategorie.get(2).getNom());
                    break;
                case 4:
                    lCat1.setText(listCategorie.get(0).getNom());
                    lCat2.setText(listCategorie.get(1).getNom());
                    lCat3.setText(listCategorie.get(2).getNom());
                    lCat4.setText(listCategorie.get(3).getNom());
                    break;
            }
        }
    }

    private void loadAllCategories() {
        List<Categorie> listCategorie = new CategorieDAO().findAll();
        cbCatégories.addItem("--- Tous les Catégories ---");
        for (Categorie c : listCategorie) {
            cbCatégories.addItem(c.getNom());
        }
    }

    private void inisializGrafic() {
        lCat1.setBackground(Color.white);
        lCat2.setBackground(Color.white);
        lCat3.setBackground(Color.white);
        lCat4.setBackground(Color.white);
        lCat5.setBackground(Color.white);
    }
    private void publicite(){
        
         final ComponentTransition componentTransition = new ComponentTransition ();
        // Transition effect
        final BlocksTransitionEffect effect = new BlocksTransitionEffect ();
        effect.setDirection ( Direction.random );
        effect.setType ( BlockType.cascade );
        effect.setSize ( 40 );
        effect.setSpeed ( 4 );
        effect.setFade ( false );
        componentTransition.setTransitionEffect ( effect );
        // Initial transition panel state
        panelPublicité.add(componentTransition);
        componentTransition.setBounds(0,150,270,280);
        thread=new AnimationThread(componentTransition,lNom,lDate,lType);
        thread.start();
        componentTransition.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    new DialogueDetailPublicite(null, true, thread.getPubId())
                            .setVisible(true);
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    thread.suspend();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    thread.resume();
                }

            });
    }
}
