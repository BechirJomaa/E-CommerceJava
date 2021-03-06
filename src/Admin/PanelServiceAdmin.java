/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import DAO.ServiceDao;
import Entity.Produit;
import Entity.Service;
import Utile.coucheMetier;
import com.alee.extended.button.WebSwitch;
import com.alee.laf.label.WebLabel;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;

/**
 *
 * @author Dridi
 */
public class PanelServiceAdmin extends javax.swing.JPanel {

    private List<Service> services = new ArrayList<>();
    private final List<JLabel> lDelete = new ArrayList<>();
    private final List<JLabel> lNom = new ArrayList<>();
    private final List<JLabel> lEstimation = new ArrayList<>();
    private final List<JLabel> lbCategories = new ArrayList<>();
    private final List<JLabel> lMail = new ArrayList<>();
    private final List<JLabel> lAdresse = new ArrayList<>();
    private final List<JLabel> lDetails = new ArrayList<>();
    private final List<JLabel> lTelephone = new ArrayList<>();
    private final List<JLabel> lDescription = new ArrayList<>();
    private final List<JLabel> lCategories = new ArrayList<>();
    private final List<WebSwitch> sValider = new ArrayList<>();
    private final List<JSeparator> separateur = new ArrayList<>();

    /**
     * Creates new form PanelServiceAdmin
     */
    public PanelServiceAdmin() {
        initComponents();
        services = new ServiceDao().findAllServicesInvalid();
        loadServices();
        setBounds(0, 0, 1162, 768);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Estimation = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(188, 188, 188));
        jLabel2.setForeground(new java.awt.Color(188, 188, 188));
        jLabel2.setText("Nom");
        add(jLabel2);
        jLabel2.setBounds(50, 50, 40, 14);

        jLabel3.setBackground(new java.awt.Color(188, 188, 188));
        jLabel3.setForeground(new java.awt.Color(188, 188, 188));
        jLabel3.setText("Description");
        add(jLabel3);
        jLabel3.setBounds(150, 50, 90, 14);

        Estimation.setBackground(new java.awt.Color(188, 188, 188));
        Estimation.setForeground(new java.awt.Color(188, 188, 188));
        Estimation.setText("Prix unitaire");
        add(Estimation);
        Estimation.setBounds(260, 50, 70, 14);

        jLabel7.setBackground(new java.awt.Color(188, 188, 188));
        jLabel7.setForeground(new java.awt.Color(188, 188, 188));
        jLabel7.setText("Catégorie");
        add(jLabel7);
        jLabel7.setBounds(380, 50, 70, 14);

        jLabel8.setBackground(new java.awt.Color(188, 188, 188));
        jLabel8.setForeground(new java.awt.Color(188, 188, 188));
        jLabel8.setText("Telephone");
        add(jLabel8);
        jLabel8.setBounds(670, 50, 100, 14);

        jLabel6.setBackground(new java.awt.Color(188, 188, 188));
        jLabel6.setForeground(new java.awt.Color(188, 188, 188));
        jLabel6.setText("Action");
        add(jLabel6);
        jLabel6.setBounds(810, 50, 100, 14);

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Liste des produits");
        add(jLabel4);
        jLabel4.setBounds(300, 0, 210, 40);

