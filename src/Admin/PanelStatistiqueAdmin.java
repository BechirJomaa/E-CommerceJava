/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import DAO.CommandeDAO;
import DAO.ProduitDAO;
import Entity.Commande;
import Entity.Produit;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Dridi
 */
public class PanelStatistiqueAdmin extends javax.swing.JPanel {

    /**
     * Creates new form PanelStatistiqueAdmin
     */
    public PanelStatistiqueAdmin() {
        initComponents();
        calculerBudget();
        bilanFinanciereParMois();
        bilanFinanciereParAns();
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Statistique");
        add(jLabel4);
        jLabel4.setBounds(300, 0, 210, 40);

        jLabel1.setBackground(new java.awt.Color(255, 146, 100));
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1162, 39);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(20, 50, 510, 330);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        add(jPanel2);
        jPanel2.setBounds(540, 50, 510, 330);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(jPanel3);
        jPanel3.setBounds(20, 400, 510, 310);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    private ChartPanel calculerBudget() {
        ProduitDAO produitDAO = new ProduitDAO();
        List<Produit> produits = new ArrayList<>();
        produits = produitDAO.findAll();
        CommandeDAO commandeDAO = new CommandeDAO();
        List<Commande> commandes = new ArrayList<>();
        commandes = commandeDAO.findAll();
        DefaultPieDataset dSet = new DefaultPieDataset();
        for (Produit produit : produits) {
            dSet.setValue(produit.getNom(), produit.getNbvente());
            System.out.println(produit.getNbvente());
        }
        JFreeChart chart = ChartFactory.createPieChart("liste des produits les plus vendus", dSet, true, true, true);
        chart.setBackgroundPaint(new Color(52, 82, 88));
        chart.getTitle().setPaint(Color.RED);
        PiePlot p = (PiePlot) chart.getPlot();
        ChartPanel cp = new ChartPanel(chart, true, true, true, true, true);
        cp.setPreferredSize(new Dimension(510, 330));
        JFrame f = new JFrame();
        f.setContentPane(cp);
        f.pack();
        jPanel2.add(cp);
        return cp;
    }
// le bilan financiere par mois

    private void bilanFinanciereParMois() {
        float janvier = 0;
        float fevrier = 0;
        float mars = 0;
        float avril = 0;
        float mai = 0;
        float juin = 0;
        float juillet = 0;
        float aout = 0;
        float septembre = 0;
        float octobre = 0;
        float novembre = 0;
        float decembre = 0;
        CommandeDAO commandeDAO = new CommandeDAO();
        List<Commande> commandes = new ArrayList<>();
        commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {

            if (commande.getDatecommande().getYear() + 1900 == 2016) {
                switch (commande.getDatecommande().getMonth()) {
                    case 0:
                        janvier += commande.getTotalcommande();
                        break;
                    case 1:
                        fevrier += commande.getTotalcommande();
                        break;
                    case 2:
                        mars += commande.getTotalcommande();
                        break;
                    case 3:
                        avril += commande.getTotalcommande();
                        break;
                    case 4:
                        mai += commande.getTotalcommande();
                        break;
                    case 5:
                        juin += commande.getTotalcommande();
                        break;
                    case 6:
                        juillet += commande.getTotalcommande();
                        break;
                    case 7:
                        aout += commande.getTotalcommande();
                        break;
                    case 8:
                        septembre += commande.getTotalcommande();
                        break;
                    case 9:
                        novembre += commande.getTotalcommande();
                        break;
                    case 10:
                        octobre += commande.getTotalcommande();
                        break;
                    case 11:
                        decembre += commande.getTotalcommande();
                        break;
                }
            }
        }
        DefaultCategoryDataset dSet = new DefaultCategoryDataset();
        dSet.addValue(janvier, "Janvier", "Janvier");
        dSet.addValue(fevrier, "Fevrier", "Fevrier");
        dSet.addValue(mars, "Mars", "Mars");
        dSet.addValue(avril, "Avril", "Avril");
        dSet.addValue(mai, "Mai", "Mai");
        dSet.addValue(juin, "Juin", "Juin");
        dSet.addValue(juillet, "Juillet", "Juillet");
        dSet.addValue(aout, "Aout", "Aout");
        dSet.addValue(septembre, "Septembre", "Janvier");
        dSet.addValue(octobre, "Octobre", "Fevrier");
        dSet.addValue(novembre, "Novemvre", "Novembre");
        dSet.addValue(decembre, "Decembre", "Decembre");
        JFreeChart chart = ChartFactory.createBarChart("Rapport financier", "Révenus", "Montant (DT)", dSet, PlotOrientation.VERTICAL, true, true, true);
        chart.setBackgroundPaint(new Color(52, 82, 88));

        chart.getTitle().setPaint(Color.RED);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);

        ChartPanel cp = new ChartPanel(chart, true, true, true, false, true);
        cp.setPreferredSize(new Dimension(510, 330));
        ChartFrame f = new ChartFrame("try", chart);
        //JFrame f =new JFrame();
        f.setContentPane(cp);
        f.pack();
        //f.setVisible(true);
        // f.setSize(panelRevDep.getWidth()-20,panelRevDep.getHeight()-20);
        // f.setVisible(true);
        // panelRevDep.removeAll();
        //panelRevDep.repaint();
        jPanel1.add(cp);

    }
// le bilan financiere pour les 5 dernieres années

    private void bilanFinanciereParAns() {
        float firstYear = 0;
        float secondYear = 0;
        float thirdYear = 0;
        float forthYear = 0;
        float fiveYear = 0;
        CommandeDAO commandeDAO = new CommandeDAO();
        List<Commande> commandes = new ArrayList<>();
        commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {

            if (commande.getDatecommande().getYear() + 1900 == 2016) {
                fiveYear += commande.getTotalcommande();
            } else if (commande.getDatecommande().getYear() + 1900 == 2015) {
                forthYear += commande.getTotalcommande();
            } else if (commande.getDatecommande().getYear() + 1900 == 2014) {
                thirdYear += commande.getTotalcommande();
            } else if (commande.getDatecommande().getYear() + 1900 == 2013) {
                secondYear += commande.getTotalcommande();
            } else if (commande.getDatecommande().getYear() + 1900 == 2012) {
                firstYear += commande.getTotalcommande();
            }
        }
        DefaultCategoryDataset dSet = new DefaultCategoryDataset();
        dSet.addValue(firstYear, "2012", "2012");
        dSet.addValue(secondYear, "2013", "2013");
        dSet.addValue(thirdYear, "2014", "2014");
        dSet.addValue(forthYear, "2015", "2015");
        dSet.addValue(fiveYear, "2016", "2016");

        JFreeChart chart = ChartFactory.createBarChart("Rapport financier", "Révenus", "Montant (DT)", dSet, PlotOrientation.VERTICAL, true, true, true);
        chart.setBackgroundPaint(new Color(52, 82, 88));
        chart.getTitle().setPaint(Color.RED);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartPanel cp = new ChartPanel(chart, true, true, true, false, true);
        cp.setPreferredSize(new Dimension(510, 330));
        ChartFrame f = new ChartFrame("try", chart);
        //JFrame f =new JFrame();
        f.setContentPane(cp);
        f.pack();
        //f.setVisible(true);
        // f.setSize(panelRevDep.getWidth()-20,panelRevDep.getHeight()-20);
        // f.setVisible(true);
        // panelRevDep.removeAll();
        //panelRevDep.repaint();
        jPanel3.add(cp);

    }

}