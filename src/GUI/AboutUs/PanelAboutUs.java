/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AboutUs;

import DAO.UserDAO;
import Entity.User;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


/**
 *
 * @author gafsi
 */
public class PanelAboutUs extends javax.swing.JPanel {

    /**
     * Creates new form PanelForum
     */
    private static int userId;
    private final User user;
    private static String CheminVlc="C:\\Program Files\\VideoLAN\\VLC";
    private EmbeddedMediaListPlayerComponent mediaPlayer;
    private JFrame f;
    public PanelAboutUs(int userid ,JFrame f) {
        PanelAboutUs.userId = userid;
        this.f=f;
        user = new UserDAO().findUserById(userid);
        initComponents();
        loadVideo();
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 5));
        jPanel1.setLayout(null);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 40, 73, 23);

        add(jPanel1);
        jPanel1.setBounds(10, 40, 550, 460);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 5));
        jPanel2.setLayout(new java.awt.BorderLayout());
        add(jPanel2);
        jPanel2.setBounds(590, 40, 690, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          JFileChooser fileChooser = new JFileChooser();
 
        // Afficher le JFileChooser
        int etat = fileChooser.showOpenDialog( null );
 
        // Si un fichier a été sélectionné
        if ( etat == JFileChooser.APPROVE_OPTION ) 
        {
           URL fichierVideo = null;
 
              try {
                  fichierVideo = fileChooser.getSelectedFile().toURL();
                  System.out.println(fichierVideo);
              } catch (MalformedURLException ex) {
                  Logger.getLogger(PanelAboutUs.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
private void loadVideo(){

        URL url_media;
        try {
            url_media = new URL("file:\\D:\\mes projets\\Java\\javaAllForDeal\\AllForDeal\\images\\phoneGap.avi");
        } catch (MalformedURLException ex) {
            url_media=null;
            Logger.getLogger(PanelAboutUs.class.getName()).log(Level.SEVERE, null, ex);
        }
        Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );
        try
        {
 
           // Créer un lecteur pour lire le fichier specifié    
           Player mediaPlayer = Manager.createRealizedPlayer( url_media );
 
           // Créer les composants de video et de contrôle PlaysBack
           Component video = mediaPlayer.getVisualComponent();           
           Component controles = mediaPlayer.getControlPanelComponent();  
 
           // Ajouter les composants  dans le JPanel
           if ( video != null )
              jPanel2.add( video, BorderLayout.CENTER );
 
           if ( controles != null )
              jPanel2. add( controles, BorderLayout.SOUTH );
 
           // Lancer la lecture de fichier sélectionné 
           mediaPlayer.start(); 
           
        } 
        catch ( Exception err )
        {
           System.err.println( "Erreur: "+err );
        } 
        
}
}