        jLabel1.setBackground(new java.awt.Color(255, 146, 100));
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1162, 39);

        jLabel9.setBackground(new java.awt.Color(188, 188, 188));
        jLabel9.setForeground(new java.awt.Color(188, 188, 188));
        jLabel9.setText("Mail");
        add(jLabel9);
        jLabel9.setBounds(530, 50, 70, 14);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Estimation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    private void loadServices() {
        services = new ServiceDao().findAllServicesInvalid();
        if (services.size() > 0) {
            // setPreferredSize(new Dimension(100, produits.size() * 182));
            int x = 10;
            int y = 100;
            for (int i = 0; i < services.size(); i++) {

                //Ajout de l'image
                Service p = new ServiceDao().findServiceById(services.get(i).getId());
                String imagePath = "src\\com\\images\\" + p.getNom() + ".png";
                ImageIcon icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
                        getScaledInstance(80, 70, Image.SCALE_DEFAULT));
                //Ajout du nom du produit
                lNom.add(new JLabel(p.getNom()));
                add(lNom.get(i));
                lNom.get(i).setBounds(x + 30, y + 20, 90, 30);
                //Ajout de la description
                lDescription.add(new JLabel(p.getDescription()));
                add(lDescription.get(i));
                lDescription.get(i).setBounds(x + 140, y + 20, 100, 30);
                //Ajout du prix unitaire
                lEstimation.add(new JLabel(p.getEstimation() + " DT"));
                add(lEstimation.get(i));
                lEstimation.get(i).setBounds(x + 260, y + 20, 60, 30);

                //Ajout du categories        
                lbCategories.add(new JLabel(p.getCategorie().getDescription()));
                add(lbCategories.get(i));
                lbCategories.get(i).setBounds(x + 360, y + 20, 100, 30);
                //Ajout du mail        
                lMail.add(new JLabel(p.getMail()));
                add(lMail.get(i));
                lMail.get(i).setBounds(x + 480, y + 20, 150, 30);
                //Ajout du telephone        
                lTelephone.add(new JLabel(p.getTelephone() + ""));
                add(lTelephone.get(i));
                lTelephone.get(i).setBounds(x + 660, y + 20, 100, 30);
                //Ajout du bouuton plus de détails
//                imagePath = "images\\add.png";
//                icon1 = new ImageIcon(new ImageIcon(imagePath).getImage().
//                getScaledInstance(20, 20, Image.SCALE_DEFAULT));
//                lDetails.add(new JLabel(icon1));
//                add(lDetails.get(i));
//                lDetails.get(i).setBounds(x + 690, y + 20, 30, 30);
                //ajout du bouton pour la supprission
                lDelete.add(new JLabel(new ImageIcon("images\\closeEntred.png")));
                add(lDelete.get(i));
                lDelete.get(i).setBounds(x + 780, y + 20, 30, 20);
                //Validation du service
                sValider.add(new WebSwitch());
                sValider.get(i).setRound(11);
                sValider.get(i).setLeftComponent(new WebLabel(new ImageIcon("images\\error.png")));
                sValider.get(i).setRightComponent(new WebLabel(new ImageIcon("images\\ok.png")));
                add(sValider.get(i));
                sValider.get(i).setBounds(x + 820, y + 20, 60, 30);
                //Ajout du separateur
                separateur.add(new JSeparator());
                add(separateur.get(i));
                separateur.get(i).setBounds(0, y + 82, 1162, 10);
                y += 100;
            }

        }
        Actions();
    }

    private void Actions() {
        for (int i = 0; i < services.size(); i++) {
            int j = i;
            lDelete.get(j).addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    deleteMouseClicked(evt, j);
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    deleteMouseEntered(evt, j);
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    deleteMouseExited(evt, j);
                }

            });
//            lDetails.get(i).addMouseListener(new java.awt.event.MouseAdapter() {
////                @Override
//                public void mouseClicked(java.awt.event.MouseEvent evt) {
//                    detailMouseClicked(evt, j);
//                }
//
//                @Override
//                public void mouseEntered(java.awt.event.MouseEvent evt) {
//                    detailMouseEntered(evt, j);
//                }
//
//                @Override
//                public void mouseExited(java.awt.event.MouseEvent evt) {
//                    detailMouseExited(evt, j);
//                }
//
//            });

            sValider.get(i).addMouseListener(new java.awt.event.MouseAdapter() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btnValiderMouseClicked(evt, j);
                }

            });

        }
    }

    private void deleteMouseClicked(MouseEvent evt, int i) {

        new ServiceDao().removeServiceById(services.get(i).getId());
        services.remove(i);
        // favoris = user.getFavoris();
        removeAll();
        repaint();
        revalidate();
        initComponents();
        loadServices();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    private void deleteMouseEntered(MouseEvent evt, int j) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    private void deleteMouseExited(MouseEvent evt, int j) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

//    private void detailMouseClicked(MouseEvent evt, int i) {
//    }
//
//    private void detailMouseEntered(MouseEvent evt, int j) {
//        setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//    }
//
//    private void detailMouseExited(MouseEvent evt, int j) {
//        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//    }
    private void btnValiderMouseClicked(MouseEvent evt, int j) {

        new ServiceDao().validerService(services.get(j).getId());
        System.out.println("cccccccccc");

    }

}
